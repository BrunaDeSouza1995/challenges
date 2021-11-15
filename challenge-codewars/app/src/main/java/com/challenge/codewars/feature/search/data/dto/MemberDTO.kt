package com.challenge.codewars.feature.search.data.dto

data class MemberDTO(
    val username: String,
    val leaderboardPosition: Int,
    val ranks: RanksDTO
)
