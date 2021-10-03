package com.example.presentation.impl

import com.example.presentation.MainContract
import com.netology.domain.KingdomInteractor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import kotlin.properties.Delegates

class MainPresenter(
    private val view: MainContract.View,
    private val coroutineScope: CoroutineScope,
    private val kingdomInteractor: KingdomInteractor
) : MainContract.Presenter {

    private var state by Delegates.observable(
        MainContract.State(
            population = 0,
            balance = 0,
            availableSquads = emptyList(),
            nextAvailableSquad = null
        )
    ) { _, _, newValue ->
        view.displayState(newValue)
    }


    override fun onViewCreated() {
        coroutineScope.launch {
            kingdomInteractor.balanceFlow.collect { balance ->
                state = state.copy(balance = balance)
            }
        }
        coroutineScope.launch {
            kingdomInteractor.populationFlow.collect { population ->
                state = state.copy(population = population)
            }
        }
        coroutineScope.launch {
            kingdomInteractor.getAvailableSquadsFlow(
                MAX_DISPLAYED_AVAILABLE_SQUADS_AMOUNT
            ).collect { availableSquads ->
                state = state.copy(availableSquads = availableSquads)
            }
        }
        coroutineScope.launch {
            kingdomInteractor.getNextAvailableSquadFlow().collect { nextSquad ->
                state = state.copy(nextAvailableSquad = nextSquad)
            }
        }
    }

    private companion object {

        private const val MAX_DISPLAYED_AVAILABLE_SQUADS_AMOUNT = 5
    }
}