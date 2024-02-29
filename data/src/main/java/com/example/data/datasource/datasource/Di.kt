package com.example.data.datasource.datasource


import com.example.data.datasource.datasource.contracts.CompetitionDataSource
import com.example.data.datasource.datasource.implemention.CompetitionDataSourceImpl
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