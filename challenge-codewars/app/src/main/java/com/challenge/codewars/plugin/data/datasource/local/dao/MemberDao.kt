package com.challenge.codewars.plugin.data.datasource.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.challenge.codewars.feature.base.data.entity.MemberEntity

@Dao
interface MemberDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(memberEntity: MemberEntity)
}