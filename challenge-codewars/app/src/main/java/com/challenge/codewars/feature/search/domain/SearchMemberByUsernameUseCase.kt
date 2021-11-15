package com.challenge.codewars.feature.search.domain

import com.challenge.codewars.feature.base.domain.BaseUseCase
import com.challenge.codewars.feature.search.data.SearchRepository
import io.reactivex.Observable
import javax.inject.Inject

class SearchMemberByUsernameUseCase @Inject constructor(
    private val repository: SearchRepository
) : BaseUseCase<String, Unit>() {

    override fun execute(input: String?): Observable<Result<Unit>> {
        return repository.searchMemberByUsernameOrId(input!!)
            .map { Result.success(Unit) }
    }
}
