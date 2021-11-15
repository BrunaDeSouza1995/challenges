package com.challenge.codewars.feature.search.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.challenge.codewars.databinding.ItemListMemberBinding.inflate
import com.challenge.codewars.feature.base.data.entity.MemberEntity

class SearchAdapter(
    private val onClick: (String) -> Unit
) : ListAdapter<MemberEntity, MemberViewHolder>(MemberDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MemberViewHolder {
        val binding = inflate(LayoutInflater.from(parent.context), parent, false)
        return MemberViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: MemberViewHolder, position: Int) {
        val member = getItem(position)
        holder.bind(member)
    }
}
