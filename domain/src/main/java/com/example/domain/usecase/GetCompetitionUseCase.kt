package com.example.domain.usecase

import com.example.domain.common.ResultWrapper
import com.example.domain.model.CompetitionsItem
import com.example.domain.repositry.contract.CompetitionRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetCompetitionUseCase @Inject constructor(private val competitionRepository: CompetitionRepository) {

    suspend fun invoke(): Flow<ResultWrapper<List<CompetitionsItem?>?>> {
        return competitionRepository.getCompetition()
    }
}