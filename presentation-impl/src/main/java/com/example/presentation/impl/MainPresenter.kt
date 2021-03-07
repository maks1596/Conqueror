package com.example.presentation.impl

import com.example.presentation.MainContract

class MainPresenter(
    private val provideView: () -> MainContract.View
) : MainContract.Presenter {

    override fun onViewCreated() {}
}