package com.example.conqueror.di.main.main

import com.example.conqueror.di.scope.FragmentScope
import com.example.presentation.MainContract
import com.example.ui.main.MainFragment
import dagger.BindsInstance
import dagger.Subcomponent

@FragmentScope
@Subcomponent(modules = [MainModule::class])
internal interface MainComponent {

    val presenter: MainContract.Presenter

    @Subcomponent.Factory
    interface Factory {

        fun create(@BindsInstance fragment: MainFragment): MainComponent
    }
}