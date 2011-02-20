package com.itfits

class Clothing {

    static hasMany = [
        measurements:Measurement,
        reviews:Review
    ]

    static constraints = {
    }
}
