package com.challenge.codewars.feature.member.domain

import com.challenge.codewars.feature.base.domain.BaseUseCase
import com.challenge.codewars.feature.member.data.MemberRepository
import io.reactivex.Observable
import javax.inject.Inject

class FetchCompletedChallengesByMemberUseCase @Inject constructor(
    private val repository: MemberRepository
) : BaseUseCase<String, Unit>() {

    override fun execute(input: String?): Observable<Result<Unit>> {
        requireNotNull(input)

        return repository.fetchCompletedChallengesByMember(input)
            .map { Result.success(Unit) }
    }
}