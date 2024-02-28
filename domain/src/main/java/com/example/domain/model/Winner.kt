package com.example.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Winner(


    val venue: String? = null,

    val lastUpdated: String? = null,

    val website: String? = null,

    val address: String? = null,

    val clubColors: String? = null,

    val name: String? = null,

    val tla: String? = null,

    val founded: Int? = null,

    val id: Int? = null,

    val shortName: String? = null,

    val crest: String? = null
) : Parcelable