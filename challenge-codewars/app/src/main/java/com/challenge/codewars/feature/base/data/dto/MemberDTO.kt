package com.challenge.codewars.feature.base.data.dto

data class MemberDTO(
    val clan: String,
    val codeChallenges: CodeChallengesDTO,
    val honor: Int,
    val leaderboardPosition: Int,
    val name: String,
    val ranks: RanksDTO,
    val skills: List<String>,
    val username: String
)