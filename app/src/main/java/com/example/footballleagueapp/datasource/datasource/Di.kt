package com.example.footballleagueapp.datasource.datasource

import com.example.footballleagueapp.datasource.datasource.contracts.CompetitionDataSource
import com.example.footballleagueapp.datasource.datasource.implemention.CompetitionDataSourceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class Di {
    @Binds
    abstract fun bindCompetitionDataSource(competitionDataSourceImpl: CompetitionDataSourceImpl): CompetitionDataSource

}