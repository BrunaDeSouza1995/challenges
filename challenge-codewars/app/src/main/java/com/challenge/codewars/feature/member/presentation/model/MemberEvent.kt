package com.challenge.codewars.feature.member.presentation.model

sealed class MemberEvent{
    data class SetUpUsername(val username: String): MemberEvent()
    object FetchAuthoredChallengesByMember: MemberEvent()
    object FetchCompletedChallengesByMember: MemberEvent()
    data class ShowChallenge(val id: String): MemberEvent()
}
