package com.example.conqueror.di.fragmentFactory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.conqueror.di.MainModule
import dagger.Module
import dagger.Provides
import javax.inject.Provider

@Module(
    includes = [
        MainModule::class
    ]
)
internal class FragmentFactoryModule {

    @Provides
    fun provideFragmentFactory(
        providers: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>
    ): FragmentFactory = InjectFragmentFactory(providers)
}