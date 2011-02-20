package com.itfits

class UserClothingContribution {

    User user
    boolean isFavorite

    static oneToMany = {
        measurements:Measurement
    }

    static constraints = {
    }
}
