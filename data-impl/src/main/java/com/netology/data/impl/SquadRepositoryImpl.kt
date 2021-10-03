package com.netology.data.impl

import com.example.model.Squad
import com.netology.data.AmountFilter
import com.netology.data.SquadRepository

class SquadRepositoryImpl : SquadRepository {

    override fun getSquads(
        amountFilter: AmountFilter?,
        strengthFilter: (strength: Int) -> Boolean
    ): List<Squad> {
        TODO("Not yet implemented")
    }

}