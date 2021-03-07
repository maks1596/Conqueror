package com.example.conqueror.di.fragmentFactory

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.conqueror.MainFragment
import com.example.conqueror.di.MainModule
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider

@Module(
    includes = [
        MainModule::class
    ]
)
internal abstract class FragmentFactoryModule {

    companion object {

        @Provides
        fun provideFragmentFactory(
            providers: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>
        ): FragmentFactory = InjectFragmentFactory(providers)
    }

}