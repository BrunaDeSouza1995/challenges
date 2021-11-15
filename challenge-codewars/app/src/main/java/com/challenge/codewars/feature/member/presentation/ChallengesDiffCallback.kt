package com.challenge.codewars.feature.member.presentation

import androidx.recyclerview.widget.DiffUtil
import com.challenge.codewars.feature.base.data.entity.ChallengeEntity

object ChallengesDiffCallback : DiffUtil.ItemCallback<ChallengeEntity>() {
    override fun areItemsTheSame(oldItem: ChallengeEntity, newItem: ChallengeEntity): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: ChallengeEntity, newItem: ChallengeEntity): Boolean {
        return oldItem.id == newItem.id
    }
}