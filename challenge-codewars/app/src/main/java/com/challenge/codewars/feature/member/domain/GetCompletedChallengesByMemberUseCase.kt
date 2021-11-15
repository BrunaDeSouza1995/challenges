package com.challenge.codewars.feature.member.domain

import com.challenge.codewars.feature.member.data.entity.ChallengeEntity
import com.challenge.codewars.feature.base.domain.BaseUseCase
import com.challenge.codewars.feature.member.data.MemberRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetCompletedChallengesByMemberUseCase @Inject constructor(
    private val repository: MemberRepository
) : BaseUseCase<String, List<ChallengeEntity>>() {

    override fun execute(input: String?): Observable<Result<List<ChallengeEntity>>> {
        requireNotNull(input)

        return repository.getCompletedChallengesByMember(input)
            .map(Result.Companion::success)
    }
}