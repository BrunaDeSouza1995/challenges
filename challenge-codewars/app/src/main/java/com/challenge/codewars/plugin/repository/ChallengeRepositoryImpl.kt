package com.challenge.codewars.plugin.repository

import com.challenge.codewars.feature.challenge.data.dto.ChallengeDTO
import com.challenge.codewars.feature.base.data.call
import com.challenge.codewars.feature.challenge.data.ChallengeRepository
import com.challenge.codewars.plugin.network.CodewarsService
import io.reactivex.Observable
import javax.inject.Inject

class ChallengeRepositoryImpl @Inject constructor(
    private val service: CodewarsService
) : ChallengeRepository {

    override fun getChallengeById(id: String): Observable<Result<ChallengeDTO>> {
        return service.getChallengeInformation(id).call()
    }
}
