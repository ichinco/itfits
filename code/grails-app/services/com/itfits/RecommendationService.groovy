package com.itfits

class RecommendationService {

    def userGroupService

    private def generateExemplars(){
        def exemplars = []
        for (Style style : Style.all){
            def records = VoteRecord.findAllByType(style,[max:20, sort:"upvotes", order:"desc"])
            exemplars.add(records)
        }
        Random random = new Random()
        return exemplars.sort({ return random.nextInt(3)-1 })
    }

    private def generateRecommendationsForGroup(UserStyleGroup group){
        def upvoteMap = [:]

        for (User user in group.users){
            for (VoteRecord record in user.upvoted){
                if (!upvoteMap.containsKey(record)){
                    upvoteMap.put(record,0)
                }

                upvoteMap.put(record,upvoteMap.get(record)+1)
            }
        }

        def recommended = upvoteMap.entrySet().sort({ a, b ->
            if (a.getValue() < b.getValue()){
                return -1
            } else if (a.getValue() == b.getValue()){
                return 0
            } else {
                return 1
            }
        }).collect({it.getKey().clothing})

        return recommended
    }

    private def generateRecommendationListForGroup(UserStyleGroup group){
        List<Clothing> recommendations = generateRecommendationsForGroup(group)
        List<Clothing> exemplars = generateExemplars()
        exemplars.eachWithIndex {it, i->
            int index = i*10+i
            if (recommendations.size() > index){
                recommendations.add(index,it)
            } else {
                recommendations.add(it)
            }
        }

        group.recommendedClothes = recommendations
        group.save()
    }

    private def generateAllRecommendationsForGroups(){
        for (UserStyleGroup group : UserStyleGroup.all){
            generateRecommendationListForGroup(group)
        }
    }

    def putPeopleInGroupsAndGenerateRecommendations(){
        userGroupService.createGroupsAndDistributeUsers()
        generateAllRecommendationsForGroups()
    }

}
