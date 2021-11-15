package com.challenge.codewars.feature.search.presentation.model

sealed class SearchViewState {
    object SuccessSearchingViewState : SearchViewState()
    object ErrorSearchingViewState : SearchViewState()
}
