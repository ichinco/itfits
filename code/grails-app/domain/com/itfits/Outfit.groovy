package com.itfits

/**
 * Created by IntelliJ IDEA.
 * User: glassfin
 * Date: 6/11/11
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */
class Outfit {
    String name
    String description

    Date dateCreated
    Date lastUpdated

    static hasMany = [
        cloths:Clothing,
        tags:Tag,
        imageUrls:String,
        reviews:OutfitReview
    ]

    static constraints = {
        description nullable:true
        imageUrls nullable:true
    }
}