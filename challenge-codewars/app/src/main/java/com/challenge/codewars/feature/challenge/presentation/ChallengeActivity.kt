package com.challenge.codewars.feature.challenge.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.navArgs
import com.challenge.codewars.databinding.ActivityChallengeBinding
import com.challenge.codewars.feature.challenge.data.dto.ChallengeDTO
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ChallengeActivity : AppCompatActivity() {

    private var binding: ActivityChallengeBinding? = null
    private val args by navArgs<ChallengeActivityArgs>()
    private val viewModel: ChallengeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityChallengeBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        setupViewModel()
        setupObservable()
    }

    private fun setupViewModel() {
        viewModel.getChallengeInformation(args.id)
    }

    private fun setupObservable() {
        viewModel.viewState.observe(this, ::setupData)
    }

    private fun setupData(challenge: ChallengeDTO) {
        binding?.challengeTitleText?.text = challenge.name
        binding?.challengeInformationText?.text = challenge.description
    }
}
