package com.challenge.codewars.feature.challenge.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.challenge.codewars.feature.challenge.data.dto.ChallengeDTO
import com.challenge.codewars.feature.challenge.domain.GetChallengeInformationUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ChallengeViewModel @Inject constructor(
    private val getChallengeInformationUseCase: GetChallengeInformationUseCase
) : ViewModel() {

    val viewState = MutableLiveData<ChallengeDTO>()

    fun getChallengeInformation(id: String) {
        getChallengeInformationUseCase.invoke(
            input = id,
            onDispatchSuccessResult = viewState::postValue
        )
    }
}
