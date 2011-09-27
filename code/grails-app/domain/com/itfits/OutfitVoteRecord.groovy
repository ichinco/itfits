package com.itfits

class OutfitVoteRecord {

    Outfit outfit
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
