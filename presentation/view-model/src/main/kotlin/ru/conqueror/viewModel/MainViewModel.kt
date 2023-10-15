package ru.conqueror.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.conqueror.domain.KingdomInteractor

class MainViewModel(
    private val kingdomInteractor: KingdomInteractor
) : ViewModel() {

    private val _stateFlow = MutableStateFlow(
        MainState(
            population = 0,
            balance = 0,
            availableSquads = emptyList(),
            nextAvailableSquad = null
        )
    )
    val stateFlow: Flow<MainState> = _stateFlow.asStateFlow()

    init {
        viewModelScope.launch {
            kingdomInteractor.balanceFlow.collect { balance ->
                _stateFlow.value = _stateFlow.value.copy(balance = balance)
            }
        }
        viewModelScope.launch {
            kingdomInteractor.populationFlow.collect { population ->
                _stateFlow.value = _stateFlow.value.copy(population = population)
            }
        }
        viewModelScope.launch {
            kingdomInteractor.getAvailableSquadsFlow(
                MAX_DISPLAYED_AVAILABLE_SQUADS_AMOUNT
            ).collect { availableSquads ->
                _stateFlow.value = _stateFlow.value.copy(availableSquads = availableSquads)
            }
        }
        viewModelScope.launch {
            kingdomInteractor.getNextAvailableSquadFlow().collect { nextSquad ->
                _stateFlow.value = _stateFlow.value.copy(nextAvailableSquad = nextSquad)
            }
        }
    }

    fun onAddPeopleButtonClicked() {
        viewModelScope.launch {
            kingdomInteractor.addPeople()
        }
    }

    private companion object {

        private const val MAX_DISPLAYED_AVAILABLE_SQUADS_AMOUNT = 5
    }
}