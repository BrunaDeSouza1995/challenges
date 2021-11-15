package com.challenge.codewars.feature.search.data

import com.challenge.codewars.feature.search.data.dto.MemberDTO
import com.challenge.codewars.feature.search.data.dto.MemberFakeDTO.member
import com.challenge.codewars.feature.search.data.dto.MemberFakeDTO.member1
import com.challenge.codewars.feature.search.data.entity.MemberEntity
import com.challenge.codewars.feature.search.data.extension.toEntity
import io.reactivex.Observable

class SearchFakeRepository : SearchRepository {

    override fun searchMemberByUsernameOrId(text: String): Observable<Result<MemberDTO>> {
        val result = Result.success(member())
        return Observable.just(result)
    }

    override fun getSearchedMembers(): Observable<Result<List<MemberEntity>>> {
        val list = listOf(member().toEntity(), member1().toEntity())
        val result = Result.success(list)
        return Observable.just(result)
    }
}