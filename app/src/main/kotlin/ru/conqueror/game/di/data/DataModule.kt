package ru.conqueror.game.di.data

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import dagger.Module
import dagger.Provides
import ru.conqueror.data.KingdomStateRepository
import ru.conqueror.data.SquadRepository
import ru.conqueror.data.impl.KingdomStateRepositoryImpl
import ru.conqueror.data.impl.SquadRepositoryImpl
import ru.conqueror.game.GameSettings
import ru.conqueror.game.di.scope.AppScope
import java.io.File

@Module
internal class DataModule {

    @AppScope
    @Provides
    fun provideKingdomStateRepository(): KingdomStateRepository {
        val dataStore = PreferenceDataStoreFactory.create {
            File("state.preferences_pb")
        }
        return KingdomStateRepositoryImpl(dataStore)
    }

    @AppScope
    @Provides
    fun provideSquadRepository(
        gameSettings: GameSettings
    ) : SquadRepository = SquadRepositoryImpl(
        firstSquadStrength = gameSettings.firstSquadStrength
    )
}