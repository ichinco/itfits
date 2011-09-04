package com.itfits

class SearchService {

    static transactional = true
    def recommendationService

    def findBy(User user, Occasion occasion, Style style, ClothingType type,
               double lowPrice, double highPrice, ClothingBrand brand) {
        def criteria = Clothing.createCriteria()
        def clothes = criteria {
//            between("price", lowPrice, highPrice)
            eq("brand", brand)
            eq("type", type)
            votes {
                and {
                    eq("type", occasion)
                }
            }
            votes {
                and {
                    eq("type", style)
                }
            }
        }

//        clothes.sort({recommendationService.getProbabilityUserLikesClothes(user, it)})
        return clothes
    }

    def findGoesWith(User user, Clothing clothing){
        def criteria = Outfit.createCriteria()
        def outfits = criteria {
            cloths {
                eq("id", clothing.id)
            }
        }

        def clothes = []
        outfits.each({clothes.addAll(it.cloths.findAll({it.id != clothing.id}))})
        clothes.sort({recommendationService.getProbabilityUserLikesClothes(user, it)})
        return clothes
    }
}
