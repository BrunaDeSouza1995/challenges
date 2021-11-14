package com.challenge.codewars.feature.search.presentation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.challenge.codewars.R
import com.challenge.codewars.feature.base.data.entity.MemberEntity
import com.challenge.codewars.feature.search.domain.GetSearchedMembersUseCase
import com.challenge.codewars.feature.search.domain.SearchUseCase
import com.challenge.codewars.feature.search.presentation.data.MemberSortBy
import com.challenge.codewars.feature.search.presentation.data.extension.sortByIdOrRank
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val searchUseCase: SearchUseCase,
    getSearchedMembersUseCase: GetSearchedMembersUseCase
) : ViewModel() {

    private var memberSortBy = MemberSortBy.ID_DESC

    val searchedMembersLiveData: MutableLiveData<List<MemberEntity>> by lazy { MutableLiveData<List<MemberEntity>>() }

    init {
        getSearchedMembers(getSearchedMembersUseCase)
    }

    private fun getSearchedMembers(getSearchedMembersUseCase: GetSearchedMembersUseCase) {
        getSearchedMembersUseCase.invoke(
            onDispatchSuccessResult = {
                memberSortBy(it)
            }
        )
    }

    fun searchMemberByUsernameOrId(text: String) {
        searchUseCase.invoke(
            text,
            onDispatchSuccessResult = {
            },
            onDispatchErrorResult = {
            }
        )
    }

    fun setMemberSortBy(checkedId: Int, isChecked: Boolean) {
        if (isChecked.not()) return

        memberSortBy = when (checkedId) {
            R.id.search_result_sort_by_rack_button -> MemberSortBy.RACK_DESC
            else -> MemberSortBy.ID_DESC
        }
        memberSortBy()
    }

    private fun memberSortBy(members: List<MemberEntity>? = null) {
        val list = (members ?: searchedMembersLiveData.value)?.toMutableList()
        list.sortByIdOrRank(memberSortBy)
        searchedMembersLiveData.postValue(list)
    }
}
