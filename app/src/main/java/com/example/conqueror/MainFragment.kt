package com.example.conqueror

import androidx.fragment.app.Fragment
import com.example.model.Squad
import com.example.presentation.MainContract

class MainFragment :
    Fragment(R.layout.main_fragment),
    MainContract.View {

    override fun displayPopulation(population: Int) {
        TODO("Not yet implemented")
    }

    override fun displayBalance(balance: Int) {
        TODO("Not yet implemented")
    }

    override fun displaySquads(availableSquads: List<Squad>, unavailableSquads: List<Squad>) {
        TODO("Not yet implemented")
    }
}