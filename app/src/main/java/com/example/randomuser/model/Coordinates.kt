package com.example.randomuser.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Coordinates(
    val lat: Long,
    val lon: Long
): Parcelable