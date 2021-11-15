package com.challenge.codewars.feature.member.presentation.model

import androidx.navigation.NavDirections
import com.challenge.codewars.MemberNavigationDirections

sealed class MemberDirections(open val navDirections: NavDirections) {

    data class ChallengeDirection(
        val id: String
    ) : MemberDirections(MemberNavigationDirections.actionToChallengeFragment(id))

    object HomeDirection : MemberDirections(MemberNavigationDirections.actionToMainActivity())

}