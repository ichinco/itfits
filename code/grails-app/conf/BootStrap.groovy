class BootStrap {

    def emailConfirmationService

    // TODO: fill this part out
    def init = { servletContext ->
        emailConfirmationService.onConfirmation =
        {
            email,
            uid ->
                log.info("You have confirmed your email address!")
                // now do something…
                // Then return a map which will redirect the user to this destination
                return [controller:'userProfile', action:'welcome']
        }
        emailConfirmationService.onInvalid =
        {
            uid ->
            log.warn("User with id $uid failed to confirm email address after 30 days")
        }

        emailConfirmationService.onTimeout =
        { email, uid ->
             log.warn("User with id $uid failed to confirm email address after 30 days")
        }

    }

    def destroy = {
    }

}