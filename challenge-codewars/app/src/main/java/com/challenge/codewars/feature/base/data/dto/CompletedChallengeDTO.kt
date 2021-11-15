package com.challenge.codewars.feature.base.data.dto

data class CompletedChallengeDTO(
    val `data`: List<CompletedChallengeItemDTO>,
    val totalItems: Int,
    val totalPages: Int
)
