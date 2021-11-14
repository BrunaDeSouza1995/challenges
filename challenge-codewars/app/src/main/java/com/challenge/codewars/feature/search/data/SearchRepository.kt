package com.challenge.codewars.feature.search.data

import com.challenge.codewars.feature.base.data.dto.MemberDTO
import io.reactivex.Observable

interface SearchRepository {

    fun searchMemberByUsernameOrId(text: String): Observable<Result<MemberDTO>>
}