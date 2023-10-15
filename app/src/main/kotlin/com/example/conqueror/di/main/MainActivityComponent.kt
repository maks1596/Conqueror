package com.example.conqueror.di.main

import androidx.fragment.app.FragmentFactory
import com.example.conqueror.di.fragmentFactory.FragmentFactoryModule
import com.example.conqueror.di.main.main.MainModule
import com.example.conqueror.di.scope.ActivityScope
import com.example.conqueror.di.viewModel.ViewModelModule
import dagger.Subcomponent

@Subcomponent(
    modules = [
        FragmentFactoryModule::class,
        ViewModelModule::class,
        MainModule::class
    ]
)
@ActivityScope
internal interface MainActivityComponent {

    val fragmentFactory: FragmentFactory
}