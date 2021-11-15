package com.challenge.codewars.feature.member.presentation.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.challenge.codewars.databinding.ItemListChallengeBinding.inflate
import com.challenge.codewars.feature.member.data.entity.ChallengeEntity

class ChallengesAdapter(
    private val onClick: (String) -> Unit
) : ListAdapter<ChallengeEntity, ChallengesViewHolder>(ChallengesDiffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChallengesViewHolder {
        val binding = inflate(LayoutInflater.from(parent.context), parent, false)
        return ChallengesViewHolder(binding, onClick)
    }

    override fun onBindViewHolder(holder: ChallengesViewHolder, position: Int) {
        val challenge = getItem(position)
        holder.bind(challenge)
    }
}
