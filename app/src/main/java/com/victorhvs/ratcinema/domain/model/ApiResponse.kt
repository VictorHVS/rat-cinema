package com.victorhvs.ratcinema.domain.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiResponse<T>(
    @SerialName("page") val page: Int,
    @SerialName("total_pages") val totalPages: Int? = 0,
    @SerialName("total_results") val totalResults: Int? = 0,
    @SerialName("results") val results: List<T> = emptyList(),
)
