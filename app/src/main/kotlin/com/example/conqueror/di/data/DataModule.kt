package com.example.conqueror.di.data

import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import com.example.conqueror.GameSettings
import com.example.conqueror.di.scope.AppScope
import com.netology.data.KingdomStateRepository
import com.netology.data.SquadRepository
import com.netology.data.impl.KingdomStateRepositoryImpl
import com.netology.data.impl.SquadRepositoryImpl
import dagger.Module
import dagger.Provides
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