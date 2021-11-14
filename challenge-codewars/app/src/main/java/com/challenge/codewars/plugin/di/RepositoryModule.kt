package com.challenge.codewars.plugin.di

import com.challenge.codewars.feature.search.data.SearchRepository
import com.challenge.codewars.plugin.data.repository.SearchRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsSearchRepository(searchRepository: SearchRepositoryImpl): SearchRepository
}