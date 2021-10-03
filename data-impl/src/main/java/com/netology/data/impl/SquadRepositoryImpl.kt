package com.netology.data.impl

import com.example.model.Squad
import com.netology.data.AmountFilter
import com.netology.data.First
import com.netology.data.Last
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
        val nextSquadSpecialization = prevSquad.specialization.next
        if (nextSquadSpecialization != null) {
            prevSquad.copy(
                specialization = nextSquadSpecialization,
                strength = prevSquad.countNextSquadStrength()
            )
        } else {
            val nextRace = prevSquad.race.next
            if (nextRace == null) null else Squad(
                race = nextRace,
                specialization = Squad.Specialization.Melee,
                strength = prevSquad.countNextSquadStrength()
            )
        }
    }

    override fun getSquads(
        amountFilter: AmountFilter?,
        strengthFilter: (strength: Int) -> Boolean
    ): List<Squad> {
        val strengthFilteredSquads = squads.filter {
            strengthFilter(it.strength)
        }

        return when (amountFilter) {
            null -> strengthFilteredSquads.toList()
            is First -> strengthFilteredSquads.take(amountFilter.amount).toList()
            is Last -> strengthFilteredSquads.toList().takeLast(amountFilter.amount)
        }
    }
}

private val Squad.Race.next get() = Squad.Race.values().getOrNull(ordinal + 1)
private val Squad.Specialization.next get() = Squad.Specialization.values().getOrNull(ordinal + 1)
private fun Squad.countNextSquadStrength() = strength shl 1