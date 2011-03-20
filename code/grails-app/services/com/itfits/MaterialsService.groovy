package com.itfits

class MaterialsService {

    static transactional = true

    def findMaterial(String materialName, int percentComposition) {
        ClothingMaterial material = ClothingMaterial.findByNameAndPercentComposition(materialName, percentComposition)

        if (!material){
            material = new ClothingMaterial([name:materialName, percentComposition: percentComposition])
            material.save()
        }

        return material
    }
}
