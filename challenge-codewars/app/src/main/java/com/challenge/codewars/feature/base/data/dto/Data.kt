package com.challenge.codewars.feature.base.data.dto

data class Data(
    val description: String,
    val id: String,
    val languages: List<String>,
    val name: String,
    val rank: Int,
    val rankName: String,
    val tags: List<String>
)