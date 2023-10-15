package ru.conqueror.game.di.viewModel

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module

@Module
internal interface ViewModelModule {

    @Binds
    fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}