package com.itfits

class Clothing {

    ClothingBrand brand
    ClothingType type
    String style
    String merchantId
    String imageUrl
    String purchaseUrl
    boolean isWaterproof
    boolean isShear
    String price

    static hasMany = [
        contributions:UserClothingContribution,
        reviews:Review,
        ratings:ClothingRating,
        tags:Tag,
        colors:Color,
        materials:ClothingMaterial
    ]

    static constraints = {
        brand nullable:true
        type nullable:true
        style nullable:true
        merchantId nullable:true
        imageUrl nullable:true
        purchaseUrl nullable:true
        price nullable:true
    }

    def findMeasurementByType(MeasurementType type) {
        for (UserClothingContribution contribution : contributions){
            for (Measurement measurement : contribution.measurements){
                if (measurement.type.equals(type)){
                    return measurement;
                }
            }
        }

        return null;
    }
}
