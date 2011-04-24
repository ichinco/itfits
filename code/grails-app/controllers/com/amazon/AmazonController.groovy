package com.amazon

class AmazonController {

    def amazonItemSearchService

    def index = {
        amazonItemSearchService.doApparelItemSearch(Integer.parseInt(params["page"]));

        redirect(controller:"search", action:"index")
    }
}
