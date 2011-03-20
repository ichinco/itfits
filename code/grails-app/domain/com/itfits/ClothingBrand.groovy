package com.itfits

class ClothingBrand {

    String brandName

    static hasMany = [
        clothing:Clothing
    ]

    static constraints = {
    }
}
