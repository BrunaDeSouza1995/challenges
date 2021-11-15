package com.challenge.codewars.plugin.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.challenge.codewars.feature.base.data.entity.ChallengeEntity
import com.challenge.codewars.feature.base.data.entity.ChallengeEntity.ChallengeType
import io.reactivex.Observable

@Dao
interface ChallengeDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(challengeEntity: List<ChallengeEntity>)

    @Query("SELECT * FROM challenge WHERE username = :username AND type = :type")
    fun getChallengesByMemberAndType(username: String, type: ChallengeType) : Observable<List<ChallengeEntity>>
}