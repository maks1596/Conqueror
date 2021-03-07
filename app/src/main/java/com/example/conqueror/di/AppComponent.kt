package com.example.conqueror.di

import androidx.fragment.app.FragmentFactory
import com.example.conqueror.di.fragmentFactory.FragmentFactoryModule
import dagger.Component
import dagger.android.AndroidInjectionModule

@Component(
    modules = [
        AndroidInjectionModule::class,
        FragmentFactoryModule::class
    ]
)
internal interface AppComponent {

    val fragmentFactory: FragmentFactory

    @Component.Factory
    interface Factory {

        fun create(): AppComponent
    }
}