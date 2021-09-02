package com.example.conqueror.di.main

import androidx.fragment.app.FragmentFactory
import com.example.conqueror.di.fragmentFactory.FragmentFactoryModule
import com.example.conqueror.di.main.main.MainComponent
import com.example.conqueror.di.scope.ActivityScope
import dagger.Subcomponent

@Subcomponent(
    modules = [
        FragmentFactoryModule::class,
        MainActivityFragmentModule::class
    ]
)
@ActivityScope
internal interface MainActivityComponent {

    val fragmentFactory: FragmentFactory

    val mainComponentFactory: MainComponent.Factory
}