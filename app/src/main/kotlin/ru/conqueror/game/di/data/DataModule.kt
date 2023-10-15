package ru.conqueror.game.di.data

import android.app.Application
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.Module
import dagger.Provides
import ru.conqueror.data.KingdomStateRepository
import ru.conqueror.data.SquadRepository
import ru.conqueror.data.impl.KingdomStateRepositoryImpl
import ru.conqueror.data.impl.SquadRepositoryImpl
import ru.conqueror.game.GameSettings
import ru.conqueror.game.di.scope.AppScope

@Module
internal class DataModule {

    @AppScope
    @Provides
    fun provideKingdomStateRepository(
        application: Application
    ): KingdomStateRepository {
        val dataStore = PreferenceDataStoreFactory.create {
            application.preferencesDataStoreFile("state")
        }
        return KingdomStateRepositoryImpl(dataStore)
    }

    @AppScope
    @Provides
    fun provideSquadRepository(
        gameSettings: GameSettings
    ): SquadRepository = SquadRepositoryImpl(
        firstSquadStrength = gameSettings.firstSquadStrength
    )
}