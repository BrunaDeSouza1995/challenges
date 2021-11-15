package com.challenge.codewars.feature.search.data.entity

import com.challenge.codewars.feature.search.data.dto.MemberFakeDTO.member
import com.challenge.codewars.feature.search.data.dto.MemberFakeDTO.member1
import com.challenge.codewars.feature.search.data.extension.toEntity

object MemberFakeEntity {

    fun memberEntity(): MemberEntity {
        return member().toEntity()
    }

    fun member1Entity(): MemberEntity {
        return member1().toEntity()
    }

    fun membersEntity(): List<MemberEntity> {
        return listOf(memberEntity(), member1Entity())
    }

    fun membersEntitySortByRack(): List<MemberEntity> {
        return listOf(member1Entity(), memberEntity())
    }
}