package com.itfits

class ClothingVote extends VoteType {

    static constraints = {
    }

    static mapping = {
        discriminator column:"type", value:"clothing"
    }
}
