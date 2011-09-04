package com.itfits

class VoteType {

    String name
    String type
    Date dateCreated
    Date lastUpdated

    static constraints = {
        type(insert:false, update:false)
    }

    static mapping = {
    }
}
