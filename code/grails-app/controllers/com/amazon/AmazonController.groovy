package com.amazon

class AmazonController {

    def amazonItemSearchService

    def index = {
        amazonItemSearchService.doApparelItemSearch(1);

        redirect(controller:"search", action:"index")
    }
}
