package com.itfits

class SearchController {

    def index = {
        // if no cloths, return [], otherwise all the cloths in the db
        List<Clothing> clothes = (Clothing.count() > 0)? Clothing.all : [];

        def model = [:]
        model["clothes"] = clothes

        render(view:"/search/result", model:model)
    }
}
