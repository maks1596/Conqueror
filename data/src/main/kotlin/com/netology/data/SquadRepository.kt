package com.netology.data

import com.example.model.Squad

/**
 * Репозиторий для работы с отрядами
 */
interface SquadRepository {

    /**
     * Возвращает список отрядов
     *
     * @param amountFilter ограничиваает количество результирующих записей
     * @param strengthFilter фильтрует отряды по полю [Squad.strength]
     */
    fun getSquads(
        amountFilter: AmountFilter? = null,
        strengthFilter: (strength: Int) -> Boolean = { true }
    ): List<Squad>
}