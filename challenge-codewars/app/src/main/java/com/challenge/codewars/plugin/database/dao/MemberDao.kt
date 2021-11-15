package com.challenge.codewars.plugin.database.dao

import androidx.room.*
import com.challenge.codewars.feature.search.data.entity.MemberEntity
import io.reactivex.Observable

private const val LIMIT = 5

@Dao
interface MemberDao {

    @Transaction
    fun insertMember(memberEntity: MemberEntity) {
        if (getCountMember() >= LIMIT) {
            val firstMember = getFirstMember()
            deleteByMemberId(firstMember)
        }
        insert(memberEntity)
    }

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(memberEntity: MemberEntity)

    @Query("SELECT * FROM member")
    fun getMembers(): Observable<List<MemberEntity>>

    @Query("SELECT COUNT(*) FROM member")
    fun getCountMember(): Int

    @Query("SELECT MIN(id) FROM member")
    fun getFirstMember(): Int

    @Query("DELETE FROM member WHERE id = :id")
    fun deleteByMemberId(id: Int)
}