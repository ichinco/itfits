package com.itfits

class Occasion extends VoteType {

    static constraints = {

    }
    static mapping = {
        discriminator column:"type", value:"occasion"
    }
}
