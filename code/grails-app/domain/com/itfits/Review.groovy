package com.itfits

class Review {

    User user
    String text
    Date dateCreated
    Date lastUpdated

    static belongsTo = [ review : Reviewable ]

    static constraints = {

    }
}
