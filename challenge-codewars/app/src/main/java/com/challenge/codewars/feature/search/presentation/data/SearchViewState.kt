package com.challenge.codewars.feature.search.presentation.data

import com.challenge.codewars.feature.base.data.entity.MemberEntity

sealed class SearchViewState {

    data class SearchedMembersViewState(val members: List<MemberEntity>) : SearchViewState()

}
