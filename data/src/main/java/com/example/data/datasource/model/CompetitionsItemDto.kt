package com.example.data.datasource.model

import com.example.domain.model.CompetitionsItem
import com.google.gson.annotations.SerializedName

data class CompetitionsItemDto(

    @field:SerializedName("area")
    val area: AreaDto? = null,

    @field:SerializedName("lastUpdated")
    val lastUpdated: String? = null,

    @field:SerializedName("code")
    val code: String? = null,

    @field:SerializedName("currentSeason")
    val currentSeason: CurrentSeasonDto? = null,

    @field:SerializedName("name")
    val name: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("numberOfAvailableSeasons")
    val numberOfAvailableSeasons: Int? = null,

    @field:SerializedName("type")
    val type: String? = null,

    @field:SerializedName("emblem")
    val emblem: Any? = null,

    @field:SerializedName("plan")
    val plan: String? = null
) {
    fun toCompetitionItem(): CompetitionsItem {
        return CompetitionsItem(
            area = area?.toArea(),
            lastUpdated = lastUpdated,
            code = code,
            currentSeason = currentSeason?.toCurrentSeason(),
            name = name,
            id = id,
            numberOfAvailableSeasons = numberOfAvailableSeasons,
            type = type,
            emblem = emblem.toString()
        )
    }
}