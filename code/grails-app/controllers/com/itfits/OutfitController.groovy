package com.itfits

import grails.util.GrailsConfig

class OutfitController {

    def outfitService

    def index = { }
    def create = {
        Outfit outfit;
        if (params.outfitId){
            outfit = Outfit.get(params.outfitId)
        } else {
            outfit = new Outfit();
            if (params.clothing){
                List<Clothing> clothes = params.clothing.split(",").collect({Clothing.get(Integer.parseInt(it))})
                outfit.cloths = clothes
            }
        }

        def model = [:]
        model.outfit = outfit
        def recentlyViewedItems =  session.recentlyViewedClothes
        if (recentlyViewedItems){
            model.recentlyViewed = recentlyViewedItems.split(",").collect({
                Clothing.get(Integer.parseInt(it))
            })
        } else {
            model.recentlyViewed = []
        }

        return model
    }
    def add = {
        def model = [:]
        model.item = Clothing.get(Integer.parseInt(params.clothing))
        return model
    }

    def view = {
        def model = [:]
        model.outfit = Outfit.get(params.outfitId)

        return model
    }

    def createOutfit = {
        int userId = Integer.parseInt(params.userId);
        List<Integer> clothingIds = params.clothing ? params.clothing.split(",").collect({Integer.parseInt(it)}) : []
        String name = params.name;
        String description = params.description;
        outfitService.createOutfit(userId, clothingIds, name, description);
        redirect(controller:"user", action:"dashboard")
    }

    def changeOutfit = {
        int outfitId = Integer.parseInt(params.outfitId);
        List<Integer> clothingIds = params.clothing ? params.clothing.split(",").collect({Integer.parseInt(it)}) : []
        outfitService.changeClothes(outfitId, clothingIds)
    }

    def deleteOutfit = {
        int outfitId = Integer.parseInt(params.outfitId);
        int userId = Integer.parseInt(params.userId);

        outfitService.deleteOutfit(outfitId, userId);
    }
}
