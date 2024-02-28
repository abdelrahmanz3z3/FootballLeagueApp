package com.example.footballleagueapp.datasource.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Filters(
    val any: @RawValue Any? = null
) : Parcelable