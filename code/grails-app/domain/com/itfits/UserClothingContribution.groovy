package com.itfits

class UserClothingContribution {

    User user
    Clothing clothing

    static hasMany = [
        measurements:Measurement
    ]

    static constraints = {
    }

    public Measurement findMeasurementByType(MeasurementType type){
        Measurement measurement = null;
        measurements.each {
            if (it.type.equals(type)){
                measurement = it;
            }
        }
        return measurement;
    }
}
