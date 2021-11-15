package com.challenge.codewars.feature.search.data.dto

import com.challenge.codewars.plugin.FileExt.getDataFromJsonFile

object MemberFakeDTO {

    fun member(): MemberDTO {
        return getDataFromJsonFile(this.javaClass, MemberDTO::class.java, "user.json")
    }

    fun member1(): MemberDTO {
        return getDataFromJsonFile(this.javaClass, MemberDTO::class.java, "user1.json")
    }
}