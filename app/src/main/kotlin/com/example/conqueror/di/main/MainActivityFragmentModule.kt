package com.example.conqueror.di.main

import androidx.fragment.app.Fragment
import com.example.conqueror.di.fragmentFactory.FragmentKey
import com.example.conqueror.di.main.main.MainComponent
import com.example.ui.main.MainFragment
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
internal class MainActivityFragmentModule {

    @Provides
    @IntoMap
    @FragmentKey(MainFragment::class)
    fun provideFragment(
        componentFactory: MainComponent.Factory
    ): Fragment = MainFragment {
        val component by lazy { componentFactory.create(it) }
        component.presenter
    }
}