package com.example.conqueror.di

import com.example.conqueror.di.main.MainActivityComponent
import com.example.conqueror.di.scope.AppScope
import dagger.Component

@Component
@AppScope
internal interface AppComponent {

    val mainActivityComponent: MainActivityComponent

    @Component.Factory
    interface Factory {

        fun create(): AppComponent
    }
}