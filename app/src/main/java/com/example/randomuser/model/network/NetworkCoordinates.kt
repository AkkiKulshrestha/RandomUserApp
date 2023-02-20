package com.example.randomuser.model.network

import com.example.randomuser.model.Coordinates
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkCoordinates(
    @SerialName("latitude") val lat: String? = null,
    @SerialName("longitude") val lon: String? = null
)

fun NetworkCoordinates.parse(): Coordinates? {
    val safeLat = lat?.toLongOrNull()
    val safeLon = lon?.toLongOrNull()
    if (safeLat == null || safeLon == null) return null

    return Coordinates(
        lat = safeLat,
        lon = safeLon
    )
}