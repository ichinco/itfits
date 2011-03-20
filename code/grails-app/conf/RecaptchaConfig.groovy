recaptcha {
    // These keys are generated by the ReCaptcha service
	publicKey = ""
	privateKey = ""

	// Include the noscript tags in the generated captcha
	includeNoScript = true
}

mailhide {
    // Generated by the Mailhide service
    publicKey = ""
    privateKey = ""
}

environments {
  development {
    recaptcha {
      // Set to false to disable the display of captcha
      enabled = false

      // Communicate using HTTPS
      useSecureAPI = false
    }
  }
  production {
    recaptcha {
      // Set to false to disable the display of captcha
      enabled = true

      // Communicate using HTTPS
      useSecureAPI = true
    }
  }
}