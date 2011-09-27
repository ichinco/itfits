package com.itfits

class VoteRecord {

    Clothing clothing
    VoteType type
    int upvotes
    int downvotes
    Date dateCreated
    Date lastUpdated
    User createdBy

    static constraints = {
    }

    static mapping = {
        sort "upvotes"
    }
}
