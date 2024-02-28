package com.example.footballleagueapp.repositry.implementation

import com.example.footballleagueapp.datasource.common.ResultWrapper
import com.example.footballleagueapp.datasource.datasource.contracts.CompetitionDataSource
import com.example.footballleagueapp.datasource.model.CompetitionResponse
import com.example.footballleagueapp.repositry.contract.CompetitionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CompetitionRepositoryImpl @Inject constructor(private val competitionDataSource: CompetitionDataSource) :
    CompetitionRepository {
    override suspend fun getCompetition(): Flow<ResultWrapper<CompetitionResponse>> {
        return competitionDataSource.getCompetitions()
    }
}