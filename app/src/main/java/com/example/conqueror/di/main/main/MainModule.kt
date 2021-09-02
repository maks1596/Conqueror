package com.example.conqueror.di.main.main

import com.example.conqueror.di.scope.FragmentScope
import com.example.presentation.MainContract
import com.example.presentation.impl.MainPresenter
import com.example.ui.main.MainFragment
import com.netology.domain.KingdomInteractor
import androidx.lifecycle.lifecycleScope
import dagger.Module
import dagger.Provides

@Module
internal class MainModule {

    @Provides
    @FragmentScope
    fun providePresenter(
        fragment: MainFragment,
        kingdomInteractor: KingdomInteractor,
    ): MainContract.Presenter = MainPresenter(
        coroutineScope = fragment.lifecycleScope,
        kingdomInteractor = kingdomInteractor,
        view = fragment,
    )
}