package com.example.presentation

import com.example.model.Squad

/**
 * Контракт главного экрана приложения
 */
sealed class MainContract {

    interface View {
        fun displayState(state: State)
    }

    interface Presenter {

        fun onViewCreated()
    }

    data class State(
        val population: Int,
        val balance: Int,
        val availableSquads: List<Squad>,
        val unavailableSquads: List<Squad>
    )
}