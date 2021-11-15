package com.challenge.codewars.feature.search.presentation.model.extension

import com.challenge.codewars.feature.search.data.entity.MemberEntity
import com.challenge.codewars.feature.search.presentation.model.MemberSortBy

fun MutableList<MemberEntity>?.sortByIdOrRank(sortBy: MemberSortBy): MutableList<MemberEntity>? {
    when (sortBy) {
        MemberSortBy.ID -> this?.sortByDescending { it.id }
        MemberSortBy.RACK -> this?.sortBy { it.rank }
    }

    return this
}
