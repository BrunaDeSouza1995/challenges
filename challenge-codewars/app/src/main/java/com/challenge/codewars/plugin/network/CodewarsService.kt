package com.challenge.codewars.plugin.network

import com.challenge.codewars.feature.base.data.dto.AuthoredChallengeDTO
import com.challenge.codewars.feature.base.data.dto.ChallengeDTO
import com.challenge.codewars.feature.base.data.dto.CompletedChallengeDTO
import com.challenge.codewars.feature.search.data.dto.MemberDTO
import io.reactivex.Observable
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CodewarsService {

    @GET("api/v1/users/{user}")
    fun searchMemberByUsernameOrId(@Path("user") user: String): Observable<Response<MemberDTO>>

    @GET("api/v1/users/{user}/code-challenges/completed")
    fun getCompletedChallengesByMember(@Path("user") user: String): Observable<Response<CompletedChallengeDTO>>

    @GET("api/v1/users/{user}/code-challenges/authored")
    fun getAuthoredChallengesByMember(@Path("user") user: String): Observable<Response<AuthoredChallengeDTO>>

    @GET("api/v1/code-challenges/{challenge}")
    fun getChallengeInformation(@Path("challenge") id: String) : Observable<Response<ChallengeDTO>>
}
