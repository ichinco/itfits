package com.itfits

import grails.plugins.springsecurity.Secured

class OutfitVotingController {

    def outfitVoteService
    def springSecurityService

    def index = { }

    @Secured(["ROLE_USER"])
    def cast = {
        def type = params.type
        def outfit = params.outfit
        def name = params.elementId
        User user = (User) springSecurityService.currentUser

        outfitVoteService.incrementVote(type,name,outfit, user)

        redirect(controller:'outfit', action:'view', params:['outfit':outfit])
    }
}
