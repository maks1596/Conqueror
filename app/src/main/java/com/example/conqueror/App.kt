package com.example.conqueror

import android.app.Activity
import android.app.Application
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentFactory
import com.example.conqueror.di.DaggerAppComponent
import com.example.conqueror.util.EmptyActivityLifecycleCallbacks
import dagger.android.AndroidInjector
import dagger.android.DaggerApplication

internal class App : Application() {

    private val component by lazy {
        DaggerAppComponent.factory().create()
    }

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(InjectFragmentFactoryActivityLifecycleCallbacks(
            component.fragmentFactory
        ))
    }

    private class InjectFragmentFactoryActivityLifecycleCallbacks(
        private val fragmentFactory: FragmentFactory
    ) : EmptyActivityLifecycleCallbacks {

        override fun onActivityPreCreated(activity: Activity, savedInstanceState: Bundle?) {
            if (activity !is FragmentActivity) return
            activity.supportFragmentManager.fragmentFactory = fragmentFactory
        }
    }
}