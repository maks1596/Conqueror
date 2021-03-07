package com.example.conqueror.di.fragmentFactory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import javax.inject.Provider

internal class InjectFragmentFactory(
    private val providers: Map<Class<out Fragment>, Provider<Fragment>>
) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        val clazz = classLoader.loadClass(className)
        return providers[clazz]?.get() ?: super.instantiate(classLoader, className)
    }
}