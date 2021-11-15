package com.challenge.codewars.feature.base.data

import io.reactivex.Observable
import retrofit2.HttpException
import retrofit2.Response

fun <R>  Observable<Response<R>>.call(): Observable<Result<R>> {
    return this.switchMap(Response<R>::handleResponse)
        .map(Result.Companion::success)
        .onErrorReturn(Result.Companion::failure)
}

private fun <R> Response<R>.handleResponse(): Observable<R> {
    return if (isSuccessful) {
        Observable.just(body())
    } else {
        Observable.error(HttpException(this))
    }
}
