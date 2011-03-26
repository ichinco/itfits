package com.itfits

class Measurement {

    MeasurementType type
    double value
    MeasurementDegree degree
    UserClothingContribution contribution

    static constraints = {
        contribution nullable:true
    }
}
