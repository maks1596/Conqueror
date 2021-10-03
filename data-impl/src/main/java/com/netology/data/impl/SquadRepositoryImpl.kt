package com.netology.data.impl

import com.example.model.Squad
import com.netology.data.AmountFilter
import com.netology.data.SquadRepository

class SquadRepositoryImpl(
    firstSquadStrength: Int
) : SquadRepository {

    private val squads = generateSequence(
        seed = Squad(
            race = Squad.Race.Human,
            specialization = Squad.Specialization.Melee,
            strength = firstSquadStrength
        )
    ) { prevSquad ->
        val nextRace = Squad.Race.values().getOrNull(prevSquad.race.ordinal + 1)
        if (nextRace == null) null else {
            val nextSpecialization = Squad.Specialization.values().getOrElse(
                prevSquad.specialization.ordinal + 1
            ) { Squad.Specialization.Melee }

            Squad(
                race = nextRace,
                specialization = nextSpecialization,
                strength = prevSquad.strength shl 1
            )
        }
    }

    override fun getSquads(
        amountFilter: AmountFilter?,
        strengthFilter: (strength: Int) -> Boolean
    ): List<Squad> {
        TODO("Not yet implemented")
    }
}