package com.netology.data

import com.example.model.Squad

/**
 * Репозиторий для работы с отрядами
 */
interface SquadRepository {

    /**
     * Возвращает список отрядов
     */
    fun getSquads(): List<Squad>
}