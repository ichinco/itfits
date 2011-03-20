package com.itfits

class Clothing {

    ClothingBrand brand
    ClothingType type
    String size
    boolean isWaterproof
    boolean isShear


    static hasMany = [
        measurements:Measurement,
        reviews:Review,
        ratings:ClothingRating,
        tags:Tag,
        colors:Color,
        materials:ClothingMaterial
    ]

    static constraints = {
    }
}
