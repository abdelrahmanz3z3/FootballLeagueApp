package com.example.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CompetitionsItem(

    val area: Area? = null,

    val lastUpdated: String? = null,

    val code: String? = null,

    val currentSeason: CurrentSeason? = null,

    val name: String? = null,

    val id: Int? = null,

    val numberOfAvailableSeasons: Int? = null,

    val type: String? = null,

    val emblem: String? = null,

    val plan: String? = null
) : Parcelable
