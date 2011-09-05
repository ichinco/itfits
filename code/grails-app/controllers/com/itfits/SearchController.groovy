package com.itfits

class SearchController {

    def searchService
    def springSecurityService

    def index = {
        // if no cloths, return [], otherwise all the cloths in the db
        List<Clothing> clothes = (Clothing.count() > 0)? Clothing.findAllWhere(isClothing:true) : [];

        def model = [:]
        model["clothes"] = clothes
        model["occasions"] = VoteType.findAllByType("occasion").collect { it.name }
        model["styles"] = VoteType.findAllByType("style").collect { it.name }

        render(view:"/search/result", model:model)
    }

    def search = {
        def clothingType = params.clothingType == "all" ? null : ClothingType.getByDisplayName(params.clothingType)
        def occasion = params.occasion == "all" ? null : VoteType.findByNameAndType(params.occasion,"occasion")
        def style = params.style == "all" ? null : VoteType.findByNameAndType(params.style,"style")
        def price = params.price
        def lowPrice = Integer.MIN_VALUE
        def highPrice = Integer.MAX_VALUE
        if (price.contains("Under")){
            highPrice = Integer.parseInt(price.split('$')[1])
        } else if (price.contains("above")){
            lowPrice = Integer.parseInt(price.split(" ")[0].replace('$', ''))
        } else if (price.contains("-")) {
            def split = price.replace('$','').split(" - ")
            lowPrice = Integer.parseInt(split[0])
            highPrice = Integer.parseInt(split[1])
        }

        def cloths = searchService.findBy(springSecurityService.currentUser,
                            occasion, style, clothingType,
                            lowPrice, highPrice, null)
        def model = [:]
        model["clothes"] = cloths
        model["occasions"] = VoteType.findAllByType("occasion").collect { it.name }
        model["styles"] = VoteType.findAllByType("style").collect { it.name }

        render(view:"/search/result", model:model)
    }
}
