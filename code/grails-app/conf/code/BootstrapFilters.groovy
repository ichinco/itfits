package code

class BootstrapFilters {

    def springSecurityService

    def filters = {
        all(controller:'*', action:'*') {
            before = {
                request["signedIn"] = springSecurityService.currentUser ? true : false;

                return true;
            }
            after = {
                
            }
            afterView = {
                
            }
        }
    }
    
}
