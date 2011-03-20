package com.itfits

class ClothingController {

    def clothingService
    def tagService

    def index = { }

    def find = {
        clothingService.findClothing(params.brand,params.type,params.size)
    }

    def create = {
        // find comparable in db
        Clothing clothing
        if (params.clothingId){
            clothing = Clothing.get(params.clothingId)
        } else {
            clothing = new Clothing()
            def materials = []
            materials.add(new ClothingMaterial())
            clothing.materials = materials
        }

        def model = [:]
        model["clothing"] = clothing

        // if not found
        render(view:"/clothing/create", model:model)
    }

    def save = {
        ClothingBrand brand = new ClothingBrand([brandName:params.brand])
        brand.save()

        def materials = []
        ClothingMaterial mat1 = new ClothingMaterial([name:"cotton",percentComposition:10])
        ClothingMaterial mat2 = new ClothingMaterial([name:"rayon",percentComposition:90])
        mat1.save()
        mat2.save()

        materials.add(mat1)
        materials.add(mat2)

        def model = [:]
        model["brand"] = brand
        model["materials"] = materials
        model["type"] = ClothingType.valueOf(params.clothingType)
        model["isWaterproof"] = params.waterproof=="on"
        model["isShear"] = params.shear=="on"
        model["size"] = params.size
        model["tags"] = params.tags.split(' ').collect {tagService.findTag(it.toString())}

        Clothing clothing
        if (params.clothingId){
            clothing = clothingService.editClothing(Long.parseLong(params.clothingId),model)
        } else {
            clothing = clothingService.createClothing(model)
        }

        redirect (action:show, params:[id: clothing.id])
    }

    def show = {
        def id = params.clothingId
        Clothing clothing = Clothing.get(id)

        def model = [:]
        model["clothing"] = clothing

        render(view:"/clothing/show", model:model)
    }


}
