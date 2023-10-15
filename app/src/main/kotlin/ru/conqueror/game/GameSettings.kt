package ru.conqueror.game


/**
 * Настройки игры
 */
internal class GameSettings(

    /**
     * Сила первого отряда
     *
     * @see ru.conqueror.model.Squad.strength
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