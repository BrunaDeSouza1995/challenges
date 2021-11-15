package com.challenge.codewars.feature.base.data.dto.extension

import com.challenge.codewars.feature.base.data.dto.AuthoredChallengeDTO
import com.challenge.codewars.feature.base.data.dto.CompletedChallengeDTO
import com.challenge.codewars.feature.base.data.entity.ChallengeEntity

fun CompletedChallengeDTO.toEntity(username: String): List<ChallengeEntity> {
    return data.map {
        ChallengeEntity(
            id = it.id,
            name = it.name,
            username = username,
            type = ChallengeEntity.ChallengeType.COMPLETED
        )
    }
}

fun AuthoredChallengeDTO.toEntity(username: String): List<ChallengeEntity> {
    return data.map {
        ChallengeEntity(
            id = it.id,
            name = it.name,
            username = username,
            type = ChallengeEntity.ChallengeType.AUTHORED
        )
    }
}