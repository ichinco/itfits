package com.itfits

class VoteType {

    String name
    String type

    static constraints = {
    }

    static mapping = {
        discriminator "type"
    }
}
