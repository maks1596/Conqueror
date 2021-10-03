package com.netology.domain.impl

import com.netology.data.KingdomStateRepository
import com.netology.domain.KingdomInteractor
import kotlinx.coroutines.flow.map

class KingdomInteractorImpl(
    initialBalance: Int,
    initialPopulation: Int,
    kingdomStateRepository: KingdomStateRepository,
) : KingdomInteractor {

    override val balanceFlow = kingdomStateRepository.balanceFlow.map {
        it ?: initialBalance
    }

    override val populationFlow = kingdomStateRepository.populationFlow.map {
        it ?: initialPopulation
    }
}