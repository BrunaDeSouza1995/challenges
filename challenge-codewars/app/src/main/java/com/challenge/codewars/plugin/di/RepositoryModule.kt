package com.challenge.codewars.plugin.di

import com.challenge.codewars.feature.challenge.data.ChallengeRepository
import com.challenge.codewars.feature.member.data.MemberRepository
import com.challenge.codewars.feature.search.data.SearchRepository
import com.challenge.codewars.plugin.repository.ChallengeRepositoryImpl
import com.challenge.codewars.plugin.repository.MemberRepositoryImpl
import com.challenge.codewars.plugin.repository.SearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsSearchRepository(searchRepository: SearchRepositoryImpl): SearchRepository

    @Binds
    abstract fun bindsMemberRepository(memberRepository: MemberRepositoryImpl): MemberRepository

    @Binds
    abstract fun bindsChallengeRepository(challengeRepository: ChallengeRepositoryImpl): ChallengeRepository
}