package com.itfits

class Clothing {

    String brand
    String type
    String size

    static hasMany = [
        measurements:Measurement,
        reviews:Review
    ]

    static constraints = {
    }
}
