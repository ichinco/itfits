package com.itfits

class ClothingController {

    def clothingService

    def index = { }

    def find = {
        clothingService.findClothing(params.brand,params.type,params.size)
    }

    def create = {
        // find comparable in db

        // if not found
        render(view:"/clothing/create")
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

        Clothing clothing = clothingService.createClothing(brand, materials, ClothingType.valueOf(params.clothingType), params.size, params.waterproof=="true", params.shear=="true")

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
