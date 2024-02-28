package com.example.footballleagueapp.datasource.datasource.implemention

import com.example.footballleagueapp.datasource.common.ResultWrapper
import com.example.footballleagueapp.datasource.common.safeApiCall
import com.example.footballleagueapp.datasource.datasource.contracts.CompetitionDataSource
import com.example.footballleagueapp.datasource.webservice.WebService
import com.example.footballleagueapp.repositry.model.CompetitionsItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CompetitionDataSourceImpl @Inject constructor(private val webService: WebService) :
    CompetitionDataSource {
    override suspend fun getCompetitions(): Flow<ResultWrapper<List<CompetitionsItem?>?>> {
        return safeApiCall {
            webService.getCompetition().competitions?.map {
                it?.toCompetitionItem()
            }
        }
    }

}