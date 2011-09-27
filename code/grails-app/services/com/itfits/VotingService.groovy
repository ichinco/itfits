package com.itfits

class VotingService {

    static transactional = true

    def getVotingElement(String type, String elementId, String clothingId, User createdBy) {
        def clothing = Clothing.get(Long.parseLong(clothingId))
        def voteType = VoteType.findByNameAndType(elementId,type)
        if (!voteType){
            voteType = new VoteType()
            voteType.type = type
            voteType.name = elementId;
            voteType.save()
        }

        def voteRecord = VoteRecord.findByClothingAndType(clothing,voteType);
        if (!voteRecord){
            voteRecord = new VoteRecord()
            voteRecord.clothing = clothing;
            voteRecord.type = voteType;
            voteRecord.createdBy = createdBy
            voteRecord.save()
        }

        return voteRecord
    }

    def incrementVote(String type, String catName, String clothingId, User user ){
        def record = getVotingElement(type, catName, clothingId, user);
        def userUpvoted = user.upvoted.contains(record)
        if (!userUpvoted){
            record.upvotes++
            record.save();

            user.upvoted.add(record)
            user.save()
        }
    }

    def decrementVote(String type, String catName, String clothingId, User user ){
        def record = getVotingElement(type, catName, clothingId, user);
        def userDownvoted = user.downvoted.contains(record)
        if (!userDownvoted){
            record.downvotes++
            record.save();

            user.downvoted.add(record)
            user.save()
        }
    }
}
