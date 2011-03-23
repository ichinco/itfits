import com.itfits.Role
import com.itfits.User
import com.itfits.UserRole

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

        // Roles: merchant, user, admin, custserv, market
        def merchant = new Role(authority: "ROLE_MERCHANT")
        def user = new Role(authority: "ROLE_USER")
        def admin = new Role(authority: "ROLE_ADMIN")
        def custserv = new Role(authority: "ROLE_CUSTSERV")
        def market = new Role(authority: "ROLE_MARKET")

        merchant.save(flush: true)
        user.save(flush: true)
        admin.save(flush: true)
        custserv.save(flush: true)
        market.save(flush: true)


    }

    def destroy = {
    }

}