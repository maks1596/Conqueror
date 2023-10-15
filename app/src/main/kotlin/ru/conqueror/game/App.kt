package ru.conqueror.game

import android.app.Activity
import android.app.Application
import android.os.Bundle
import ru.conqueror.game.di.AppComponent
import ru.conqueror.game.di.DaggerAppComponent
import ru.conqueror.game.util.EmptyActivityLifecycleCallbacks
import ru.conqueror.ui.MainActivity

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