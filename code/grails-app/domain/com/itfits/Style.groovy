package com.itfits

class Style extends VoteType {

    static constraints = {

    }

    static mapping = {
         discriminator value:"style", column:"type"
    }
}
