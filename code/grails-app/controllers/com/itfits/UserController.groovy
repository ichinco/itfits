package com.itfits

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
            def saveLog = userService.createUser(params.emailAddress, params.password)
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

    def dashboard =
    {
        render(view:"/user/dashboard")
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
