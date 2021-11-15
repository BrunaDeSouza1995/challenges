package com.challenge.codewars.feature.search.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.challenge.codewars.databinding.FragmentSearchBinding
import com.challenge.codewars.feature.search.presentation.list.MemberAdapter
import com.challenge.codewars.feature.search.presentation.model.SearchEvent
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var binding: FragmentSearchBinding? = null

    private val viewModel: SearchViewModel by viewModels()

    private var adapter: MemberAdapter? = MemberAdapter(::showChallengesByMember)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpViews()
        setUpObservables()
    }

    private fun setUpViews() {
        binding?.searchResultList?.adapter = adapter
        binding?.searchButton?.setOnClickListener { searchMemberByUsernameEvent() }
        binding?.searchResultSortByGroup?.addOnButtonCheckedListener(::sortFoundMemberEvent)
    }

    private fun searchMemberByUsernameEvent() {
        val username = binding?.searchTextInput?.text.toString()
        val event = SearchEvent.SearchMemberByUsernameEvent(username)
        executeEvent(event)
    }

    private fun sortFoundMemberEvent(view: View, checkedId: Int, isChecked: Boolean) {
        val event = SearchEvent.SortFoundMemberEvent(checkedId, isChecked)
        executeEvent(event)
    }

    private fun showChallengesByMember(it: String) {
        val event = SearchEvent.ShowChallengesByMember(it)
        executeEvent(event)
    }

    private fun executeEvent(event: SearchEvent) {
        viewModel.executeEvent(event)
    }

    private fun setUpObservables() {
        viewModel.searchedMembersLiveData.observe(viewLifecycleOwner) {
            adapter?.submitList(it)
        }
        viewModel.searchDirections.observe(viewLifecycleOwner, findNavController()::navigate)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
