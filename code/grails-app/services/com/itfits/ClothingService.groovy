package com.itfits

class ClothingService {

    static transactional = true

    // got to be a better way to do this
    def findClothing(String brand, String type, String size){
        def clothes = Clothing.findAllByBrand(brand)

        def matchingClothes = []
        for (Clothing clothing in clothes) {
            boolean matches = true
            String[] types = clothing.type.split(" ")
            for (String atype in types){
                if (!type.contains(atype)){
                    matches = false
                    break;
                }
            }

            matches = matches && clothing.size.equals(size)

            if (matches){
                matchingClothes.add(clothing)
            }
        }

        return matchingClothes
    }
}
