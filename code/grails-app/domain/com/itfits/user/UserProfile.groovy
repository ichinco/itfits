package com.itfits.user

import com.itfits.User

class UserProfile {

    static hasMany = {
        userAddress:UserAddress
    }

    static constraints = {
    }
}
