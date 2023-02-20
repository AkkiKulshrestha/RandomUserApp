package com.example.randomuser.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Picture(
    val large: String? = null,
    val medium: String? = null,
    val thumbnail: String? = null
): Parcelable