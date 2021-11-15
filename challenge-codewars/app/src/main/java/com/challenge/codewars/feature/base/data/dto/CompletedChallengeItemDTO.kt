package com.challenge.codewars.feature.base.data.dto

data class CompletedChallengeItemDTO(
    val completedAt: String,
    val completedLanguages: List<String>,
    val id: String,
    val name: String,
    val slug: String
)
