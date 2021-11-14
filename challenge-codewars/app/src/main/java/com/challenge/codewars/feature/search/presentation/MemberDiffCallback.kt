package com.challenge.codewars.feature.search.presentation

import androidx.recyclerview.widget.DiffUtil
import com.challenge.codewars.feature.base.data.entity.MemberEntity

object MemberDiffCallback : DiffUtil.ItemCallback<MemberEntity>() {
    override fun areItemsTheSame(oldItem: MemberEntity, newItem: MemberEntity): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: MemberEntity, newItem: MemberEntity): Boolean {
        return oldItem.id == newItem.id
    }
}