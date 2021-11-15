package com.challenge.codewars.feature.member.presentation

import androidx.recyclerview.widget.RecyclerView
import com.challenge.codewars.databinding.ItemListChallengeBinding
import com.challenge.codewars.feature.base.data.entity.ChallengeEntity

class ChallengesViewHolder(
    private val binding: ItemListChallengeBinding,
    private val onClick: (String) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(challenge: ChallengeEntity) {
        val (id, name, _, _) = challenge
        binding.itemChallengeName.text = name
        binding.itemChallengeContainer.setOnClickListener { onClick(id) }
    }
}