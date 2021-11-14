package com.challenge.codewars.feature.search.domain

import com.challenge.codewars.feature.base.data.dto.MemberDTO
import com.challenge.codewars.feature.base.domain.BaseUseCase
import com.challenge.codewars.feature.search.data.SearchRepository
import io.reactivex.Observable
import javax.inject.Inject

class SearchUseCase @Inject constructor(
    private val repository: SearchRepository
) : BaseUseCase<String, MemberDTO>() {

    override fun execute(input: String?): Observable<Result<MemberDTO>> {
        return repository.searchMemberByUsernameOrId(input!!)
    }
}
