package com.example.footballleagueapp.datasource.datasource.contracts

import com.example.footballleagueapp.datasource.common.ResultWrapper
import com.example.footballleagueapp.repositry.model.CompetitionsItem
import kotlinx.coroutines.flow.Flow

interface CompetitionDataSource {
    suspend fun getCompetitions(): Flow<ResultWrapper<List<CompetitionsItem?>?>>
}