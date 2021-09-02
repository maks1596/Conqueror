package com.netology.data

import kotlinx.coroutines.flow.Flow

/**
 * Репозиторий для работы с состоянием королевства
 */
interface KingdomStateRepository {

    /**
     * Количество монет в казне королевства.
     * `null`, если значение количество монет ещё не было задано
     */
    val balanceFlow: Flow<Int?>

    /**
     * Количество людей в королевстве.
     * `null`, если количество людей ещё не было задано
     */
    val populationFlow: Flow<Int?>

    /**
     * Устанавливает количество монет в королевстве равным [balance]
     */
    suspend fun updateBalance(balance: Int)

    /**
     * Устанавливает количество людей в королевстве равным [population]
     */
    suspend fun updatePopulation(population: Int)
}