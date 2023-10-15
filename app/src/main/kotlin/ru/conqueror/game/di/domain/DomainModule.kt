package ru.conqueror.game.di.domain

import dagger.Module
import dagger.Provides
import ru.conqueror.data.KingdomStateRepository
import ru.conqueror.data.SquadRepository
import ru.conqueror.domain.KingdomInteractor
import ru.conqueror.domain.impl.KingdomInteractorImpl
import ru.conqueror.game.GameSettings

@Module
internal class DomainModule {

    @Provides
    fun provideKingdomInteractor(
        gameSettings: GameSettings,
        squadRepository: SquadRepository,
        kingdomStateRepository: KingdomStateRepository,
    ): KingdomInteractor = KingdomInteractorImpl(
        initialPopulation = gameSettings.initialPopulation,
        kingdomStateRepository = kingdomStateRepository,
        initialBalance = gameSettings.initialBalance,
        squadRepository = squadRepository,
    )
}