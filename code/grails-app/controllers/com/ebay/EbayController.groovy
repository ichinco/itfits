package com.ebay

class EbayController {

    def ebayItemSearchService

    def index = {
        ebayItemSearchService.doApparelItemSearch(Integer.parseInt(["page"]))
        redirect(controller:"search", action:"index")
    }
}
