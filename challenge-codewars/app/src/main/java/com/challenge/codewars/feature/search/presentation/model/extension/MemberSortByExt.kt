package com.challenge.codewars.feature.search.presentation.model.extension

import com.challenge.codewars.feature.search.data.entity.MemberEntity
import com.challenge.codewars.feature.search.presentation.model.MemberSortBy

fun MutableList<MemberEntity>?.sortByIdOrRank(sortBy: MemberSortBy) {
    when (sortBy) {
        MemberSortBy.ID_DESC -> this?.sortByDescending { it.id }
        MemberSortBy.RACK_DESC -> this?.sortBy { it.rank }
    }
}
