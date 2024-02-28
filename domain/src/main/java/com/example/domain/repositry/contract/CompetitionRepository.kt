package com.example.domain.repositry.contract

import com.example.domain.common.ResultWrapper
import com.example.domain.model.CompetitionsItem
import kotlinx.coroutines.flow.Flow

interface CompetitionRepository {
    suspend fun getCompetition(): Flow<ResultWrapper<List<CompetitionsItem?>?>>

}