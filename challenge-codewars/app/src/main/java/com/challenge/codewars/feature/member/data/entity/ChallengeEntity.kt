package com.challenge.codewars.feature.member.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "challenge")
data class ChallengeEntity(
    @PrimaryKey
    val id: String,
    val name: String,
    val username: String,
    val type: ChallengeType
) {

    enum class ChallengeType {
        COMPLETED, AUTHORED
    }
}
