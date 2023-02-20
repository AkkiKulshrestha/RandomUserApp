package com.example.randomuser.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkResponse(
    @SerialName("results") val results: List<NetworkUser?>? = null
)