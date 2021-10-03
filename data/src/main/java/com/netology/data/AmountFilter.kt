package com.netology.data

/**
 * Фильтр количества записей
 */
sealed class AmountFilter {

    /**
     * Количества записей, которое необходимо оставить в запросе
     */
    abstract val amount: Int
}

/**
 * Фильтр, который оставляет первые [amount] записей из запроса
 */
class First(
    override val amount: Int = 1
) : AmountFilter()

/**
 * Фильтр, который оставляет последние [amount] записей из запроса
 */
class Last(
    override val amount: Int = 1
) : AmountFilter()


