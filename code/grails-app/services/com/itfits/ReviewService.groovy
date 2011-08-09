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

    def createRating(RatingDimension dimension, int value, int userId, int clothingId) {
        ClothingRating rating = new ClothingRating();
        rating.clothing = Clothing.get(clothingId)
        rating.dimension = dimension
        rating.rating = value
        rating.user = User.get(userId)
        rating.save()
    }
}
