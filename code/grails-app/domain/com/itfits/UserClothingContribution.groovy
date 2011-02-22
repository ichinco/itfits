package com.itfits

class UserClothingContribution {

    User user
    boolean isFavorite
    Clothing clothing

    static oneToMany = {
        measurements:Measurement
    }

    static constraints = {
    }
}
