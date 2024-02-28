package com.example.footballleagueapp.datasource.webservice


import com.example.footballleagueapp.common.Constants
import com.example.footballleagueapp.datasource.model.CompetitionResponse
import retrofit2.http.GET

interface WebService {

    @GET(Constants.competitionEndPoint)
    suspend fun getCompetition(): CompetitionResponse
}