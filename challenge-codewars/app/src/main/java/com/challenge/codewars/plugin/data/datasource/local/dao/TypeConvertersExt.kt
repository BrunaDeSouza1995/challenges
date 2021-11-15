package com.challenge.codewars.plugin.data.datasource.local.dao

import com.google.gson.Gson

fun <T> String?.convertStringToType(clazz: Class<T>?): T {
    return Gson().fromJson(this, clazz)
}

fun Any?.convertTypeToString(): String {
    return Gson().toJson(this)
}