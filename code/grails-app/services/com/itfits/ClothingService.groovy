package com.itfits

class ClothingService {

    static transactional = true

    def createClothing(model) {
        Clothing clothing = new Clothing()
        return updateClothing(clothing, model)
    }

    def editClothing(long id, model){
        Clothing clothing = Clothing.get(id)
        return updateClothing(clothing, model)
    }

    def notClothes(long id){
        Clothing clothing = Clothing.get(id)
        clothing.isClothing = false
        clothing.save()
    }

    private updateClothing(Clothing clothing, model){
        model.each {
            clothing.setProperty(it.key, it.value)
        }

        clothing.save()

        return clothing
    }

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
