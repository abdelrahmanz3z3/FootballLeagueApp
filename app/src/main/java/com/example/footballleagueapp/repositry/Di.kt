package com.example.footballleagueapp.repositry

import com.example.footballleagueapp.repositry.contract.CompetitionRepository
import com.example.footballleagueapp.repositry.implementation.CompetitionRepositoryImpl
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