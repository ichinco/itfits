package com.itfits

class Review {

    User user
    String text
    Date dateCreated
    Date lastUpdated

    static belongsTo = [ clothing : Clothing ]

    static constraints = {

    }
}
