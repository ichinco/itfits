package com.itfits

class UserStyleGroup {

    List<StyleGroup> groups
    List<User> users
    List<Clothing> recommendedClothes

    static constraints = {
    }

    boolean doesUserBelongInGroup(User user){
        def styleMap = user.computeUserStyleVoteMap()

        for (StyleGroup group in groups){
            def userValue = styleMap[group.style.name]
            if (!(userValue >= group.minimumPercentageLiked && userValue < group.maximumPercentageLiked)){
                return false;
            }
        }

        return true;
    }
}
