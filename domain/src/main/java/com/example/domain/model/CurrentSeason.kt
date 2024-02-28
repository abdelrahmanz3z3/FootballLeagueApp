package com.example.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrentSeason(

    val winner: Winner? = null,

    val currentMatchday: Int? = null,

    val endDate: String? = null,

    val id: Int? = null,

    val startDate: String? = null
) : Parcelable