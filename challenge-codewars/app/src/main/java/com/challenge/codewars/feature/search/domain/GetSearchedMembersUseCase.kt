package com.challenge.codewars.feature.search.domain

import com.challenge.codewars.feature.search.data.entity.MemberEntity
import com.challenge.codewars.feature.base.domain.BaseUseCase
import com.challenge.codewars.feature.search.data.SearchRepository
import io.reactivex.Observable
import javax.inject.Inject

class GetSearchedMembersUseCase @Inject constructor(
    private val repository: SearchRepository
) : BaseUseCase<Nothing, List<MemberEntity>>() {

    override fun execute(input: Nothing?): Observable<Result<List<MemberEntity>>> {
        return repository.getSearchedMembers()
    }
}