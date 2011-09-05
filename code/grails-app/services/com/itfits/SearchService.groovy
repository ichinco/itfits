package com.itfits

class SearchService {

    static transactional = true
    def recommendationService

    def findBy(User user, VoteType occasion, VoteType style, ClothingType clothingType,
               double lowPrice, double highPrice, ClothingBrand brand) {
        def criteria = Clothing.createCriteria()
        def clothes = criteria.list {
//            between("price", lowPrice, highPrice)
            if (brand) {
                eq("brand", brand)
            }
            if (clothingType) {
                eq("type", clothingType)
            }
            if (occasion){
                 votes {
                    type {
                       eq("id", occasion.id)
                       eq("type", "occasion")
                    }
                    gtProperty("upvotes","downvotes")
                 }
            }
            if (style) {
                votes {
                    type {
                        eq("id", style.id)
                        eq("type", "style")
                    }
                    gtProperty("upvotes","downvotes")
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
