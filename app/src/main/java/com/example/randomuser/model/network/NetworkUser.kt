package com.example.randomuser.model.network

import com.example.randomuser.model.Contact
import com.example.randomuser.model.Gender
import com.example.randomuser.model.User
import com.example.randomuser.utils.Constants
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NetworkUser(
    @SerialName("id") val _id: NetworkId? = null,
    @SerialName("name") val name: NetworkName? = null,
    @SerialName("dob") val dob: NetworkDate? = null,
    @SerialName("gender") val gender: String? = null,
    @SerialName("picture") val picture: NetworkPicture? = null,
    @SerialName("email") val email: String? = null,
    @SerialName("phone") val phone: String? = null,
    @SerialName("cell") val cell: String? = null,
    @SerialName("registered") val registered: NetworkDate? = null,
    @SerialName("location") val location: NetworkLocation? = null,
    @SerialName("nat") val nat: String? = null
)

fun List<NetworkUser?>.parse(): List<User> = mapNotNull { it?.parse() }

fun NetworkUser.parse(): User {
    return User(
        name = name?.parse()
            ?.takeIf { it.isNotEmpty() }
            ?: Constants.NOT_AVAILABLE,
        dob = dob?.parse(),
        gender = when {
            Gender.FEMALE.value.equals(gender, true) -> Gender.FEMALE
            Gender.MALE.value.equals(gender, true) -> Gender.MALE
            else -> Gender.ANY
        },
        picture = picture?.parse(),
        contact = Contact(
            email = email,
            phone = phone,
            cell = cell
        ),
        registered = registered?.parse(),
        location = location?.parse(),
        nat = nat
    )
}