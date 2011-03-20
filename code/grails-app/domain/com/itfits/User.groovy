package com.itfits

import com.itfits.user.UserProfile

class User {

	//String username
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

    static hasMany = [
        measurements : HumanMeasurement,
        contributions : UserClothingContribution
    ]

	static constraints = {
		username blank: false, unique: true
		password blank: false
        emailAddress blank: false, unique true
	}

	static mapping = {
		password column: '`password`'
	}

	Set<Role> getAuthorities() {
		UserRole.findAllByUser(this).collect { it.role } as Set
	}
}
