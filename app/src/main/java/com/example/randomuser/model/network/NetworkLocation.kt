package com.example.randomuser.model.network

import com.example.randomuser.model.Location
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkLocation(
    @SerialName("street") val street: NetworkStreet? = null,
    @SerialName("city") val city: String? = null,
    @SerialName("state") val state: String? = null,
    @SerialName("country") val country: String? = null,
    @SerialName("coordinates") val coordinates: NetworkCoordinates? = null,
)

fun NetworkLocation.parse(): Location = Location(
    address = StringBuilder().apply {
        street?.parse()
            ?.let {
                append(it)
                append(", ")
            }

        city?.trim()
            ?.let {
                append(it)
                append(", ")
            }

        state?.trim()
            ?.let {
                append(it)
                append(", ")
            }

        country?.trim()
            ?.let {
                append(it)
            }
    }
        .toString()
        .removeSuffix(", ")
        .trim(),
    coordinates = coordinates?.parse()
)