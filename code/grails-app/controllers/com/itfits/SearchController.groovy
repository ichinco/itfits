package com.itfits

class SearchController {

    def index = {
        // if no cloths, return [], otherwise all the cloths in the db
        List<Clothing> clothes = (Clothing.count() > 0)? Clothing.findAllWhere(isClothing:true) : [];

        def model = [:]
        model["clothes"] = clothes
        model["occasions"] = VoteType.findAllByType("occasion").collect { it.name }
        model["styles"] = VoteType.findAllByType("style").collect { it.name }

        render(view:"/search/result", model:model)
    }
}
