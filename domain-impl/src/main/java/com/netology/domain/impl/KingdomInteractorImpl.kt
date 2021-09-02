package com.netology.domain.impl

import com.netology.data.KingdomStateRepository
import com.netology.domain.KingdomInteractor
import kotlinx.coroutines.flow.map

class KingdomInteractorImpl(
    kingdomStateRepository: KingdomStateRepository
) : KingdomInteractor {

    override val balanceFlow = kingdomStateRepository.balanceFlow.map {
        it ?: INITIAL_BALANCE
    }

    override val populationFlow = kingdomStateRepository.populationFlow.map {
        it ?: INITIAL_POPULATION
    }

    private companion object {
        private const val INITIAL_BALANCE = 100
        private const val INITIAL_POPULATION = 10
    }
}