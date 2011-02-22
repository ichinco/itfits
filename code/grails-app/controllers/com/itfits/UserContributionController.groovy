package com.itfits

class UserContributionController {

    def userContributionService

    def index = { }

    def userCreateContribution = {
        def model = [:]
        model["userId"] = params.userId

        render(view:"/userContribution/userCreateContribution", model:model)
    }

    def createContribution = {
        User user = User.get(params.userId)

        Clothing clothing
        if (params.clothingId){
            clothing = userContributionService.getOrCreateClothing(params.clothingId)
        } else {
            clothing = userContributionService.getOrCreateClothing(params.brand, params.type, params.size)
        }

        def measurements = []
        for (String m in params.measurements){
            Measurement measurement = userContributionService.createMeasurement()
            measurements.add(measurement)
        }

        userContributionService.createContribution(params.isFavorite.equals("true"), measurements, user, clothing)
    }
}
