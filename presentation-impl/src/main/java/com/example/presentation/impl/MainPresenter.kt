package com.example.presentation.impl

import com.example.presentation.MainContract

class MainPresenter(
    private val getView: () -> MainContract.View
) : MainContract.Presenter {

    override fun onViewCreated() {}
}