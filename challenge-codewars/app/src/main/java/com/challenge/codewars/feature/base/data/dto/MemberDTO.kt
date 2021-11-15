package com.challenge.codewars.feature.base.data.dto

data class MemberDTO(
    val username: String,
    val leaderboardPosition: Int,
    val ranks: RanksDTO
)
