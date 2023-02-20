package com.example.randomuser.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(
    val email: String?,
    val phone: String?,
    val cell: String?
) : Parcelable