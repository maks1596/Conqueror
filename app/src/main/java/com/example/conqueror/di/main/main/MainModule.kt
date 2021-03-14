package com.example.conqueror.di.main.main

import com.example.conqueror.di.scope.ActivityScope
import com.example.presentation.MainContract
import com.example.presentation.impl.MainPresenter
import com.example.ui.main.MainFragment
import dagger.Lazy
import dagger.Module
import dagger.Provides

@Module
internal class MainModule {

    @Provides
    @ActivityScope
    fun provideFragment(
        presenterProvider: Lazy<MainContract.Presenter>
    ) = MainFragment(
        getPresenter = presenterProvider::get
    )

    @Provides
    @ActivityScope
    fun providePresenter(
        fragmentProvider: Lazy<MainFragment>
    ): MainContract.Presenter = MainPresenter(
        getView = fragmentProvider::get
    )
}