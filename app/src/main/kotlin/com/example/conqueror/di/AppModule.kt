package com.example.conqueror.di

import com.example.conqueror.GameSettings
import com.example.conqueror.di.scope.AppScope
import dagger.Module
import dagger.Provides

@Module
internal class AppModule {

    @Provides
    @AppScope
    fun provideGameSettings() = GameSettings(
        firstSquadStrength = 10,
        initialPopulation = 10,
        initialBalance = 100,
    )
}