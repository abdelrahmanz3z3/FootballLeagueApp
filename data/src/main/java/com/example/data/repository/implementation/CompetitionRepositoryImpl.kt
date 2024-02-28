package com.example.data.repository.implementation

import com.example.data.datasource.datasource.contracts.CompetitionDataSource
import com.example.domain.common.ResultWrapper
import com.example.domain.model.CompetitionsItem
import com.example.domain.repositry.contract.CompetitionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CompetitionRepositoryImpl @Inject constructor(private val competitionDataSource: CompetitionDataSource) :
    CompetitionRepository {
    override suspend fun getCompetition(): Flow<ResultWrapper<List<CompetitionsItem?>?>> {
        return competitionDataSource.getCompetitions()
    }
}