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
            unavailableSquads = emptyList()
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
    }
}