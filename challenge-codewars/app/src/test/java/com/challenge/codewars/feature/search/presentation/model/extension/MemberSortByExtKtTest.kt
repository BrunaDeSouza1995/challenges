package com.challenge.codewars.feature.search.presentation.model.extension

import com.challenge.codewars.feature.search.data.entity.MemberFakeEntity.membersEntity
import com.challenge.codewars.feature.search.data.entity.MemberFakeEntity.membersEntitySortByRack
import com.challenge.codewars.feature.search.presentation.model.MemberSortBy
import org.junit.Assert.assertEquals
import org.junit.Test

class MemberSortByExtKtTest {

    @Test
    fun `test sort by id`() {
        val list = membersEntitySortByRack().toMutableList().sortByIdOrRank(MemberSortBy.ID)

        assertEquals(membersEntity(), list)
    }

    @Test
    fun `test sort by rack`() {
        val list = membersEntity().toMutableList().sortByIdOrRank(MemberSortBy.RACK)

        assertEquals(membersEntitySortByRack(), list)
    }
}