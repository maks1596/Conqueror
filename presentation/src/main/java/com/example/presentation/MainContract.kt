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

    /**
     * Состояние главного экрана приложения
     */
    data class State(

        /**
         * Количество людей в королевстве
         */
        val population: Int,

        /**
         * Количество монет в казне королевства
         */
        val balance: Int,

        /**
         * Список доступных отрядов
         */
        val availableSquads: List<Squad>,

        /**
         * Следующий доступный отряд
         */
        val nextAvailableSquad: Squad?
    )
}