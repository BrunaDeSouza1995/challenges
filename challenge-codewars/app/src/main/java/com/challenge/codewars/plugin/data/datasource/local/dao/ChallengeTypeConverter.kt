package com.challenge.codewars.plugin.data.datasource.local.dao

import androidx.room.TypeConverter
import com.challenge.codewars.feature.base.data.entity.ChallengeEntity.ChallengeType

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