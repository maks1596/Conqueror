package com.netology.domain

import com.example.model.Squad
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

    /**
     * Возвращает список доступных для королевства отрядов в количестве [amount]
     */
    fun getAvailableSquadsFlow(amount: Int): Flow<List<Squad>>

    /**
     * Возвращает следующий доступный для королевства отряд.
     * `null` в случае, если больше не осталось неоткрытых отрядов
     */
    fun getNextAvailableSquadFlow(): Flow<Squad?>
}