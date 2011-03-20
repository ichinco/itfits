package com.itfits

class SearchController {

    def index = {
        List<Clothing> clothes = Clothing.all

        def model = [:]
        model["clothes"] = clothes

        render(view:"/search/result", model:model)
    }
}
