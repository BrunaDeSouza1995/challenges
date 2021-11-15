package com.challenge.codewars.feature.search.data.extension

import com.challenge.codewars.feature.search.data.entity.getList
import com.challenge.codewars.feature.search.data.dto.MemberDTO
import com.challenge.codewars.feature.search.data.entity.MemberEntity

fun MemberDTO.toEntity(): MemberEntity {
    val bestLanguage = ranks.languages.getList().maxByOrNull { it.value?.score ?: 0 }

    return MemberEntity(
        name = username,
        rank = leaderboardPosition,
        bestLanguage = bestLanguage?.key.orEmpty(),
        point = bestLanguage?.value?.score ?: 0
    )
}
