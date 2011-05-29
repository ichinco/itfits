package com.itfits

import com.itfits.user.UserProfile

class User {

	String username
	String password
	boolean enabled
	boolean accountExpired
	boolean accountLocked
	boolean passwordExpired

    // I added this:
    String firstName
    String lastName
    String emailAddress
    boolean confirmedEmail
    UserProfile userProfile
    Integer reputation = 0

    static hasMany = [
        measurements : Measurement,
        contributions : UserClothingContribution,
        upvoted : VoteRecord,
        downvoted : VoteRecord
    ]

	static constraints = {
        username blank: false, unique: true
		password blank: false
        emailAddress blank: false, unique: true
        firstName(nullable: true)
        lastName(nullable: true)
        userProfile(nullable: true)
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}

    void updateReputation(ReputationWorthyAction action){
        def reputationIncrement = ReputationAction.findByAction(action)
        def reputationAddition = reputationIncrement ? reputationIncrement.reputation : 0
        if (reputation){
            reputation += reputationAddition
        } else {
            reputation = reputationAddition
        }
    }

    boolean allowedTo(PrivledgeRequiredAction action){
        def privledgeRequired = PrivledgeAction.findByAction(action)
        return reputation >= (privledgeRequired ? privledgeRequired.reputation : 0)
    }
}
