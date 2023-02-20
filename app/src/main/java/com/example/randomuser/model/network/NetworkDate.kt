package com.example.randomuser.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkDate(
    @SerialName("date") val date: String? = null,
    @SerialName("age") val age: Byte? = null
)

fun NetworkDate.parse(): String? = date?.trim()