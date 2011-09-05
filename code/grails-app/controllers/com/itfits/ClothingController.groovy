package com.itfits

import grails.plugins.springsecurity.Secured
import javax.servlet.http.Cookie
import grails.util.GrailsConfig

class ClothingController {

    def clothingService
    def tagService
    def materialsService
    def brandService
    def userContributionService
    def springSecurityService

    def index = { }

    def find = {
        clothingService.findClothing(params.brand,params.type,params.size)
    }

    @Secured(["ROLE_USER"])
    def create = {
        // find comparable in db
        Clothing clothing
        UserClothingContribution contribution
        if (params.clothingId){
            clothing = Clothing.get(params.clothingId)
            contribution = userContributionService.createContribution((User) springSecurityService.currentUser, clothing)
        } else {
            clothing = new Clothing()
            def materials = []
            materials.add(new ClothingMaterial())
            clothing.materials = materials
            contribution = new UserClothingContribution();
        }

        def model = [:]
        model["clothing"] = clothing
        model["user"] = springSecurityService.currentUser
        model["contribution"] = contribution

        // if not found
        render(view:"/clothing/create", model:model)
    }

    def save = {
        ClothingBrand brand = brandService.findBrand(params.brand)

        def materials = []
        def materialIndex = 0
        while (params.get("materialType${materialIndex}".toString())){
            materials.add(materialsService.findMaterial(params.get("materialType${materialIndex}".toString()).toString(), Integer.parseInt(params.get("materialComposition${materialIndex}".toString()).toString())))
            materialIndex++
        }

        def model = [:]
        model["brand"] = brand
        model["materials"] = materials
        model["type"] = ClothingType.valueOf(params.clothingType)

        model["isWaterproof"] = params.waterproof=="on"
        model["isShear"] = params.shear=="on"
        model["tags"] = params.tags.split(' ').collect {tagService.findTag(it.toString())}

        Clothing clothing
        if (params.clothingId){
            clothing = clothingService.editClothing(Long.parseLong(params.clothingId),model)
        } else {
            clothing = clothingService.createClothing(model)
        }

        UserClothingContribution contribution = userContributionService.createContribution(User.get(Long.parseLong(params.userId)), clothing, params.size)
        model["measurements"] = ClothingType.valueOf(params.clothingType).relevantDimensions.collect {
            userContributionService.createMeasurement(it.measurementType,
            Double.parseDouble(params.get("measurement_${it.measurementType}".toString()).toString()),
            MeasurementDegree.JUST_RIGHT, contribution)
        }

        redirect (action:show, params:[id: clothing.id])
    }

    def notClothes = {
        clothingService.notClothes(Long.parseLong(params.clothingId))

        render(text:"")
    }

    def show = {
        def id = params.clothingId
        Clothing clothing = Clothing.get(id)
        User user = springSecurityService.currentUser

        def styles = []
        def occasions = []
        for (VoteRecord record : clothing.votes){
            def upvoted = (user && user.upvoted.contains(record));
            def downvoted = (user && user.downvoted.contains(record));
            def recordMap = [record : record,
                            upvoted: upvoted,
                            downvoted: downvoted]
            switch(record.type.type){
                case "style":
                    styles.add(recordMap);
                    break;
                case "occasion":
                    occasions.add(recordMap);
                    break;
            }
        }

        def recentlyViewedCookie = g.cookie(name: GrailsConfig.itfits.cookie.recentlyViewedClothes)
        if (recentlyViewedCookie){
            List<String> array = recentlyViewedCookie.split(",").toList()
            array.removeAll(clothing.id.toString())
            recentlyViewedCookie = clothing.id + "," + array.join(",")
        } else {
            recentlyViewedCookie = clothing.id
        }
        def cookie = new Cookie(GrailsConfig.itfits.cookie.recentlyViewedClothes, recentlyViewedCookie)
        response.addCookie(cookie)

        def model = [:]
        model["clothing"] = clothing
        model["styles"] = styles.sort { }
        model["occasions"] = occasions

        render(view:"/clothing/show", model:model)
    }

    def updateMeasurements = {
        ClothingType newType = ClothingType.valueOf(params.type)

        def model = [:]
        model['dimensions'] = newType.relevantDimensions
        model['contribution'] = new UserClothingContribution()

        render(view:"/clothing/_measurements", model:model)
    }
}
