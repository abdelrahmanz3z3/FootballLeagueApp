package com.example.footballleagueapp.repositry.contract

import com.example.footballleagueapp.datasource.common.ResultWrapper
import com.example.footballleagueapp.repositry.model.CompetitionsItem
import kotlinx.coroutines.flow.Flow

interface CompetitionRepository {
    suspend fun getCompetition(): Flow<ResultWrapper<List<CompetitionsItem?>?>>

}