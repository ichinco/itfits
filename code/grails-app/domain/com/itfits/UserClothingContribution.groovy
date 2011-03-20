package com.itfits

class UserClothingContribution {

    User user
    boolean isFavorite
    boolean like
    int fit
    Clothing clothing

    static oneToMany = {
        measurements:Measurement
    }

    static constraints = {
    }
}
