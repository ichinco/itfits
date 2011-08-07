package com.itfits

class OutfitController {

    def outfitService

    def index = { }
    def create = {
        Outfit outfit;
        if (params.outfitId){
            outfit = Outfit.get(params.outfitId)
        } else {
            outfit = new Outfit();
        }

        def model = [:]
        model.outfit = outfit

        model
    }

    def createOutfit = {
        int userId = Integer.parseInt(params.userId);
        List<Integer> clothingIds = params.clothing ? params.clothing.split(",").each({Integer.parseInt(it)}) : []
        String name = params.name;
        String description = params.description;
        outfitService.createOutfit(userId, clothingIds, name, description);
        redirect(controller:"user", action:"dashboard")
    }

    def changeOutfit = {
        int outfitId = Integer.parseInt(params.outfitId);
        List<Integer> clothingIds = params.clothing ? params.clothing.split(",").each({Integer.parseInt(it)}) : []
        outfitService.changeClothes(outfitId, clothingIds)
    }

    def deleteOutfit = {
        int outfitId = Integer.parseInt(params.outfitId);
        int userId = Integer.parseInt(params.userId);

        outfitService.deleteOutfit(outfitId, userId);
    }
}
