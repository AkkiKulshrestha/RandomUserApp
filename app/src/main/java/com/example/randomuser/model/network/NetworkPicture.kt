package com.example.randomuser.model.network

import com.example.randomuser.model.Picture
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkPicture(
    @SerialName("large") val large: String? = null,
    @SerialName("medium") val medium: String? = null,
    @SerialName("thumbnail") val thumbnail: String? = null
)

fun NetworkPicture.parse(): Picture = Picture(
    large = large,
    medium = medium,
    thumbnail = thumbnail
)