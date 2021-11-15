package com.challenge.codewars.feature.member.presentation.data

sealed class MemberEvent{
    data class GetAuthoredChallengesByMember(val username: String): MemberEvent()
    data class GetCompletedChallengesByMember(val username: String): MemberEvent()
}
