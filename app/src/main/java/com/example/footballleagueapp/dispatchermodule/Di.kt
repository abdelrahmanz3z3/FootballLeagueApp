package com.example.footballleagueapp.dispatchermodule

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
@InstallIn(SingletonComponent::class)
class Di {
    @Provides
    fun provideIODispatcher(): CoroutineDispatcher = Dispatchers.IO
}