package com.challenge.codewars.feature.search.presentation.data.extension

import com.challenge.codewars.feature.base.data.entity.MemberEntity
import com.challenge.codewars.feature.search.presentation.data.MemberSortBy

fun MutableList<MemberEntity>?.sortByIdOrRank(sortBy: MemberSortBy) {
    when (sortBy) {
        MemberSortBy.ID_DESC -> this?.sortByDescending { it.id }
        MemberSortBy.RACK_DESC -> this?.sortBy { it.rank }
    }
}
