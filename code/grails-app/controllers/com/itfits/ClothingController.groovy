package com.itfits

class ClothingController {

    def clothingService

    def index = { }

    def find = {
        clothingService.findClothing(params.brand,params.type,params.size)
    }


}
