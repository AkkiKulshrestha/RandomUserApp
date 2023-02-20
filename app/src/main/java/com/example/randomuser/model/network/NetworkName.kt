package com.example.randomuser.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkName(
    @SerialName("title") val title: String? = null,
    @SerialName("first") val first: String? = null,
    @SerialName("last") val last: String? = null
)

fun NetworkName.parse(): String = StringBuilder().apply {
    title?.trim()
        ?.let {
            append(it)
            append(" ")
        }

    first?.trim()
        ?.let {
            append(it)
            append(" ")
        }

    last?.trim()
        ?.let { append(it) }
}
    .toString()
    .trim()