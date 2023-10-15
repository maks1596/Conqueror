package com.example.conqueror.di.main.main

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.conqueror.di.fragmentFactory.FragmentKey
import com.example.conqueror.di.viewModel.ViewModelInitializer
import com.example.ui.main.MainFragment
import com.example.viewModel.MainViewModel
import com.netology.domain.KingdomInteractor
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet

@Module
internal class MainModule {

    @Provides
    @IntoMap
    @FragmentKey(MainFragment::class)
    fun provideFragment(
        viewModelFactory: ViewModelProvider.Factory
    ): Fragment = MainFragment(viewModelFactory)

    @Provides
    @IntoSet
    fun provideViewModelInitializer(
        kingdomInteractor: KingdomInteractor,
    ) = ViewModelInitializer {
        MainViewModel(
            kingdomInteractor = kingdomInteractor
        )
    }
}