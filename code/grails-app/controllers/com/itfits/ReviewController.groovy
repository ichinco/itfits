package com.itfits

class ReviewController {

    def springSecurityService
    def reviewService

    def index = { }

    def submit = {
        def id = params.clothingId
        def text = params.reviewText
        Clothing clothing = Clothing.get(Long.parseLong(id))
        User user = (User) springSecurityService.currentUser

        if (user){
            reviewService.createReview(text, user, clothing)
        }

        def params = [:]
        params.clothingId = id;

        redirect(controller:"clothing", action:"show", params:params)
    }

    def rate = {
        int clothingId = Integer.parseInt(params.clothingId)
        int userId = Integer.parseInt(params.userId)
        int value = Integer.parseInt(params.value)
        RatingDimension dimension = RatingDimension.valueOf(params.dimension)

        reviewService.createRating(dimension, value, userId, clothingId);

        def params = [:]
        params.clothingId = clothingId;

        redirect(controller:"clothing", action:"show", params:params)
    }
}
