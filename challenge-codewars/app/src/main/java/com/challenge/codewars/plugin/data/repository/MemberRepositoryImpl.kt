package com.challenge.codewars.plugin.data.repository

import com.challenge.codewars.feature.base.data.dto.AuthoredChallengeDTO
import com.challenge.codewars.feature.base.data.dto.CompletedChallengeDTO
import com.challenge.codewars.feature.base.data.dto.extension.toEntity
import com.challenge.codewars.feature.base.data.entity.ChallengeEntity
import com.challenge.codewars.feature.base.data.entity.ChallengeEntity.ChallengeType.AUTHORED
import com.challenge.codewars.feature.base.data.entity.ChallengeEntity.ChallengeType.COMPLETED
import com.challenge.codewars.feature.base.data.repository.call
import com.challenge.codewars.feature.member.data.MemberRepository
import com.challenge.codewars.plugin.data.datasource.local.dao.ChallengeDao
import com.challenge.codewars.plugin.data.datasource.remote.Service
import io.reactivex.Observable
import javax.inject.Inject

class MemberRepositoryImpl @Inject constructor(
    private val service: Service,
    private val dao: ChallengeDao
) : MemberRepository {

    override fun fetchCompletedChallengesByMember(username: String): Observable<Result<CompletedChallengeDTO>> {
        return service.getCompletedChallengesByMember(username)
            .call()
            .doOnNext { dao.insert(it.getOrThrow().toEntity(username)) }
    }

    override fun fetchAuthoredChallengesByMember(username: String): Observable<Result<AuthoredChallengeDTO>> {
        return service.getAuthoredChallengesByMember(username)
            .call()
            .doOnNext { dao.insert(it.getOrThrow().toEntity(username)) }
    }

    override fun getCompletedChallengesByMember(username: String): Observable<List<ChallengeEntity>> {
        return dao.getChallengesByMemberAndType(username, COMPLETED)
    }

    override fun getAuthoredChallengesByMember(username: String): Observable<List<ChallengeEntity>> {
        return dao.getChallengesByMemberAndType(username, AUTHORED)
    }
}
