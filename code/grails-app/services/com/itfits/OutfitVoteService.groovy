package com.itfits

class OutfitVoteService {

    static transactional = true

    def getVotingElement(String type, String elementId, String outfitId, User createdBy) {
        def outfit = Outfit.get(Long.parseLong(outfitId))
        def voteType = VoteType.findByNameAndType(elementId,type)
        if (!voteType){
            voteType = new VoteType()
            voteType.type = type
            voteType.name = elementId;
            voteType.save()
        }

        def outfitVoteRecord = OutfitVoteRecord.findByOutfitAndType(outfit,voteType);
        if (!outfitVoteRecord){
            outfitVoteRecord = new OutfitVoteRecord()
            outfitVoteRecord.outfit = outfit;
            outfitVoteRecord.type = voteType;
            outfitVoteRecord.createdBy = createdBy
            outfitVoteRecord.save()
        }

        return outfitVoteRecord
    }

    def incrementVote(String type, String catName, String outfitId, User user ){
        def record = getVotingElement(type, catName, outfitId, user);
        def userUpvoted = user.outfitUpvoted.contains(record)
        if (!userUpvoted){
            record.upvotes++
            record.save();

            user.outfitUpvoted.add(record)
            user.save()
        }
    }

    def decrementVote(String type, String catName, String outfitId, User user ){
        def record = getVotingElement(type, catName, outfitId, user);
        def userDownvoted = user.outfitDownvoted.contains(record)
        if (!userDownvoted){
            record.downvotes++
            record.save();

            user.outfitDownvoted.add(record)
            user.save()
        }
    }
}
