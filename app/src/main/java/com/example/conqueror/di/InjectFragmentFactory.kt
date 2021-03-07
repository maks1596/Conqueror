package com.example.conqueror.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Inject
import javax.inject.Provider

internal class InjectFragmentFactory @Inject constructor(
    private val providers: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val clazz = classLoader.loadClass(className)
        return providers[clazz]?.get() ?: super.instantiate(classLoader, className)
    }
}