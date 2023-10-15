package com.example.ui.common

import android.content.res.Resources
import com.example.model.Squad
import com.example.ui.R

internal fun Squad.getLocalizedName(resources: Resources): String {
    val localizedRace = race.getLocalizedName(resources)
    val localizedSpecialization = specialization.getLocalizedName(resources)
    return resources.getString(
        R.string.squad_name_format,
        localizedRace, localizedSpecialization
    )
}

private fun Squad.Race.getLocalizedName(resources: Resources) = when (this) {
    Squad.Race.Human -> R.string.squad_race_human
    Squad.Race.Elf -> R.string.squad_race_elf
    Squad.Race.Orc -> R.string.squad_race_orc
    Squad.Race.Dwarf -> R.string.squad_race_dwarf
}.let(resources::getString)

private fun Squad.Specialization.getLocalizedName(resources: Resources) = when (this) {
    Squad.Specialization.Melee -> R.string.squad_specialization_melee
    Squad.Specialization.Range -> R.string.squad_specialization_range
    Squad.Specialization.Magic -> R.string.squad_specialization_mage
}.let(resources::getString)