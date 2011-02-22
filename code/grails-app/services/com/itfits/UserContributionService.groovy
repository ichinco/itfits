package com.itfits

class UserContributionService {

    static transactional = true

    def createContribution(boolean isFavorite, List<Measurement> measurements, User user, Clothing clothing) {
        UserClothingContribution contribution = new UserClothingContribution();
        contribution.isFavorite = isFavorite
        contribution.measurements = measurements
        contribution.user = user
        contribution.clothing = clothing

        contribution.save()
    }

    def getOrCreateClothing(String brand, String type, String size){
        Clothing dbClothing = Clothing.find(clothing)
        if (!dbClothing){
            dbClothing = new Clothing()
            dbClothing.brand = brand
            dbClothing.type = type
            dbClothing.size = size

            dbClothing.save()
        }

        return dbClothing
    }

    def getOrCreateClothing(String id){
        return Clothing.get(Integer.parseInt(id))
    }

    def createMeasurement(MeasurementType type,
                          double value,
                          MeasurementDegree degree){
        Measurement measurement = new Measurement()
        measurement.type = type
        measurement.value = value
        measurement.degree = degree

        measurement.save()

        return measurement
    }
}
