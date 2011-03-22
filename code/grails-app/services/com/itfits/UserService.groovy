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

        if(!newUser.save())
        {
            return newUser.errors
        }

        return 0
    }
}
