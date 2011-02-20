package com.itfits

class HumanMeasurement {

    MeasurementType type
    int value

    static belongsTo = [ user : User ]

    static constraints = {
    }
}
