package com.challenge.codewars.feature.member.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.challenge.codewars.feature.member.domain.FetchAuthoredChallengesByMemberUseCase
import com.challenge.codewars.feature.member.domain.FetchCompletedChallengesByMemberUseCase
import com.challenge.codewars.feature.member.domain.GetAuthoredChallengesByMemberUseCase
import com.challenge.codewars.feature.member.domain.GetCompletedChallengesByMemberUseCase
import com.challenge.codewars.feature.member.presentation.data.MemberDirections
import com.challenge.codewars.feature.member.presentation.data.MemberEvent
import com.challenge.codewars.feature.member.presentation.data.MemberViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MemberViewModel @Inject constructor(
    private val fetchCompletedChallengesByMemberUseCase: FetchCompletedChallengesByMemberUseCase,
    private val fetchAuthoredChallengesByMemberUseCase: FetchAuthoredChallengesByMemberUseCase,
    private val getCompletedChallengesByMemberUseCase: GetCompletedChallengesByMemberUseCase,
    private val getAuthoredChallengesByMemberUseCase: GetAuthoredChallengesByMemberUseCase
) : ViewModel() {

    private var username = ""
    val viewStateLiveData = MutableLiveData<MemberViewState>()
    val directionsLiveData = MutableLiveData<MemberDirections>()

    fun executeEvent(event: MemberEvent) {
        when (event) {
            is MemberEvent.SetUpUsername -> setupUsername(event)
            is MemberEvent.FetchAuthoredChallengesByMember -> fetchAuthoredChallengesByMember()
            is MemberEvent.FetchCompletedChallengesByMember -> fetchCompletedChallengesByMember()
            is MemberEvent.ShowChallenge -> showChallenge(event)
        }
    }

    private fun setupUsername(event: MemberEvent.SetUpUsername) {
        username = event.username
        getChallenges()
    }

    private fun getChallenges() {
        getCompletedChallengesByMember()
        getAuthoredChallengesByMember()
    }

    private fun getCompletedChallengesByMember() {
        getCompletedChallengesByMemberUseCase.invoke(
            input = username,
            onDispatchSuccessResult = {
                viewStateLiveData.postValue(MemberViewState.CompletedChallengesViewState(it))
            }
        )
    }

    private fun getAuthoredChallengesByMember() {
        getAuthoredChallengesByMemberUseCase.invoke(
            input = username,
            onDispatchSuccessResult = {
                viewStateLiveData.postValue(MemberViewState.AuthoredChallengesViewState(it))
            }
        )
    }

    private fun fetchCompletedChallengesByMember() {
        fetchCompletedChallengesByMemberUseCase.invoke(
            input = username,
            onDispatchErrorResult = {
                directionsLiveData.value = MemberDirections.HomeDirection
            }
        )
    }

    private fun fetchAuthoredChallengesByMember() {
        fetchAuthoredChallengesByMemberUseCase.invoke(
            input = username,
            onDispatchErrorResult = {
                directionsLiveData.value = MemberDirections.HomeDirection
            }
        )
    }

    private fun showChallenge(event: MemberEvent.ShowChallenge) {
        val direction = MemberDirections.ChallengeDirection(event.id)
        directionsLiveData.value = direction
    }
}