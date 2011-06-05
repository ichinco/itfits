package com.itfits

class RecommendationController {

    def recommendationService

    def index = {
        recommendationService.putPeopleInGroupsAndGenerateRecommendations()

        render(text:"success")
    }
}
