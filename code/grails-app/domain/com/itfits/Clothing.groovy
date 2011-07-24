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
    boolean isClothing
    String price

    Date dateCreated
    Date lastUpdated

    static hasMany = [
        contributions:UserClothingContribution,
        reviews:ClothingReview,
        ratings:ClothingRating,
        tags:Tag,
        colors:Color,
        materials:ClothingMaterial,
        votes:VoteRecord
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

    def create() {
        isClothing = true;
    }
}
