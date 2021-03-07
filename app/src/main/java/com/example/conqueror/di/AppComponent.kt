package com.example.conqueror.di

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
internal interface AppComponent : AndroidInjector<App> {

    override fun inject(application: App)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance application: App): AppComponent
    }
}