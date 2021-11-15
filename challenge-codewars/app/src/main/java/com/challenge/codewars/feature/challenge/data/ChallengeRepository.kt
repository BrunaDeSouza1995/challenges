package com.challenge.codewars.feature.challenge.data

import com.challenge.codewars.feature.base.data.dto.ChallengeDTO
import io.reactivex.Observable

interface ChallengeRepository {
    fun getChallengeById(id: String) : Observable<Result<ChallengeDTO>>
}