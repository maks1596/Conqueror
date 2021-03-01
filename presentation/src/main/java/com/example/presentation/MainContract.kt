package com.example.presentation

import com.example.model.Squad

/**
 * Контракт главного экрана приложения
 */
sealed class MainContract {

    interface View {
        fun displayPopulation(population: Int)

        fun displayBalance(balance: Int)

        fun displaySquads(
            availableSquads: List<Squad>,
            unavailableSquads: List<Squad>
        )
    }

    interface Presenter {

        fun onViewCreated()
    }
}