package com.itfits

class Review {

    User user
    int overallRating
    String text

    static belongsTo = [ clothing : Clothing ]

    static constraints = {
    }
}
