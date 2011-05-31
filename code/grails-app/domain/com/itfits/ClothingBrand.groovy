package com.itfits

class ClothingBrand {

    String brandName

    Date dateCreated
    Date lastUpdated

    static hasMany = [
        clothing:Clothing
    ]

    static constraints = {
    }
}
