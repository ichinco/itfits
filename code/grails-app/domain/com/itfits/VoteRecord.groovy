package com.itfits

class VoteRecord {

    Clothing clothing
    VoteType type
    int upvotes
    int downvotes

    static constraints = {
    }

    static mapping = {
        sort "upvotes"
    }
}
