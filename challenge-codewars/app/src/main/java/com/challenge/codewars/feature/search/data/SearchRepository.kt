package com.challenge.codewars.feature.search.data

import com.challenge.codewars.feature.base.data.dto.MemberDTO
import com.challenge.codewars.feature.base.data.entity.MemberEntity
import io.reactivex.Observable

interface SearchRepository {

    fun searchMemberByUsernameOrId(text: String): Observable<Result<MemberDTO>>
    fun getSearchedMembers(): Observable<Result<List<MemberEntity>>>
}