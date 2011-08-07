package com.amazon

import java.nio.ByteBuffer
import grails.util.GrailsConfig
import java.text.SimpleDateFormat
import java.text.DateFormat
import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import groovyx.net.http.*
import static groovyx.net.http.ContentType.JSON
import static groovyx.net.http.ContentType.XML
import com.itfits.Clothing
import com.itfits.ClothingBrand
import com.itfits.ClothingType

class AmazonItemSearchService {

    static transactional = true

    def doApparelItemSearch(int page) {
        getAmazonUrl(GrailsConfig.itfits.amazon.searchUrl.replace("[responseGroup]", GrailsConfig.itfits.amazon.responseGroup).replace("[page]", page.toString()),
                { resp, json ->
                    if (json.Items.Request.IsValid.equals("True") && json.Items.Errors.size.equals('')){
                        json.Items.Item.each({
                            if (!Clothing.findByMerchantId(it.ASIN.toString()) && it){
                                Clothing clothing = new Clothing()
                                clothing.merchantId = it.ASIN.toString()
                                clothing.purchaseUrl = it.DetailPageUrl.toString()
                                clothing.imageUrl = it.MediumImage.URL.toString()

                                ClothingBrand brand = ClothingBrand.findByBrandName(it.ItemAttributes.Brand.toString())
                                if (!brand){
                                    brand = new ClothingBrand()
                                    brand.brandName = it.ItemAttributes.Brand
                                    brand.save()
                                }

                                clothing.brand = brand
                                clothing.price = it.OfferSummary.LowestNewPrice.FormattedPrice

                                try{
                                    ClothingType type = ProductTypeName.valueOf(it.ItemAttributes.ProductTypeName.toString()).getType()
                                    clothing.type = type
                                } catch (Exception e){
                                    clothing.type = null
                                    System.out.println("Unknown type: " + it.ItemAttributes.ProductTypeName);
                                }

                                clothing.style = it.ItemAttributes.Title
                                if (clothing.type != null){
                                    clothing.save()
                                }
                            }
                        })
                    } else {
                        throw new RuntimeException("amazon product search failed.")
                    }
                })
    }

    def getAmazonUrl(String url, success) {
        def signatureHelper = new SignedRequestsHelper(GrailsConfig.itfits.amazon.accessKeySecret)
        def paramMap = [:]
        url.split('\\?')[1].split("&").each {
            def entry = it.split("=")
            paramMap[entry[0]] = entry[1]
        }
        def finalUrl = signatureHelper.sign(paramMap)

        def http = new HTTPBuilder(finalUrl)
        http.request(Method.GET, XML) {
            response.success = success
        }
    }
}
