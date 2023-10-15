package ru.conqueror.game.di.main.main

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import dagger.multibindings.IntoSet
import ru.conqueror.domain.KingdomInteractor
import ru.conqueror.game.di.fragmentFactory.FragmentKey
import ru.conqueror.game.di.viewModel.ViewModelInitializer
import ru.conqueror.ui.main.MainFragment
import ru.conqueror.viewModel.MainViewModel

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