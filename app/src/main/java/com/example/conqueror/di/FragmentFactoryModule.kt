package com.example.conqueror.di

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.example.conqueror.MainFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface FragmentFactoryModule {

    @Binds
    @IntoMap
    @FragmentKey(MainFragment::class)
    fun bindMainFragment(mainFragment: MainFragment): Fragment

    @Binds
    fun bindFragmentFactory(fragmentFactory: InjectFragmentFactory): FragmentFactory
}