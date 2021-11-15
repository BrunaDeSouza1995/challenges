package com.challenge.codewars.feature.member.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.challenge.codewars.databinding.FragmentChallengesByMemberBinding
import com.challenge.codewars.feature.member.presentation.data.MemberEvent

abstract class AbstractChallengesByMemberFragment : Fragment() {

    private var binding: FragmentChallengesByMemberBinding? = null
    val adapter = ChallengesAdapter(::showChallenge)

    abstract fun getViewModel(): MemberViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentChallengesByMemberBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        setUpViewModel()
        fetchChallengesByMember()
        setUpObservables()
    }

    private fun setUpViews() {
        binding?.challengesByMemberList?.adapter = adapter
    }

    private fun setUpViewModel() {
        val username = (activity as? MemberActivity)?.args?.username.orEmpty()
        val event = MemberEvent.SetUpUsername(username)
        getViewModel().executeEvent(event)
    }

    abstract fun fetchChallengesByMember()

    private fun showChallenge(it: String) {
        val event = MemberEvent.ShowChallenge(it)
        getViewModel().executeEvent(event)
    }

    open fun setUpObservables() {
        getViewModel().directionsLiveData.observe(viewLifecycleOwner) {
            findNavController().navigate(it.navDirections)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}