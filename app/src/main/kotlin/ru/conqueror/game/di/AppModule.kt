package ru.conqueror.game.di

import dagger.Module
import dagger.Provides
import ru.conqueror.game.GameSettings
import ru.conqueror.game.di.scope.AppScope

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