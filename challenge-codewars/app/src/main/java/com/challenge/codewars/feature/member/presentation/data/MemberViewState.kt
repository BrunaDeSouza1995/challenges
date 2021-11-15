package com.challenge.codewars.feature.member.presentation.data

import com.challenge.codewars.feature.base.data.entity.ChallengeEntity

sealed class MemberViewState(open val list: List<ChallengeEntity>) {
    data class AuthoredChallengesViewState(override val list: List<ChallengeEntity>) : MemberViewState(list)
    data class CompletedChallengesViewState(override val list: List<ChallengeEntity>) : MemberViewState(list)
}
