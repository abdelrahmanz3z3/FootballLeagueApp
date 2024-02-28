package com.example.data.datasource.datasource.contracts

import com.example.domain.common.ResultWrapper
import com.example.domain.model.CompetitionsItem
import kotlinx.coroutines.flow.Flow

interface CompetitionDataSource {
    suspend fun getCompetitions(): Flow<ResultWrapper<List<CompetitionsItem?>?>>
}