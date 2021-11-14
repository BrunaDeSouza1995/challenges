package com.challenge.codewars.feature.search.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.challenge.codewars.databinding.FragmentSearchBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SearchFragment : Fragment() {

    private var binding: FragmentSearchBinding? = null

    private val viewModel: SearchViewModel by viewModels()

    @Inject
    lateinit var adapter: SearchAdapter

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
        binding?.searchButton?.setOnClickListener {
            val text = binding?.searchTextInput?.text.toString()
            viewModel.searchMemberByUsernameOrId(text)
        }
        binding?.searchResultSortByGroup?.addOnButtonCheckedListener { _, checkedId, isChecked ->
            viewModel.setMemberSortBy(checkedId, isChecked)
        }
    }

    private fun setUpObservables() {
        viewModel.searchedMembersLiveData.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}
