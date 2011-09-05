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
}
