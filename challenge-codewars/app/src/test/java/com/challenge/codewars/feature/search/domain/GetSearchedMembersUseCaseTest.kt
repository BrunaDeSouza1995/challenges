package com.challenge.codewars.feature.search.domain

import com.challenge.codewars.feature.search.data.SearchRepository
import com.challenge.codewars.feature.search.data.entity.MemberEntity
import com.challenge.codewars.feature.search.data.entity.MemberFakeEntity
import io.mockk.every
import io.mockk.mockk
import io.reactivex.Observable
import io.reactivex.observers.TestObserver
import org.junit.Before
import org.junit.Test

class GetSearchedMembersUseCaseTest {

    private lateinit var useCase: GetSearchedMembersUseCase
    private val mockSearchRepository = mockk<SearchRepository>()
    private val testObserver = TestObserver<Result<List<MemberEntity>>>()

    @Before
    fun setup() {
        useCase = GetSearchedMembersUseCase(mockSearchRepository)
    }

    @Test
    fun `when execute use case then return list with member`() {
        val list = MemberFakeEntity.membersEntity()
        val result = Result.success(list)
        val observable = Observable.just(result)
        every { mockSearchRepository.getSearchedMembers() } returns observable

        useCase.process().subscribe(testObserver)

        testObserver.assertValue { it.isSuccess && it.getOrThrow() == list }
    }

    @Test
    fun `when execute use case thrown exception then return exception`() {
        every { mockSearchRepository.getSearchedMembers() }.throws(Exception())

        useCase.process().subscribe(testObserver)

        testObserver.assertValue { it.isFailure }
    }
}
