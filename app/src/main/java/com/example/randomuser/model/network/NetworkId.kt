package com.example.randomuser.model.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkId(
    @SerialName("name") val name: String? = null,
    @SerialName("value") val value: String? = null
)

fun NetworkId.parse(): String? {
    val safeName = name?.trim()
    val safeValue = value?.trim()
        ?.replace(" ", "_")

    if (safeName.isNullOrEmpty() && safeValue.isNullOrEmpty()) return null

    return StringBuilder()
        .append(safeName)
        .append("_")
        .append(safeValue)
        .toString()
        .trim()
}