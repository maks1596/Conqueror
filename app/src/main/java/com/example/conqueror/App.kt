package com.example.conqueror

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.example.conqueror.di.AppComponent
import com.example.conqueror.di.DaggerAppComponent
import com.example.conqueror.util.EmptyActivityLifecycleCallbacks
import com.example.ui.MainActivity

internal class App : Application() {

    private val component by lazy {
        DaggerAppComponent.factory().create()
    }

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(
            InjectFragmentFactoryActivityLifecycleCallbacks { component }
        )
    }

    private class InjectFragmentFactoryActivityLifecycleCallbacks(
        private val getAppComponent: () -> AppComponent
    ) : EmptyActivityLifecycleCallbacks {

        override fun onActivityCreated(
            activity: Activity, savedInstanceState: Bundle?
        ) = when (activity) {
            is MainActivity -> {
                val appComponent = getAppComponent()
                val component = appComponent.mainActivityComponent
                activity.supportFragmentManager.fragmentFactory = component.fragmentFactory
            }

            else -> Unit
        }
    }
}