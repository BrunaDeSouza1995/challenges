package com.challenge.codewars.plugin.database

import androidx.room.TypeConverter
import com.challenge.codewars.feature.member.data.entity.ChallengeEntity.ChallengeType

object ChallengeTypeConverter {

    @JvmStatic
    @TypeConverter
    fun stringToChallengeType(data: String?): ChallengeType {
        return data.convertStringToType(ChallengeType::class.java)
    }

    @JvmStatic
    @TypeConverter
    fun challengeTypeToString(data: ChallengeType?): String {
        return data.convertTypeToString()
    }

}