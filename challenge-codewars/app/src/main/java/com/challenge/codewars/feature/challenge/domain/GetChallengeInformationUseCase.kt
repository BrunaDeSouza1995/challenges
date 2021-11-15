package com.challenge.codewars.feature.challenge.domain

import com.challenge.codewars.feature.base.data.dto.ChallengeDTO
import com.challenge.codewars.feature.base.domain.BaseUseCase
import com.challenge.codewars.feature.challenge.data.ChallengeRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetChallengeInformationUseCase @Inject constructor(
    val repository: ChallengeRepository
) : BaseUseCase<String, ChallengeDTO>() {
    override fun execute(input: String?): Observable<Result<ChallengeDTO>> {
        requireNotNull(input)

        return repository.getChallengeById(input)
    }
}
