package com.example.randomuser.model

data class Location(
    val address: String,
    val coordinates: Coordinates? = null,
)