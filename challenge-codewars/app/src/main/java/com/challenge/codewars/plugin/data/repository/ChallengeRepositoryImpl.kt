package com.challenge.codewars.plugin.data.repository

import com.challenge.codewars.feature.base.data.dto.ChallengeDTO
import com.challenge.codewars.feature.base.data.repository.call
import com.challenge.codewars.feature.challenge.data.ChallengeRepository
import com.challenge.codewars.plugin.data.datasource.remote.Service
import io.reactivex.Observable
import javax.inject.Inject

class ChallengeRepositoryImpl @Inject constructor(
    private val service: Service
) : ChallengeRepository {

    override fun getChallengeById(id: String): Observable<Result<ChallengeDTO>> {
        return service.getChallengeInformation(id).call()
    }
}
