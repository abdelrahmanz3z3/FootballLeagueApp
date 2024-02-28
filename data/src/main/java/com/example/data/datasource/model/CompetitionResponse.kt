package com.example.data.datasource.model

import com.google.gson.annotations.SerializedName

data class CompetitionResponse(

    @field:SerializedName("count")
    val count: Int? = null,

    @field:SerializedName("competitions")
    val competitions: List<CompetitionsItemDto?>? = null,

    @field:SerializedName("filters")
    val filters: FiltersDto? = null
)