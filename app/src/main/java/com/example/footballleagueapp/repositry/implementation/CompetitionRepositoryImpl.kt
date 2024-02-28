package com.example.footballleagueapp.repositry.implementation

import com.example.footballleagueapp.datasource.common.ResultWrapper
import com.example.footballleagueapp.datasource.datasource.contracts.CompetitionDataSource
import com.example.footballleagueapp.repositry.contract.CompetitionRepository
import com.example.footballleagueapp.repositry.model.CompetitionsItem
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CompetitionRepositoryImpl @Inject constructor(private val competitionDataSource: CompetitionDataSource) :
    CompetitionRepository {
    override suspend fun getCompetition(): Flow<ResultWrapper<List<CompetitionsItem?>?>> {
        return competitionDataSource.getCompetitions()
    }
}