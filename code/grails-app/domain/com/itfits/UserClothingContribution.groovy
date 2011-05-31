package com.itfits

class UserClothingContribution {

    Clothing clothing
    String size
    Date dateCreated
    Date lastUpdated

    static belongsTo = [user:User]
    static hasMany = [
        measurements:Measurement
    ]

    static constraints = {
        clothing nullable:true
        user nullable: true
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
