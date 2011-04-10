package com.itfits

class SearchController {

    def index = {
        List<Clothing> clothes = [];

        if(Clothing.count() > 0)
            clothes = Clothing.all

        def model = [:]
        model["clothes"] = clothes

        render(view:"/search/result", model:model)
    }
}
