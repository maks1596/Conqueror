package com.example.conqueror.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.conqueror.MainFragment
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import javax.inject.Provider

@Module
internal abstract class FragmentFactoryModule {

    companion object {

        @Provides
        fun provideFragmentFactory(
            providers: Map<Class<out Fragment>, @JvmSuppressWildcards Provider<Fragment>>
        ): FragmentFactory = InjectFragmentFactory(providers)
    }

    @Binds
    @IntoMap
    @FragmentKey(MainFragment::class)
    abstract fun bindMainFragment(mainFragment: MainFragment): Fragment

}