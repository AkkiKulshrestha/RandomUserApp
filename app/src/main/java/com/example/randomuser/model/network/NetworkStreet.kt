package com.example.randomuser.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkStreet(
    @SerialName("number") val number: Int? = null,
    @SerialName("name") val name: String? = null
)

fun NetworkStreet.parse(): String = StringBuilder().apply {
    number?.let {
            append(it)
            append(", ")
        }

    name?.trim()
        ?.let { append(it) }
}
    .toString()
    .removeSuffix(", ")
    .trim()