package com.challenge.codewars.feature.search.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "member")
data class MemberEntity(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    val name: String,
    val rank: Int,
    val bestLanguage: String,
    val point: Int
)
