package com.ebay

import groovyx.net.http.HTTPBuilder
import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.ContentType.XML
import groovyx.net.http.*
import grails.util.GrailsConfig
import com.itfits.Clothing

class EbayItemSearchService {

    static transactional = true

    def doApparelItemSearch(int page) {

        def url = GrailsConfig.itfits.ebay.searchUrl
        def http = new HTTPBuilder(url)
        http.request(Method.GET, XML) {
            response.success = {resp, xml ->
                xml.searchResult.item.each{
                    def id = it.itemId.toString()
                    if (!Clothing.findByMerchantId(id)){
                        Clothing clothing = new Clothing()
                        clothing.style = it.title.toString()
                        clothing.imageUrl = it.galleryURL.toString()
                        clothing.purchaseUrl = it.viewItemURL.toString()
                        clothing.merchantId = id.toString()
                        clothing.price = it.sellingStatus.convertedCurrencyPrice.toString()

                        clothing.save()
                    }
                }
            }
        }
    }
}
