package com.example.footballleagueapp.datasource.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class CurrentSeason(

    @field:SerializedName("winner")
    val winner: @RawValue Any? = null,

    @field:SerializedName("currentMatchday")
    val currentMatchday: Int? = null,

    @field:SerializedName("endDate")
    val endDate: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("startDate")
    val startDate: String? = null
) : Parcelable