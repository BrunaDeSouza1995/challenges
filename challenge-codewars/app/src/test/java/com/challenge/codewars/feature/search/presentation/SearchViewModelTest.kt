package com.challenge.codewars.feature.search.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.challenge.codewars.R
import com.challenge.codewars.feature.search.data.SearchFakeRepository
import com.challenge.codewars.feature.search.data.entity.MemberEntity
import com.challenge.codewars.feature.search.data.entity.MemberFakeEntity
import com.challenge.codewars.feature.search.data.entity.MemberFakeEntity.membersEntity
import com.challenge.codewars.feature.search.data.entity.MemberFakeEntity.membersEntitySortByRack
import com.challenge.codewars.feature.search.domain.GetSearchedMembersUseCase
import com.challenge.codewars.feature.search.domain.SearchMemberByUsernameUseCase
import com.challenge.codewars.feature.search.presentation.model.MemberSortBy
import com.challenge.codewars.feature.search.presentation.model.MemberSortBy.RACK_DESC
import com.challenge.codewars.feature.search.presentation.model.SearchEvent
import com.challenge.codewars.feature.search.presentation.model.extension.sortByIdOrRank
import com.challenge.codewars.plugin.getOrAwaitValue
import io.mockk.spyk
import io.mockk.verify
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class SearchViewModelTest {

    @get:Rule
    val executorRule = InstantTaskExecutorRule()

    private val searchRepository = SearchFakeRepository()
    private val getSearchedMembersUseCase = spyk(GetSearchedMembersUseCase(searchRepository))
    private val searchMemberByUsernameUseCase = spyk(SearchMemberByUsernameUseCase(searchRepository))
    private val username = "some_user"
    private lateinit var viewModel: SearchViewModel

    @Before
    fun setUp() {
        viewModel = SearchViewModel(getSearchedMembersUseCase, searchMemberByUsernameUseCase)
    }

    @Test
    fun `when execute search member by username event then verify if use case call`() {
        val event = SearchEvent.SearchMemberByUsernameEvent(username)

        viewModel.executeEvent(event)

        verify(exactly = 1) { searchMemberByUsernameUseCase.invoke(username) }
    }

    @Test
    fun `when execute show challenges by member even then verify if emitter live data`() {
        val event = SearchEvent.ShowChallengesByMember(username)
        val expected = SearchFragmentDirections.actionSearchFragmentToMemberFragment(username)

        viewModel.executeEvent(event)

        viewModel.searchDirections.getOrAwaitValue().run {
            assertEquals(expected, this)
        }
    }

    @Test
    fun `when execute short by rack found member event then verify if live data call`() {
        val checkedId = R.id.search_result_sort_by_rack_button
        val isChecked = true
        val event = SearchEvent.SortFoundMemberEvent(checkedId, isChecked)
        viewModel.searchedMembersLiveData.value = membersEntity()

        viewModel.executeEvent(event)

        viewModel.searchedMembersLiveData.getOrAwaitValue().run {
            assertEquals(membersEntitySortByRack(), this)
        }
    }

    @Test
    fun `when execute short by id found member event then verify if live data call`() {
        val checkedId = R.id.search_result_sort_by_button
        val isChecked = true
        val event = SearchEvent.SortFoundMemberEvent(checkedId, isChecked)
        viewModel.searchedMembersLiveData.value = membersEntity()

        viewModel.executeEvent(event)

        viewModel.searchedMembersLiveData.getOrAwaitValue().run {
            assertEquals(membersEntity(), this)
        }
    }
}