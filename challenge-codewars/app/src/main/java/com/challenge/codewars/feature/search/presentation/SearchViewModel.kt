package com.challenge.codewars.feature.search.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.challenge.codewars.R
import com.challenge.codewars.feature.search.data.entity.MemberEntity
import com.challenge.codewars.feature.search.domain.GetSearchedMembersUseCase
import com.challenge.codewars.feature.search.domain.SearchMemberByUsernameUseCase
import com.challenge.codewars.feature.search.presentation.model.MemberSortBy
import com.challenge.codewars.feature.search.presentation.model.SearchEvent
import com.challenge.codewars.feature.search.presentation.model.SearchViewState
import com.challenge.codewars.feature.search.presentation.model.extension.sortByIdOrRank
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    getSearchedMembersUseCase: GetSearchedMembersUseCase,
    private val searchMemberByUsernameUseCase: SearchMemberByUsernameUseCase
) : ViewModel() {

    private var memberSortBy = MemberSortBy.ID

    val searchedMembersLiveData: MutableLiveData<List<MemberEntity>> by lazy { MutableLiveData<List<MemberEntity>>() }
    val viewStateLiveData = MutableLiveData<SearchViewState>()
    val searchDirections = MutableLiveData<NavDirections>()

    init {
        getSearchedMembers(getSearchedMembersUseCase)
    }

    private fun getSearchedMembers(getSearchedMembersUseCase: GetSearchedMembersUseCase) {
        getSearchedMembersUseCase.invoke(
            onDispatchSuccessResult = ::memberSortBy
        )
    }

    fun executeEvent(event: SearchEvent) {
        when (event) {
            is SearchEvent.SearchMemberByUsernameEvent -> {
                searchMemberByUsernameOrId(event.username)
            }
            is SearchEvent.ShowChallengesByMember -> {
                showChallengesByMember(event)
            }
            is SearchEvent.SortFoundMemberEvent -> {
                setMemberSortBy(event.checkedId, event.isChecked)
            }
        }
    }

    private fun searchMemberByUsernameOrId(text: String) {
        searchMemberByUsernameUseCase.invoke(text,
            onDispatchSuccessResult = {
                viewStateLiveData.postValue(SearchViewState.SuccessSearchingViewState)
            },
            onDispatchErrorResult = {
                viewStateLiveData.postValue(SearchViewState.ErrorSearchingViewState)
            })
    }

    private fun showChallengesByMember(event: SearchEvent.ShowChallengesByMember) {
        val username = event.username
        val action = SearchFragmentDirections.actionSearchFragmentToMemberFragment(username)
        searchDirections.value = action
    }

    private fun setMemberSortBy(checkedId: Int, isChecked: Boolean) {
        if (isChecked.not()) return

        memberSortBy = when (checkedId) {
            R.id.search_result_sort_by_rack_button -> MemberSortBy.RACK
            else -> MemberSortBy.ID
        }
        memberSortBy()
    }

    private fun memberSortBy(members: List<MemberEntity>? = null) {
        val list = (members ?: searchedMembersLiveData.value)?.toMutableList()
        val listSorted = list.sortByIdOrRank(memberSortBy)
        searchedMembersLiveData.postValue(listSorted)
    }
}
