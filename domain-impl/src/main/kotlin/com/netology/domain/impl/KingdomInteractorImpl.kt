package com.netology.domain.impl

import com.netology.data.First
import com.netology.data.KingdomStateRepository
import com.netology.data.Last
import com.netology.data.SquadRepository
import com.netology.domain.KingdomInteractor
import kotlinx.coroutines.flow.map

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