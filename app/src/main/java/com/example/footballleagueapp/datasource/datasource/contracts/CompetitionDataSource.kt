package com.example.footballleagueapp.datasource.datasource.contracts

import com.example.footballleagueapp.datasource.common.ResultWrapper
import com.example.footballleagueapp.datasource.model.CompetitionResponse
import kotlinx.coroutines.flow.Flow

interface CompetitionDataSource {
    suspend fun getCompetitions(): Flow<ResultWrapper<CompetitionResponse>>
}