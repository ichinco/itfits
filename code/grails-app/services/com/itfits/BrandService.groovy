package com.itfits

class BrandService {

    static transactional = true

    def findBrand(String brandName) {
        ClothingBrand brand = ClothingBrand.findByBrandName(brandName)

        if (!brand){
            brand = new ClothingBrand([brandName:brandName])
            brand.save()
        }

        return brand
    }

    def getSuggestionsForBrand(String brandName){
        return ClothingBrand.executeQuery("select b.brandName from ClothingBrand b where b.brandName LIKE '${brandName}%'").collect {
            def expando = new Expando()
            expando.suggestion = it
        }
    }
}
