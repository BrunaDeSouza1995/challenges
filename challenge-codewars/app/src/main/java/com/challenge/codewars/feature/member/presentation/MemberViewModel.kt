package com.challenge.codewars.feature.member.presentation

import androidx.lifecycle.ViewModel
import com.challenge.codewars.feature.member.presentation.data.MemberEvent
import javax.inject.Inject

class MemberViewModel @Inject constructor() : ViewModel() {

    fun executeEvent(event: MemberEvent){
        when(event) {
            is MemberEvent.GetAuthoredChallengesByMember -> TODO()
            is MemberEvent.GetCompletedChallengesByMember -> TODO()
        }
    }
}