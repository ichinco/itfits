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
        getAmazonUrl(GrailsConfig.itfits.amazon.searchUrl.replace("[responseGroup]",
                                                                GrailsConfig.itfits.amazon.responseGroup),
                { resp, json ->
                    if (json.Items.Request.IsValid.equals("True") && !json.Items.Errors){
                        json.Items.Item.each({
                            if (!Clothing.findByMerchantId(it.ASIN)){
                                Clothing clothing = new Clothing()
                                clothing.merchantId = it.ASIN
                                clothing.style =
                                clothing.purchaseUrl = it.DetailPageUrl
                                clothing.imageUrl = it.MediumImage.URL

                                ClothingBrand brand = ClothingBrand.findByBrandName(it.ItemAttributes.Brand)
                                if (!brand){
                                    brand = new ClothingBrand()
                                    brand.brandName = it.ItemAttributes.Brand
                                    brand.save()
                                }

                                clothing.brand = brand
                                clothing.price = it.OfferSummary.LowestNewPrice.FormattedPrice

                                try{
                                    clothing.type = ClothingType.valueOf(it.ItemAttributes.ProductTypeName)
                                } catch (Exception e){
                                }

                                clothing.style = it.ItemAttributes.Title
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

    def createSignature(String url, String secretKey){
        String parameterString = url.split('\\?')[1]
        def parameters = parameterString.split("&")
        parameters = parameters.sort { ByteBuffer.wrap(it.bytes) }
        def stringToSign = GrailsConfig.itfits.amazon.signaturePrepend + parameters.join("&")
        String signature
        try {
            // initalize encoder with our secret key
            byte[] secretyKeyBytes = secretKey.getBytes("UTF-8");
            SecretKeySpec secretKeySpec = new SecretKeySpec(secretyKeyBytes, "HmacSHA256");
            def mac = Mac.getInstance("HmacSHA256");
            mac.init(secretKeySpec);
            // encode as sha-256
            byte[] data = stringToSign.getBytes("UTF-8");
            byte[] rawHmac = mac.doFinal(data);
            Base64 encoder = new Base64();
            signature = new String(encoder.encode(rawHmac));
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 is unsupported!", e);
        };

        return signature
    }
}
