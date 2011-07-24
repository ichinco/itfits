package com.itfits

class ClothingReview extends Review {

    static belongsTo = [ clothing : Clothing ]

    static constraints = {
    }
}
