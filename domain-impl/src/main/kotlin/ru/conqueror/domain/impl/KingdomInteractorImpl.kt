package ru.conqueror.domain.impl

import kotlinx.coroutines.flow.map
import ru.conqueror.data.First
import ru.conqueror.data.KingdomStateRepository
import ru.conqueror.data.Last
import ru.conqueror.data.SquadRepository
import ru.conqueror.domain.KingdomInteractor

class KingdomInteractorImpl(
    initialBalance: Int,
    initialPopulation: Int,
    private val squadRepository: SquadRepository,
    kingdomStateRepository: KingdomStateRepository,
) : KingdomInteractor {

    override val balanceFlow = kingdomStateRepository.balanceFlow.map {
        it ?: initialBalance
    }

    override val populationFlow = kingdomStateRepository.populationFlow.map {
        it ?: initialPopulation
    }

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
}