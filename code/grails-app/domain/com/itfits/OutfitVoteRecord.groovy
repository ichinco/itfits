package com.itfits

class OutfitVoteRecord {

    Outfit outfit
    VoteType type
    int upvotes
    int downvotes
    Date dateCreated
    Date lastUpdated

    static constraints = {
    }

    static mapping = {
        sort "upvotes"
    }
}
