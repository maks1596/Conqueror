package ru.conqueror.viewModel

import ru.conqueror.model.Squad

/**
 * Состояние главного экрана приложения
 */
data class MainState(

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