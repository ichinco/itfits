package com.itfits

class Review {

    User user
    String text

    static belongsTo = [ clothing : Clothing ]

    static constraints = {
    }
}
