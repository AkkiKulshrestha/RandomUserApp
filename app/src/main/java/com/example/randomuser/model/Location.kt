package com.example.randomuser.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Location(
    val address: String,
    val coordinates: Coordinates? = null,
): Parcelable