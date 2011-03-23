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
}
