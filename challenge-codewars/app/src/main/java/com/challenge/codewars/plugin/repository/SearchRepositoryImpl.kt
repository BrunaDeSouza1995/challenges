package com.challenge.codewars.plugin.repository

import com.challenge.codewars.feature.search.data.dto.MemberDTO
import com.challenge.codewars.feature.search.data.extension.toEntity
import com.challenge.codewars.feature.search.data.entity.MemberEntity
import com.challenge.codewars.feature.base.data.repository.call
import com.challenge.codewars.feature.search.data.SearchRepository
import com.challenge.codewars.plugin.database.dao.MemberDao
import com.challenge.codewars.plugin.network.CodewarsService
import io.reactivex.Observable
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val service: CodewarsService,
    private val memberDao: MemberDao
) : SearchRepository {

    override fun searchMemberByUsernameOrId(text: String): Observable<Result<MemberDTO>> {
        return service.searchMemberByUsernameOrId(text)
            .call()
            .doOnNext { memberDao.insertMember(it.getOrThrow().toEntity()) }
    }

    override fun getSearchedMembers(): Observable<Result<List<MemberEntity>>> {
        return memberDao.getMembers()
            .map(Result.Companion::success)
    }
}
