package com.challenge.codewars.plugin.di

import android.content.Context
import androidx.room.Room
import com.challenge.codewars.plugin.database.Database
import com.challenge.codewars.plugin.database.dao.ChallengeDao
import com.challenge.codewars.plugin.database.dao.MemberDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

private const val DATABASE_NAME = "codewars.db"

@InstallIn(SingletonComponent::class)
@Module
class DatabaseModule {

    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): Database {
        return Room.databaseBuilder(context, Database::class.java, DATABASE_NAME)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    fun providesMemberDao(database: Database): MemberDao {
        return database.memberDao()
    }

    @Provides
    fun providesChallengeDao(database: Database): ChallengeDao {
        return database.challengeDao()
    }
}