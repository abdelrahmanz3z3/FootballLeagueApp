package com.example.footballleagueapp.datasource.datasource.implemention

import com.example.footballleagueapp.datasource.common.ResultWrapper
import com.example.footballleagueapp.datasource.common.safeApiCall
import com.example.footballleagueapp.datasource.datasource.contracts.CompetitionDataSource
import com.example.footballleagueapp.datasource.model.CompetitionResponse
import com.example.footballleagueapp.datasource.webservice.WebService
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CompetitionDataSourceImpl @Inject constructor(private val webService: WebService) :
    CompetitionDataSource {
    override suspend fun getCompetitions(): Flow<ResultWrapper<CompetitionResponse>> {
        return safeApiCall {
            webService.getCompetition()
        }
    }

}