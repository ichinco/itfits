package com.itfits
import grails.plugins.springsecurity.Secured

class UserController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]
    def userService
    def springSecurityService

    /** AUTHORED **/
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

        def model = [:]
        model["user"] = springSecurityService.currentUser

        render(view:"/user/dashboard", model:model)
    }

    def userbar =
    {
        def model = [:]
        model["user"] = springSecurityService.currentUser

        render(template:"/layouts/main.gsp", model:model)
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
    /** END OF AUTHORED **/

    def index = {
        //redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [userInstanceList: User.list(params), userInstanceTotal: User.count()]
    }

    def create = {
        def userInstance = new User()
        userInstance.properties = params
        return [userInstance: userInstance]
    }

    def save = {
        def userInstance = new User(params)
        if (userInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])}"
            redirect(action: "show", id: userInstance.id)
        }
        else {
            render(view: "create", model: [userInstance: userInstance])
        }
    }

    def show = {
        def userInstance = User.get(params.id)
        if (!userInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
            redirect(action: "list")
        }
        else {
            [userInstance: userInstance]
        }
    }

    @Secured(["ROLE_USER"])
    def edit = {
        if(springSecurityService.currentUser.id != Long.parseLong(params.id))
            redirect(controller:"login", action:"denied")

        def userInstance = User.get(params.id)
        if (!userInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [userInstance: userInstance]
        }
    }

    @Secured(["ROLE_USER"])
    def changePassword = {
        def userInstance = User.get(params.id)
        if (userInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (userInstance.version > version) {

                    userInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'user.label', default: 'User')] as Object[], "Another user has updated this User while you were editing")
                    render(view: "edit", model: [userInstance: userInstance])
                    return
                }
            }
            if (params["password"] == params["reEnterPassword"]) {
                userInstance.password = springSecurityService.encodePassword(params["password"])
                if (!userInstance.hasErrors() && userInstance.save(flush: true)) {
                    flash.message = "${message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])}"
                    redirect(action: "show", id: userInstance.id)
                }
                else {
                    render(view: "edit", model: [userInstance: userInstance])
                }
            } else {
                flash.message = "${message(code: 'default.passwordmismatch.message', default: "passwords must match")}"
                render(view: "edit", model: [userInstance: userInstance])
            }

        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
            redirect(action: "list")
        }
    }

    @Secured(["ROLE_USER"])
    def update = {
        def userInstance = User.get(params.id)
        if (userInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (userInstance.version > version) {
                    
                    userInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'user.label', default: 'User')] as Object[], "Another user has updated this User while you were editing")
                    render(view: "edit", model: [userInstance: userInstance])
                    return
                }
            }
            userInstance.properties = params
            if (!userInstance.hasErrors() && userInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'user.label', default: 'User'), userInstance.id])}"
                redirect(action: "show", id: userInstance.id)
            }
            else {
                render(view: "edit", model: [userInstance: userInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def userInstance = User.get(params.id)
        if (userInstance) {
            try {
                userInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'user.label', default: 'User'), params.id])}"
            redirect(action: "list")
        }
    }

    @Secured(["ROLE_USER"])
    def measurements = {

        UserClothingContribution contribution = new UserClothingContribution()
        contribution.measurements =  springSecurityService.currentUser.measurements

        def model = [:]
        model.dimensions = ClothingType.HUMAN_FEMALE.relevantDimensions
        model.contribution = contribution

        render(view:"/user/user_measurements", model:model)
    }

    @Secured(["ROLE_USER"])
    def saveMeasurements = {
        def measurements = ClothingType.HUMAN_FEMALE.relevantDimensions.collect {
            userService.createMeasurement(it.measurementType,
            Double.parseDouble(params.get("measurement_${it.measurementType}".toString()).toString()))
        }

        User user = springSecurityService.currentUser
        userService.saveMeasurements(user, measurements)

        redirect(controller:"user", action:"dashboard")
    }

    def removeClothing = {
        Clothing clothing = Clothing.get(Long.parseLong(params["clothingId"]))
        User user = springSecurityService.currentUser
        def remainingContributions = userService.deassociateClothing(user,clothing)

        render(template:"clothingList", model:['contributions' :remainingContributions])
    }
}