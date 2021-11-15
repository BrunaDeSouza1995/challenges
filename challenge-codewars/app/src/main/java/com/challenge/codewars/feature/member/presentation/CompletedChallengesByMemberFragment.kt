package com.challenge.codewars.feature.member.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.challenge.codewars.databinding.FragmentCompletedChallengesByMemberBinding

class CompletedChallengesByMemberFragment : Fragment() {

    var binding: FragmentCompletedChallengesByMemberBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCompletedChallengesByMemberBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val username = (activity as? MemberActivity)?.args?.username
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}