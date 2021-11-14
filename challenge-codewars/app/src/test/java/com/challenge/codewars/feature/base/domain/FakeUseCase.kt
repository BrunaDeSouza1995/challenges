package com.challenge.codewars.feature.base.domain

import io.reactivex.Observable

class FakeUseCase : UseCase<Pair<Int, Int>, Int>() {

    override fun execute(input: Pair<Int, Int>?): Observable<Result<Int>> {
        requireNotNull(input)

        val number1 = input.first
        val number2 = input.second
        val sum = number1 + number2

        return Observable.just(Result.success(sum))
    }
}
