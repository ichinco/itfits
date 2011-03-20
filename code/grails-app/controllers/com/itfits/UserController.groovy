package com.itfits

class UserController {

    def index = { }

    def register =
    {
        // setup the user
        // username = email address
        // password

        // if pass
        // render the successful user message
        def model = [:]
        model["action"] = "email"
        model["emailAddress"] = params.emailAddress

        // email out the stuff

        render(view:"/user/register", model:model)

        // if fail

    }
}
