package com.challenge.codewars.feature.search.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import com.challenge.codewars.feature.search.domain.SearchUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

private const val TAG = "SearchViewModel"
@HiltViewModel
class SearchViewModel @Inject constructor(private val searchUseCase: SearchUseCase) : ViewModel() {

    fun searchMemberByUsernameOrId(text: String) {
        searchUseCase.invoke(
            text,
            onDispatchSuccessResult = {
                Log.d(TAG, "onDispatchSuccessResult: $it")
            },
            onDispatchErrorResult = {
                Log.d(TAG, "onDispatchErrorResult: $it")
            }
        )
    }
}