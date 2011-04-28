package com.itfits
import grails.plugins.springsecurity.Secured

class IndexController {

    def springSecurityService

    def index = {
        def model = [:]
        model["user"] = springSecurityService.currentUser
        model["hello"] = "hello"

        render(view: '/index', model:model)
    }
}
