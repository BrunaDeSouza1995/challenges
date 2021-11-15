package com.challenge.codewars.feature.search.presentation

import androidx.recyclerview.widget.RecyclerView
import com.challenge.codewars.databinding.ItemListMemberBinding
import com.challenge.codewars.feature.base.data.entity.MemberEntity

class MemberViewHolder(
    private val binding: ItemListMemberBinding,
    private val onClick: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(member: MemberEntity) {
        val (_, name, rank, bestLanguage, point) = member
        binding.itemMemberName.text = name
        binding.itemMemberRank.text = rank.toString()
        binding.itemMemberLanguage.text = bestLanguage
        binding.itemMemberPoints.text = point.toString()
        binding.itemMemberContainer.setOnClickListener { onClick(member.name) }
    }
}