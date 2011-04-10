package com.itfits

/**
 * Created by IntelliJ IDEA.
 * User: glassfin
 * Date: 3/20/11
 * Time: 2:25 PM
 * To change this template use File | Settings | File Templates.
 */
class UserService {
    def createUser(String emailAddress, String password) {
        User newUser = new User()
        newUser.username = emailAddress
        newUser.emailAddress = emailAddress
        newUser.password = password
        newUser.accountExpired = false
        newUser.accountLocked = false
        newUser.enabled = true

        List<Role> roleList = Role.findAll('from Role as role where role.authority = ?', ['ROLE_USER'])
        assert roleList.size() != 0
        assert roleList[0].authority == "ROLE_USER"

        if(!newUser.save())
        {
            return newUser.errors
        }

        UserRole.create newUser, roleList[0], true
        return 0
    }

    def createMeasurement(MeasurementType type, double value){
        Measurement measurement = new Measurement()
        measurement.type = type
        measurement.value = value
        measurement.degree = MeasurementDegree.JUST_RIGHT
        measurement.save()

        return measurement
    }

    def saveMeasurements(User user, List<Measurement> measurements){
        user.measurements = measurements
        user.save()
    }

    def deassociateClothing(User user, Clothing clothing){
        def matchingContribution = user.contributions.find {
            it.id == clothing.id
        }

        user.contributions.remove(matchingContribution)
        user.save(flush:true)
        matchingContribution.user = null;
        matchingContribution.save()
        return user.contributions
    }
}
