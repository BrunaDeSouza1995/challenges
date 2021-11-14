package com.challenge.codewars.plugin.data.datasource.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.challenge.codewars.feature.base.data.entity.MemberEntity
import com.challenge.codewars.plugin.data.datasource.local.dao.MemberDao

@Database(
    entities = [MemberEntity::class],
    version = 1
)
abstract class Database : RoomDatabase() {
    abstract fun memberDao(): MemberDao
}