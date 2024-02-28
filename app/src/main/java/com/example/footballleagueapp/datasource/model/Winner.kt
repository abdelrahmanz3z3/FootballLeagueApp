package com.example.footballleagueapp.datasource.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class Winner(

    @field:SerializedName("venue")
    val venue: String? = null,

    @field:SerializedName("lastUpdated")
    val lastUpdated: String? = null,

    @field:SerializedName("website")
    val website: String? = null,

    @field:SerializedName("address")
    val address: String? = null,

    @field:SerializedName("clubColors")
    val clubColors: String? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("tla")
    val tla: String? = null,

    @field:SerializedName("founded")
    val founded: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("shortName")
    val shortName: String? = null,

    @field:SerializedName("crest")
    val crest: String? = null
) : Parcelable