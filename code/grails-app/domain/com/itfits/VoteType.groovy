package com.itfits

class VoteType {

    String name
    String type
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }

    static mapping = {
        discriminator "type"
    }
}
