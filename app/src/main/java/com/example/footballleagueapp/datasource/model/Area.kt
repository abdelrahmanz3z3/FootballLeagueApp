package com.example.footballleagueapp.datasource.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize
import kotlinx.parcelize.RawValue

@Parcelize
data class Area(

    @field:SerializedName("code")
    val code: String? = null,

    @field:SerializedName("flag")
    val flag: @RawValue Any? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null
) : Parcelable