package com.challenge.codewars.feature.member.data

import com.challenge.codewars.feature.base.data.dto.AuthoredChallengeDTO
import com.challenge.codewars.feature.base.data.dto.CompletedChallengeDTO
import com.challenge.codewars.feature.base.data.entity.ChallengeEntity
import io.reactivex.Observable

interface MemberRepository {

    fun fetchCompletedChallengesByMember(username: String) : Observable<Result<CompletedChallengeDTO>>

    fun fetchAuthoredChallengesByMember(username: String) : Observable<Result<AuthoredChallengeDTO>>

    fun getCompletedChallengesByMember(username: String) : Observable<List<ChallengeEntity>>

    fun getAuthoredChallengesByMember(username: String) : Observable<List<ChallengeEntity>>
}