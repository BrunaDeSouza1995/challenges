package com.challenge.codewars.feature.base.data.dto.extension

import com.challenge.codewars.feature.base.data.dto.MemberDTO
import com.challenge.codewars.feature.base.data.entity.MemberEntity

fun MemberDTO.toEntity(): MemberEntity {
    return MemberEntity(
        name = name,
        rank = 1,
        bestLanguage = "bestLanguage",
        point = 123
    )
}