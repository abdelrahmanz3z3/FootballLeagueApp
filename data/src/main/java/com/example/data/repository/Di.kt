package com.example.data.repository

import com.example.data.repository.implementation.CompetitionRepositoryImpl
import com.example.domain.repositry.contract.CompetitionRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class Di {
    @Binds
    abstract fun bindCompetitionRepository(competitionRepositoryImpl: CompetitionRepositoryImpl): CompetitionRepository

}