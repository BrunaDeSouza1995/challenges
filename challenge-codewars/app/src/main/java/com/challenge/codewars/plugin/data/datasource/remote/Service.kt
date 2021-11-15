package com.challenge.codewars.plugin.data.datasource.remote

import com.challenge.codewars.feature.base.data.dto.AuthoredChallengeDTO
import com.challenge.codewars.feature.base.data.dto.CompletedChallengeDTO
import com.challenge.codewars.feature.base.data.dto.MemberDTO
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface Service {

    @GET("api/v1/users/{user}")
    fun searchMemberByUsernameOrId(@Path("user") user: String): Observable<Response<MemberDTO>>

    @GET("api/v1/users/{user}/code-challenges/completed")
    fun getCompletedChallengesByMember(@Path("user") user: String): Observable<Response<CompletedChallengeDTO>>

    @GET("api/v1/users/{user}/code-challenges/authored")
    fun getAuthoredChallengesByMember(@Path("user") user: String): Observable<Response<AuthoredChallengeDTO>>
}
