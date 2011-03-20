package com.itfits.user

import com.itfits.UserAddressType

class UserAddress {

    UserAddressType addressType
    String streetAddress
    String apt
    String zipCode
    String state
    String country

    static constraints = {
    }
}
