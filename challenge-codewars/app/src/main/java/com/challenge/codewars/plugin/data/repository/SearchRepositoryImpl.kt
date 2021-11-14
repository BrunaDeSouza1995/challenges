package com.challenge.codewars.plugin.data.repository

import com.challenge.codewars.feature.base.data.dto.MemberDTO
import com.challenge.codewars.feature.base.data.repository.call
import com.challenge.codewars.feature.search.data.SearchRepository
import com.challenge.codewars.plugin.network.Service
import io.reactivex.Observable
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(private val service: Service) : SearchRepository {

    override fun searchMemberByUsernameOrId(text: String): Observable<Result<MemberDTO>> {
        return service.searchMemberByUsernameOrId(text).call()
    }
}
