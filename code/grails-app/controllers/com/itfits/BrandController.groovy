package com.itfits

import grails.converters.*

class BrandController {

    def brandService

    def index = { }

    def find = {
        render brandService.getSuggestionsForBrand(params.brandName) as JSON
    }
}
