package com.challenge.codewars.feature.member.domain

import com.challenge.codewars.feature.base.data.entity.ChallengeEntity
import com.challenge.codewars.feature.base.domain.BaseUseCase
import com.challenge.codewars.feature.member.data.MemberRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetAuthoredChallengesByMemberUseCase @Inject constructor(
    private val repository: MemberRepository
) : BaseUseCase<String, List<ChallengeEntity>>() {

    override fun execute(input: String?): Observable<Result<List<ChallengeEntity>>> {
        requireNotNull(input)

        return repository.getAuthoredChallengesByMember(input)
            .map(Result.Companion::success)
    }
}