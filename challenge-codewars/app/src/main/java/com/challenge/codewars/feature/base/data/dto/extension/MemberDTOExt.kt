package com.challenge.codewars.feature.base.data.dto.extension

import com.challenge.codewars.feature.base.data.dto.MemberDTO
import com.challenge.codewars.feature.base.data.entity.MemberEntity

fun MemberDTO.toEntity(): MemberEntity {
    val bestLanguage = ranks.languages.getList().maxByOrNull { it.value?.score ?: 0 }

    return MemberEntity(
        name = username,
        rank = leaderboardPosition,
        bestLanguage = bestLanguage?.key.orEmpty(),
        point = bestLanguage?.value?.score ?: 0
    )
}
