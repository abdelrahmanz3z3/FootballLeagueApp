package com.example.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Area(

    val code: String? = null,

    val flag: String? = null,

    val name: String? = null,

    val id: Int? = null
) : Parcelable