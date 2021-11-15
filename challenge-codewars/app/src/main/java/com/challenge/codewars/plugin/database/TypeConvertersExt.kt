package com.challenge.codewars.plugin.database

import com.google.gson.Gson

fun <T> String?.convertStringToType(clazz: Class<T>?): T {
    return Gson().fromJson(this, clazz)
}

fun Any?.convertTypeToString(): String {
    return Gson().toJson(this)
}