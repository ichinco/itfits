package com.itfits
import grails.plugins.springsecurity.Secured

class UserController {

    def userService
    def springSecurityService

    def index = { }

    def register =
    {
        // setup the user
        // username = email address
        // password
        if(!params.emailAddress)
        {
            render(view:"/user/register")
        }
        else
        {
            def model = [:]
            model["action"] = "debug"
            model["emailAddress"] = params.emailAddress
            model["password"] = springSecurityService.encodePassword(params.password)

            //render(view:"/user/register",, model:model)
            def saveLog = userService.createUser(model["emailAddress"], model["password"])
            if(saveLog == 0)
            {
                // if pass
                // render the successful user message
                model["action"] = "email"
                model["emailAddress"] = params.emailAddress
                render(view:"/user/register", model:model)
            }
            else
            {
                model["action"] = "error"
                model["message"] = saveLog

                render(view:"/user/register", model:model)
            }

        }

        // if fail

    }

    @Secured(["ROLE_USER"])
    def dashboard =
    {
        if(springSecurityService.isLoggedIn())
        {
            render(view:"/user/dashboard")
        }
        else
        {
            //config.successHandler.targetUrlParameter = "/user/dashboard"
            //springSecurityService.successHandler.targetUrlParameter = "/user/dashboard"

            redirect(view:"/login")
        }
    }

    def seeall =
    {

        def model = [:]
        model['usercount'] = User.count()
        if(User.count() > 0)
        {
            List<User> users = User.all
            model["users"] = users
        }
        render(view:"/user/seeall", model:model)
    }
}
