package com.challenge.codewars.feature.base.domain

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers

abstract class BaseUseCase<I, O> {

    fun invoke(
        input: I? = null,
        subscribe: Scheduler = Schedulers.io(),
        observe: Scheduler = Schedulers.io(),
        onDispatchSuccessResult: (successResult: O) -> Unit = {},
        onDispatchErrorResult: (errorResult: Throwable) -> Unit = {}
    ): Disposable {
        return Observable
            .fromCallable { guardEntrance(input) }
            .filter { it }
            .switchMap { execute(input) }
            .onErrorReturn(Result.Companion::failure)
            .subscribeOn(subscribe)
            .observeOn(observe)
            .subscribe {
                try {
                    onDispatchSuccessResult(it.getOrThrow())
                } catch (e: Exception) {
                    onDispatchErrorResult(e)
                }
            }
    }

    open fun guardEntrance(input: I? = null): Boolean {
        return true
    }

    abstract fun execute(input: I? = null): Observable<Result<O>>
}