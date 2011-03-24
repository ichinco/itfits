package com.itfits

class UserContributionService {

    static transactional = true

    def createContribution(User user, Clothing clothing) {
        UserClothingContribution contribution = UserClothingContribution.findByUserAndClothing(user,clothing);
        if (!contribution){
            contribution = new UserClothingContribution();
            contribution.user = user
            contribution.clothing = clothing

            contribution.save()
        }

        return contribution;
    }

    def createMeasurement(MeasurementType type,
                          double value,
                          MeasurementDegree degree,
                          UserClothingContribution contribution){
        Measurement measurement = Measurement.findByContributionAndType(contribution,type);
        if (!measurement){
            measurement = new Measurement()
            measurement.type = type
            measurement.contribution = contribution
        }
        measurement.value = value
        measurement.degree = degree

        measurement.save()

        return measurement
    }
}
