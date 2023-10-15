package com.example.conqueror


/**
 * Настройки игры
 */
internal class GameSettings(

    /**
     * Сила первого отряда
     *
     * @see com.example.model.Squad.strength
     */
    val firstSquadStrength: Int,

    /**
     * Стартовое количество монет в казне
     */
    val initialBalance: Int,

    /**
     * Стартовое количество людей в королевстве
     */
    val initialPopulation: Int
)