package com.itfits

class Measurement {

    MeasurementType type
    double value
    MeasurementDegree degree
    UserClothingContribution contribution

    Date dateCreated
    Date lastUpdated

    static constraints = {
        contribution nullable:true
    }
}
