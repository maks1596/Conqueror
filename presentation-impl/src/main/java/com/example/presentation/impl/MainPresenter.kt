package com.example.presentation.impl

import com.example.presentation.MainContract

class MainPresenter(
    private val view: MainContract.View
) : MainContract.Presenter {

    override fun onViewCreated() {
        val state = MainContract.State(
            population = 10,
            balance = 100,
            availableSquads = emptyList(),
            unavailableSquads = emptyList()
        )
        view.displayState(state)
    }
}