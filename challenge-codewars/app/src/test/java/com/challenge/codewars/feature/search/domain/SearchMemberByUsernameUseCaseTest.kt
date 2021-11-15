package com.challenge.codewars.feature.search.domain

import com.challenge.codewars.feature.search.data.SearchRepository
import com.challenge.codewars.feature.search.data.dto.MemberFakeDTO.member
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test

class SearchMemberByUsernameUseCaseTest {

    private lateinit var useCase: SearchMemberByUsernameUseCase
    private val mockSearchRepository = mockk<SearchRepository>()
    private val testObserver = TestObserver<Result<Unit>>()

    @Before
    fun setup() {
        useCase = SearchMemberByUsernameUseCase(mockSearchRepository)
    }

    @Test
    fun `when execute use case then return nothing`() {
        val input = "some_user"
        val result = Result.success(member())
        val observable = Observable.just(result)
        every { mockSearchRepository.searchMemberByUsernameOrId(input) } returns observable

        useCase.process(input).subscribe(testObserver)

        testObserver.assertValue { it.isSuccess }
    }

    @Test
    fun `when execute use case thrown exception then return exception`() {
        every { mockSearchRepository.getSearchedMembers() }.throws(Exception())

        useCase.process().subscribe(testObserver)

        testObserver.assertValue { it.isFailure }
    }
}
