package com.itfits

class ClothingController {

    def clothingService

    def index = { }

    def find = {
        clothingService.findClothing(params.brand,params.type,params.size)
    }

    def save = {
        ClothingBrand brand = new ClothingBrand([brandName:"AwesomeK"])
        brand.save()

        Clothing clothing = new Clothing()
        clothing.brand = brand
        clothing.type = ClothingType.PANTS
        clothing.size = "really big"

        def materials = []
        ClothingMaterial mat1 = new ClothingMaterial([name:"cotton",percentComposition:10])
        ClothingMaterial mat2 = new ClothingMaterial([name:"rayon",percentComposition:90])
        mat1.save()
        mat2.save()

        materials.add(mat1)
        materials.add(mat2)

        clothing.materials = materials

        clothing.save()

        render (clothing.id.toString())
    }

    def show = {
        def id = params.clothingId
        Clothing clothing = Clothing.get(id)

        def model = [:]
        model["clothing"] = clothing

        render(view:"/clothing/show", model:model)
    }


}
