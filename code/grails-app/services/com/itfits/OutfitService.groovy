package com.itfits

class OutfitService {

    static transactional = true

    def createOutfit(long userId, List<Integer> clothes, String name, String description) {
        Outfit outfit = new Outfit();
        outfit.cloths = clothes.collect { Clothing.get(it) }
        outfit.description = description;
        outfit.name = name;
        outfit.save();
        User user = User.get(userId);
        user.outfits.add(outfit);
        user.save();
    }

    def changeClothes(int id, List<Integer> clothes){
        Outfit outfit = Outfit.get(id);
        outfit.cloths = clothes.collect { Clothing.get(it) };
        outfit.save()
    }

    def deleteOutfit(long outfitId, long userId){
        Outfit outfit = Outfit.get(outfitId);
        User user = User.get(userId);
        user.outfits.remove(outfit);
        user.save()

        outfit.delete()
    }
}
