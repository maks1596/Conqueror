package com.example.conqueror

import com.example.conqueror.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

internal class App : DaggerApplication() {

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> =
        DaggerAppComponent.factory().create(this)
}