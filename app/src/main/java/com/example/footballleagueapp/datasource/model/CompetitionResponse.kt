package com.example.footballleagueapp.datasource.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CompetitionResponse(

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("competitions")
    val competitions: List<CompetitionsItem?>? = null,

    @field:SerializedName("filters")
    val filters: Filters? = null
) : Parcelable