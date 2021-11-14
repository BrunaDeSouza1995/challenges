package com.challenge.codewars.feature.base.domain

import io.reactivex.schedulers.Schedulers.trampoline
import org.junit.Assert.*
import org.junit.Test

class BaseUseCaseTest {

    private val useCase = FakeUseCase()
    private val input = Pair(1, 2)
    private val expected = input.first + input.second

    @Test
    fun `test use case invoke successful`() {
        useCase.invoke(
            input,
            trampoline(),
            trampoline(),
            onDispatchSuccessResult = {
                assertEquals(expected, it)
            }, onDispatchErrorResult = {
                fail("Expected success result")
            })
    }

    @Test
    fun `test use case invoke unsuccessful`() {
        useCase.invoke(
            null,
            trampoline(),
            trampoline(),
            onDispatchSuccessResult = {
                fail("Expected error result")
            }, onDispatchErrorResult = {
                assertTrue(it is RuntimeException)
            })
    }
}
