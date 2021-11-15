package com.challenge.codewars.feature.base.data.dto.extension

import com.challenge.codewars.feature.search.data.entity.MemberEntity
import com.challenge.codewars.feature.search.data.entity.MemberFakeEntity
import org.junit.Assert.assertEquals
import org.junit.Test

class MemberDTOExtTest {

    @Test
    fun `convert MemberDTO to MemberEntity`() {
        val expected =
            MemberEntity(name = "some_user", rank = 134, bestLanguage = "JavaScript", point = 1819)

        assertEquals(expected, MemberFakeEntity.memberEntity())
    }
}