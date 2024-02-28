package com.example.data.webservice


import com.example.data.common.Constants
import com.example.data.datasource.model.CompetitionResponse
import retrofit2.http.GET

interface WebService {

    @GET(Constants.competitionEndPoint)
    suspend fun getCompetition(): CompetitionResponse
}