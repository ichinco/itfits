package com.itfits

/**
 * Created by IntelliJ IDEA.
 * User: glassfin
 * Date: 6/11/11
 * Time: 10:26 AM
 * To change this template use File | Settings | File Templates.
 */
class Outfits {
    String style
    String price
    String description

    Date dateCreated
    Date lastUpdated

    static hasMany = [
        cloths:Clothing,
        reviews:Review,
        ratings:ClothingRating,
        tags:Tag,
        colors:Color,
        materials:ClothingMaterial,
        votes:VoteRecord,
        imageUrls:String
    ]

    static constraints = {
        style nullable:true
        description nullable:true
        imageUrls nullable:true
        price nullable:true
    }
}