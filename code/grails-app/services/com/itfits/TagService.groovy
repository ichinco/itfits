package com.itfits

class TagService {

    static transactional = true

    def findTag(String tag) {
        Tag dbTag = Tag.findByTag(tag)

        if (!dbTag) {
            dbTag = new Tag([tag:tag])
        }

        return dbTag
    }
}
