package ru.conqueror.model

/**
 * Территория для захвата
 */
data class Land(
    /**
     * Название территории
     */
    val name: String,

    /**
     * Вознаграждение за захват территории
     */
    val reward: Int,

    /**
     * Вероятность успешного захвата территории
     */
    val successProbability: Double,

    /**
     * Расстояние до территории
     */
    val distance: Double
)