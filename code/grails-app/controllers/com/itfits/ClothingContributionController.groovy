package com.itfits

class ClothingContributionController {

    def userContributionService

    def index = { }

    def owned = {
        def size = params.size
        def clothingId = Integer.parseInt(params.clothingId)
        def userId = Integer.parseInt(params.userId)

        userContributionService.createContribution(User.get(userId), Clothing.get(clothingId), size)

        def model = [:]
        model.clothing = Clothing.get(clothingId)
        model.contribution = UserClothingContribution.findByClothingAndUser(Clothing.get(clothingId),User.get(userId))

        render(view:'createMeasurements', model:model)
    }

    def addMeasurements = {
        def clothingId = Integer.parseInt(params.clothingId)
        def userId = Integer.parseInt(params.userId)
        UserClothingContribution contribution = UserClothingContribution.findByClothingAndUser(Clothing.get(clothingId),User.get(userId))
        Clothing clothing = Clothing.get(clothingId)
        clothing.type.relevantDimensions.each {
            userContributionService.createMeasurement(it.measurementType,
            Double.parseDouble(params.get("measurement_${it.measurementType}".toString()).toString()),
            MeasurementDegree.JUST_RIGHT, contribution)
        }

        redirect(controller:'clothing', action:'show', params:['clothingId':clothingId])
    }
}
