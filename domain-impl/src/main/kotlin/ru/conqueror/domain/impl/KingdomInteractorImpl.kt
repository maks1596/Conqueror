package ru.conqueror.domain.impl

import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import ru.conqueror.data.First
import ru.conqueror.data.KingdomStateRepository
import ru.conqueror.data.Last
import ru.conqueror.data.SquadRepository
import ru.conqueror.domain.KingdomInteractor

class KingdomInteractorImpl(
    initialBalance: Int,
    initialPopulation: Int,
    private val squadRepository: SquadRepository,
    private val kingdomStateRepository: KingdomStateRepository,
) : KingdomInteractor {

    private var currentBalance: Int? = null
    private var currentPopulation: Int? = null

    override val balanceFlow = kingdomStateRepository.balanceFlow
        .map { it ?: initialBalance }
        .onEach { currentBalance = it }

    override val populationFlow = kingdomStateRepository.populationFlow
        .map { it ?: initialPopulation }
        .onEach { currentPopulation = it }

    override fun getAvailableSquadsFlow(amount: Int) = populationFlow.map { population ->
        squadRepository.getSquads(
            amountFilter = Last(amount),
            strengthFilter = { squadStrength -> squadStrength <= population }
        )
    }

    override fun getNextAvailableSquadFlow() = populationFlow.map { population ->
        squadRepository.getSquads(
            amountFilter = First(),
            strengthFilter = { squadStrength -> squadStrength > population }
        ).firstOrNull()
    }

    override suspend fun addPeople() {
        val balance = currentBalance ?: return
        val population = currentPopulation ?: return

        kingdomStateRepository.update(
            balance = 0,
            population = population + balance
        )
    }
}