package com.itfits

class ReputationActionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [reputationActionInstanceList: ReputationAction.list(params), reputationActionInstanceTotal: ReputationAction.count()]
    }

    def create = {
        def reputationActionInstance = new ReputationAction()
        reputationActionInstance.properties = params
        return [reputationActionInstance: reputationActionInstance]
    }

    def save = {
        def reputationActionInstance = new ReputationAction(params)
        if (reputationActionInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'reputationAction.label', default: 'ReputationAction'), reputationActionInstance.id])}"
            redirect(action: "show", id: reputationActionInstance.id)
        }
        else {
            render(view: "create", model: [reputationActionInstance: reputationActionInstance])
        }
    }

    def show = {
        def reputationActionInstance = ReputationAction.get(params.id)
        if (!reputationActionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'reputationAction.label', default: 'ReputationAction'), params.id])}"
            redirect(action: "list")
        }
        else {
            [reputationActionInstance: reputationActionInstance]
        }
    }

    def edit = {
        def reputationActionInstance = ReputationAction.get(params.id)
        if (!reputationActionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'reputationAction.label', default: 'ReputationAction'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [reputationActionInstance: reputationActionInstance]
        }
    }

    def update = {
        def reputationActionInstance = ReputationAction.get(params.id)
        if (reputationActionInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (reputationActionInstance.version > version) {
                    
                    reputationActionInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'reputationAction.label', default: 'ReputationAction')] as Object[], "Another user has updated this ReputationAction while you were editing")
                    render(view: "edit", model: [reputationActionInstance: reputationActionInstance])
                    return
                }
            }
            reputationActionInstance.properties = params
            if (!reputationActionInstance.hasErrors() && reputationActionInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'reputationAction.label', default: 'ReputationAction'), reputationActionInstance.id])}"
                redirect(action: "show", id: reputationActionInstance.id)
            }
            else {
                render(view: "edit", model: [reputationActionInstance: reputationActionInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'reputationAction.label', default: 'ReputationAction'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def reputationActionInstance = ReputationAction.get(params.id)
        if (reputationActionInstance) {
            try {
                reputationActionInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'reputationAction.label', default: 'ReputationAction'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'reputationAction.label', default: 'ReputationAction'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'reputationAction.label', default: 'ReputationAction'), params.id])}"
            redirect(action: "list")
        }
    }
}
