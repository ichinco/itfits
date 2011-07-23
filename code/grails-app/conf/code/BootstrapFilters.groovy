package code

class BootstrapFilters {

    def springSecurityService

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                request["user"] = springSecurityService.currentUser;

                return true;
            }
            after = {
                
            }
            afterView = {
                
            }
        }
    }
    
}
