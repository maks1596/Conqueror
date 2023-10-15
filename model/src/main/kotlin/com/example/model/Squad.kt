package com.example.model

/**
 * Отряд
 */
data class Squad(

    /**
     * Раса отряда
     */
    val race: Race,

    /**
     * Специализация отряда
     */
    val specialization: Specialization,

    /**
     * Сила отряда, численность
     */
    val strength: Int
) {

    /**
     * Раса отряда
     */
    enum class Race {

        /**
         * Люди
         */
        Human,

        /**
         * Эльфы
         */
        Elf,

        /**
         * Орки
         */
        Orc,

        /**
         * Гномы
         */
        Dwarf
    }

    /**
     * Специализация отряда
     */
    enum class Specialization {

        /**
         * Ближний бой
         */
        Melee,

        /**
         * Дистанционная атака
         */
        Range,

        /**
         * Магия
         */
        Magic
    }
}