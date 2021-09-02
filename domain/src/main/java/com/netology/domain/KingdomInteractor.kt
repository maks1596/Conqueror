package com.netology.domain

import kotlinx.coroutines.flow.Flow

/**
 * Интерактор для взаимодействия с королевством
 */
interface KingdomInteractor {

    /**
     * Количество монет в казне королевства
     */
    val balanceFlow: Flow<Int>

    /**
     * Количество людей в королевстве
     */
    val populationFlow: Flow<Int>
}