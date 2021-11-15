package com.challenge.codewars.feature.base.data.dto.extension

import com.challenge.codewars.feature.base.data.dto.MemberDTO
import com.challenge.codewars.feature.base.data.entity.MemberEntity
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert.assertEquals
import org.junit.Test

class MemberDTOExtTest {

    @Test
    fun `convert MemberDTO to MemberEntity`() {
        val mockMemberDTO = mockk<MemberDTO>()
        val expected = MemberEntity(name = "Bruna", rank = 1, bestLanguage = "bestLanguage", point = 123)

        every { mockMemberDTO.username } returns "Bruna"

        assertEquals(expected, mockMemberDTO.toEntity())
    }
}