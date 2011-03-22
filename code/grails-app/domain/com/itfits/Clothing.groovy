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

    def findMeasurementByType(MeasurementType type) {
        for (Measurement measurement : measurements){
            if (measurement.type.equals(type)){
                return measurement;
            }
        }

        return null;
    }
}
