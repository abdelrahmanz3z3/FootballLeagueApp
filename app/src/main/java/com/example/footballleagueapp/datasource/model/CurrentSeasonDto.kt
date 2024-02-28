package com.example.footballleagueapp.datasource.model

import com.example.footballleagueapp.repositry.model.CurrentSeason
import com.google.gson.annotations.SerializedName


data class CurrentSeasonDto(

    @field:SerializedName("winner")
    val winner: WinnerDto? = null,

    @field:SerializedName("currentMatchday")
    val currentMatchday: Int? = null,

    @field:SerializedName("endDate")
    val endDate: String? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("startDate")
    val startDate: String? = null
) {
    fun toCurrentSeason(): CurrentSeason {
        return CurrentSeason(
            winner = winner?.toWinner(),
            currentMatchday = currentMatchday,
            endDate = endDate.toString(),
            startDate = startDate.toString(),
            id = id
        )
    }
}