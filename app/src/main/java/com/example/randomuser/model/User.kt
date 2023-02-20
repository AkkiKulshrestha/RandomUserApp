package com.example.randomuser.model

data class User(
    val name: String,
    val dob: String?,
    val gender: Gender,
    val picture: Picture?,
    val contact: Contact,
    val registered: String?,
    val location: Location?,
    val nat: String?
)