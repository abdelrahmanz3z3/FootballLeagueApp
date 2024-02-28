package com.example.data.datasource.datasource.implemention

import com.example.data.common.safeApiCall
import com.example.data.datasource.datasource.contracts.CompetitionDataSource
import com.example.data.webservice.WebService
import com.example.domain.common.ResultWrapper
import com.example.domain.model.CompetitionsItem
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