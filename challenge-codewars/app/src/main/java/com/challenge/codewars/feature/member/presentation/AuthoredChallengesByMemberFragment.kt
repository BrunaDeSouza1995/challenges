package com.challenge.codewars.feature.member.presentation

import androidx.fragment.app.viewModels
import com.challenge.codewars.feature.member.presentation.data.MemberEvent
import com.challenge.codewars.feature.member.presentation.data.MemberViewState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AuthoredChallengesByMemberFragment : AbstractChallengesByMemberFragment() {

    private val memberViewModel: MemberViewModel by viewModels()

    override fun getViewModel(): MemberViewModel {
        return memberViewModel
    }

    override fun fetchChallengesByMember() {
        val event = MemberEvent.FetchAuthoredChallengesByMember
        memberViewModel.executeEvent(event)
    }

    override fun setUpObservables() {
        super.setUpObservables()
        memberViewModel.viewStateLiveData.observe(viewLifecycleOwner) {
            val list = (it as? MemberViewState.AuthoredChallengesViewState)?.list
            list?.let { adapter.submitList(list) }
        }
    }
}
