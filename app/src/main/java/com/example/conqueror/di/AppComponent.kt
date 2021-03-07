package com.example.conqueror.di

import androidx.fragment.app.FragmentFactory
import com.example.conqueror.di.fragmentFactory.FragmentFactoryModule
import com.example.conqueror.di.main.MainModule
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(
    modules = [
        AndroidInjectionModule::class,
        ActivityModule::class,
        FragmentFactoryModule::class,
        MainModule::class
    ]
)
internal interface AppComponent {

    val fragmentFactory: FragmentFactory

    @Component.Factory
    interface Factory {

        fun create(): AppComponent
    }
}