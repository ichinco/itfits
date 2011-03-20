class UrlMappings {

	static mappings = {
        "/clothing/show/$clothingId" (controller:"clothing", action:"show")

		"/$controller/$action?/$id?"{
			constraints {
				// apply constraints here
			}
		}

		"/"(view:"/index")
		"500"(view:'/error')
	}
}
