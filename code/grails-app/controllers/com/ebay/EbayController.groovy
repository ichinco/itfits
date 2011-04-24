package com.ebay

class EbayController {

    def ebayItemSearchService

    def index = {
        ebayItemSearchService.doApparelItemSearch(1)
        redirect(controller:"search", action:"index")
    }
}
