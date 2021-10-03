package com.example.conqueror.di.domain

import com.example.conqueror.GameSettings
import com.netology.data.KingdomStateRepository
import com.netology.domain.KingdomInteractor
import com.netology.domain.impl.KingdomInteractorImpl
import dagger.Module
import dagger.Provides

@Module
internal class DomainModule {

    @Provides
    fun provideKingdomInteractor(
        gameSettings: GameSettings,
        kingdomStateRepository: KingdomStateRepository,
    ): KingdomInteractor = KingdomInteractorImpl(
        initialBalance = gameSettings.initialBalance,
        kingdomStateRepository = kingdomStateRepository,
        initialPopulation = gameSettings.initialPopulation,
    )
}