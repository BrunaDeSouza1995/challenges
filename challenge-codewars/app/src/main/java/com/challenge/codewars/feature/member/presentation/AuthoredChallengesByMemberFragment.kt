package com.challenge.codewars.feature.member.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.challenge.codewars.databinding.FragmentAuthoredChallengesByMemberBinding

class AuthoredChallengesByMemberFragment : Fragment() {

    var binding: FragmentAuthoredChallengesByMemberBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAuthoredChallengesByMemberBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}