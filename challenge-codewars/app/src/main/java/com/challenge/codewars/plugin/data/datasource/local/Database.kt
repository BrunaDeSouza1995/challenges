package com.challenge.codewars.plugin.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.challenge.codewars.feature.base.data.entity.ChallengeEntity
import com.challenge.codewars.feature.base.data.entity.MemberEntity
import com.challenge.codewars.plugin.data.datasource.local.dao.ChallengeDao
import com.challenge.codewars.plugin.data.datasource.local.dao.ChallengeTypeConverter
import com.challenge.codewars.plugin.data.datasource.local.dao.MemberDao

@TypeConverters(ChallengeTypeConverter::class)
@Database(
    entities = [MemberEntity::class, ChallengeEntity::class],
    version = 2
)
abstract class Database : RoomDatabase() {
    abstract fun memberDao(): MemberDao
    abstract fun challengeDao(): ChallengeDao
}