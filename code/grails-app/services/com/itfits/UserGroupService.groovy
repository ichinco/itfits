package com.itfits

class UserGroupService {

    static transactional = true

    int[] dividers = [33,67];

    private def createGroupCombinations(groupMap){
        def userGroups = []
        def zeroGroups = groupMap.values().collect( { it[0] } )

        UserStyleGroup zeroGroup = new UserStyleGroup()
        zeroGroup.groups = zeroGroups
        zeroGroup.users = []
        zeroGroup.save()
        userGroups.add(zeroGroup)

        groupMap.values().eachWithIndex(){it, i->
            UserStyleGroup group = new UserStyleGroup()
            group.groups = []
            group.users = []
            group.groups.add(it[dividers.size()])

            zeroGroups.eachWithIndex {zero,j ->
                if (i !=j )
                group.groups.add(zero)
            }

            group.save()

            userGroups.add(group)
        }

        groupMap.values().eachWithIndex {first, i->
            groupMap.values().eachWithIndex {second, j->
                if (j>i){
                    UserStyleGroup group = new UserStyleGroup()
                    group.groups = []
                    group.users = []
                    group.groups.add(first[dividers.size()-1])
                    group.groups.add(second[dividers.size()-1])

                     zeroGroups.eachWithIndex {zero,k ->
                        if (i !=k && j!=k )
                        group.groups.add(zero)
                    }

                    group.save()

                    userGroups.add(group)
                }
            }
        }

        return userGroups
    }

    private def putUserInGroup(User user, List<UserStyleGroup> groups){
        for (UserStyleGroup group : groups){
            if (group.doesUserBelongInGroup(user)){
                group.users.add(user)
                group.save()
                break;
            }
        }
    }

    private def putAllUsersInGroups(List<UserStyleGroup> groups){
        for (User user in User.all){
            putUserInGroup(user, groups)
        }
    }

    def createGroupsAndDistributeUsers(){
        deleteAllGroups()
        def groups = defineGroups()
        def styleGroups = createGroupCombinations(groups)
        putAllUsersInGroups(styleGroups)
    }

    private def deleteAllGroups(){
        if (UserStyleGroup.count() > 0){
            for (UserStyleGroup styleGroup in UserStyleGroup.all){
                styleGroup.delete()
            }
        }
        if (StyleGroup.count() > 0){
            for (StyleGroup group in StyleGroup.all){
                group.delete()
            }
        }
    }

    private def defineGroups(){
        def groups = [:]
        for (Style style : Style.all){
            def groupList = []
            dividers.eachWithIndex() { divider, i ->
                def group = new StyleGroup();
                group.style = style;
                group.minimumPercentageLiked = i == 0 ? 0 : dividers[i-1];
                group.maximumPercentageLiked = divider;
                groupList.add(group)
            }
            def group = new StyleGroup();
            group.style = style;
            group.minimumPercentageLiked = dividers[dividers.size() - 1];
            group.maximumPercentageLiked = 100;
            groupList.add(group)

            groups[style] = groupList
        }

        return groups;
    }
}
