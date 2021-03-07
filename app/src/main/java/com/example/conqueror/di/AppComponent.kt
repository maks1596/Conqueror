package com.example.conqueror.di

import androidx.fragment.app.FragmentFactory
import com.example.conqueror.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector

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