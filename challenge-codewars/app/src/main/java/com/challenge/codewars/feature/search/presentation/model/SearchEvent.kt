package com.challenge.codewars.feature.search.presentation.model

sealed class SearchEvent {
    data class SearchMemberByUsernameEvent(val username: String) : SearchEvent()
    data class ShowChallengesByMember(val username: String) : SearchEvent()
    data class SortFoundMemberEvent(val checkedId: Int, val isChecked: Boolean) : SearchEvent()
}
