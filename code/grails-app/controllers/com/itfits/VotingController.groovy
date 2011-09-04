package com.itfits

import grails.plugins.springsecurity.Secured

class VotingController {

    def votingService
    def springSecurityService

    def index = { }

    @Secured(["ROLE_USER"])
    def cast = {
        def type = params.type
        def clothing = params.clothing
        def name = params.elementId
        User user = (User) springSecurityService.currentUser

        votingService.incrementVote(type,name,clothing, user)

        redirect(controller:'clothing', action:'show', params:['clothingId':clothing])
    }
}
