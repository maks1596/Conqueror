package com.example.conqueror.di.main

import com.example.conqueror.MainFragment
import com.example.presentation.MainContract
import com.example.presentation.impl.MainPresenter
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
internal class MainModule {

    @Provides
    fun providePresenter(
        fragmentProvider: Lazy<MainFragment>
    ): MainContract.Presenter = MainPresenter(
        provideView = fragmentProvider::get
    )
}