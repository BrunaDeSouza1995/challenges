package com.challenge.codewars.plugin.data.datasource.remote

import com.challenge.codewars.feature.base.data.dto.MemberDTO
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {

    @GET("api/v1/users/{user}")
    fun searchMemberByUsernameOrId(@Path("user") user: String): Observable<Response<MemberDTO>>
}
