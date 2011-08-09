package com.itfits

class ReviewService {

    static transactional = true

    def createReview(String text, User user, Clothing clothing) {
        ClothingReview review = new ClothingReview()
        review.text = text
        review.user = user
        review.clothing = clothing
        review.save()
    }
}
