package com.itfits

class ReviewService {

    static transactional = true

    def createReview(String text, User user, Clothing clothing) {
        Review review = new Review()
        review.text = text
        review.user = user
        review.clothing = clothing
        review.save()
    }
}
