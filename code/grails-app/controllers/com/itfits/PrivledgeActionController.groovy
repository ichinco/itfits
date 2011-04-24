package com.itfits

class PrivledgeActionController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [privledgeActionInstanceList: PrivledgeAction.list(params), privledgeActionInstanceTotal: PrivledgeAction.count()]
    }

    def create = {
        def privledgeActionInstance = new PrivledgeAction()
        privledgeActionInstance.properties = params
        return [privledgeActionInstance: privledgeActionInstance]
    }

    def save = {
        def privledgeActionInstance = new PrivledgeAction(params)
        if (privledgeActionInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'privledgeAction.label', default: 'PrivledgeAction'), privledgeActionInstance.id])}"
            redirect(action: "show", id: privledgeActionInstance.id)
        }
        else {
            render(view: "create", model: [privledgeActionInstance: privledgeActionInstance])
        }
    }

    def show = {
        def privledgeActionInstance = PrivledgeAction.get(params.id)
        if (!privledgeActionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'privledgeAction.label', default: 'PrivledgeAction'), params.id])}"
            redirect(action: "list")
        }
        else {
            [privledgeActionInstance: privledgeActionInstance]
        }
    }

    def edit = {
        def privledgeActionInstance = PrivledgeAction.get(params.id)
        if (!privledgeActionInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'privledgeAction.label', default: 'PrivledgeAction'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [privledgeActionInstance: privledgeActionInstance]
        }
    }

    def update = {
        def privledgeActionInstance = PrivledgeAction.get(params.id)
        if (privledgeActionInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (privledgeActionInstance.version > version) {
                    
                    privledgeActionInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'privledgeAction.label', default: 'PrivledgeAction')] as Object[], "Another user has updated this PrivledgeAction while you were editing")
                    render(view: "edit", model: [privledgeActionInstance: privledgeActionInstance])
                    return
                }
            }
            privledgeActionInstance.properties = params
            if (!privledgeActionInstance.hasErrors() && privledgeActionInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'privledgeAction.label', default: 'PrivledgeAction'), privledgeActionInstance.id])}"
                redirect(action: "show", id: privledgeActionInstance.id)
            }
            else {
                render(view: "edit", model: [privledgeActionInstance: privledgeActionInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'privledgeAction.label', default: 'PrivledgeAction'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def privledgeActionInstance = PrivledgeAction.get(params.id)
        if (privledgeActionInstance) {
            try {
                privledgeActionInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'privledgeAction.label', default: 'PrivledgeAction'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'privledgeAction.label', default: 'PrivledgeAction'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'privledgeAction.label', default: 'PrivledgeAction'), params.id])}"
            redirect(action: "list")
        }
    }
}
