package com.itfits

class RecommendationService {

    private static final GET_TOTAL_TAGS = "select count(total) from TagAggregate"
    def sessionFactory

    def repopulateAggregatesForTag(VoteType tag){
        def aggregate = TagAggregate.findByTag(tag)
        if (!aggregate){
            aggregate = new TagAggregate()
            aggregate.setTag(tag)
        }
        aggregate.setTotal(VoteRecord.findAllByType(tag).size())
        aggregate.save()
    }

    def repopulateAggregatesForUser(User user){
        def voteTypeLikeMap = [:]
        UserTagAggregate.findByUser(user).each({
            voteTypeLikeMap[it.tag] = it
            it.totalLikes = 1
            it.totalDislikes = 0
        })
        user.upvoted.each({ Clothing cloth ->
            if (cloth instanceof ClothingVote){
                cloth.votes.each({ VoteRecord vote ->
                    if (!(vote instanceof ClothingVote)){
                        if (!voteTypeLikeMap.containsKey(vote.type)){
                            def aggregate = new UserTagAggregate()
                            aggregate.user = user
                            aggregate.tag = vote.type
                            aggregate.totalLikes = 1
                            aggregate.totalDislikes = 1
                            voteTypeLikeMap[vote.type] = aggregate
                        }
                    }
                    voteTypeLikeMap[vote.type].totalLikes++
                })
            }
        })
        user.downvoted.each({ Clothing cloth ->
            if (cloth instanceof ClothingVote){
                cloth.votes.each({ VoteRecord vote ->
                    if (!(vote instanceof ClothingVote)){
                        if (!voteTypeLikeMap.containsKey(vote.type)){
                            def aggregate = new UserTagAggregate()
                            aggregate.user = user
                            aggregate.tag = vote.type
                            aggregate.totalLikes = 1
                            aggregate.totalDislikes = 1
                            voteTypeLikeMap[vote.type] = aggregate
                        }
                    }
                    voteTypeLikeMap[vote.type].totalLikes--
                })
            }
        })

        voteTypeLikeMap.values.each({
            it.save();
        });
    }

    def getProbabilityUserLikesClothes(User user, Clothing clothing){
        def tagAggregates = [:]
        UserTagAggregate.findByUser(user).each({
            tagAggregates[it.type] = it
        })

        def aggregate = 1;
        for (VoteRecord record : clothing.votes) {
            def userTagAggregate = tagAggregates[record.type]
            def probability = userTagAggregate.totalLikes/(userTagAggregate.totalLikes + userTagAggregate.totalDislikes)
            aggregate *= probability
        }

        def upvotes = 0
        def downvotes = 0
        user.upvoted.each({
            if (it instanceof ClothingVote){ upvotes++ }
        })
        user.downvoted.each({
            if (it instanceof ClothingVote){ downvotes++ }
        })

        def userLiking = upvotes / (upvotes + downvotes)
        def tagProbability = 1;

        clothing.votes.each({
            if (!(it.type instanceof ClothingVote)){
                tagProbability *= (TagAggregate.findByTag(it.type).total)/getTotal()
            }
        });

        return (userLiking * aggregate) / tagProbability
    }

    def getTotal(){
        def query = sessionFactory.getCurrentSession().createQuery(GET_TOTAL_TAGS)
        return (int) query.uniqueResult();
    }

    def getRepresentativeOutfit(Occasion occasion, Style style){
        VoteRecord recentOccasionVotes = VoteRecord.findByDateCreatedBetweenAndType(new Date()-7, new Date(), occasion)
        VoteRecord recentStyleVotes = VoteRecord.findByDateCreatedBetweenAndType(new Date()-7, new Date(), style)
        VoteRecord recentClothingVotes = VoteRecord.findByDateCreatedBetweenAndType(new Date()-7, new Date(), clothing)


    }

}
