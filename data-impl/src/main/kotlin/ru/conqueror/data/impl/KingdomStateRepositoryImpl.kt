package ru.conqueror.data.impl

import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import kotlinx.coroutines.flow.map
import ru.conqueror.data.KingdomStateRepository

class KingdomStateRepositoryImpl(
    private val dataStore: DataStore<Preferences>
) : KingdomStateRepository {

    override val balanceFlow = dataStore.data.map { it[BALANCE_KEY] }
    override val populationFlow = dataStore.data.map { it[POPULATION_KEY] }

    override suspend fun updateBalance(balance: Int) {
        dataStore.edit { it[BALANCE_KEY] = balance }
    }

    override suspend fun updatePopulation(population: Int) {
        dataStore.edit { it[POPULATION_KEY] = population }
    }

    override suspend fun update(balance: Int, population: Int) {
        dataStore.edit {
            it[BALANCE_KEY] = balance
            it[POPULATION_KEY] = population
        }
    }

    private companion object {
        private val BALANCE_KEY = intPreferencesKey("balance")
        private val POPULATION_KEY = intPreferencesKey("population")
    }
}