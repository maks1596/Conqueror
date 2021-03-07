package com.example.conqueror.di

import androidx.fragment.app.Fragment
import com.example.conqueror.MainFragment
import com.example.conqueror.di.fragmentFactory.FragmentKey
import com.example.presentation.MainContract
import com.example.presentation.impl.MainPresenter
import dagger.Binds
import dagger.Lazy
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap

@Module
internal abstract class MainModule {

    companion object {
        
        @Provides
        fun provideFragment(
            presenterProvider: Lazy<MainContract.Presenter>
        ) = MainFragment(
            getPresenter = presenterProvider::get
        )

        @Provides
        fun providePresenter(
            fragmentProvider: Lazy<MainFragment>
        ): MainContract.Presenter = MainPresenter(
            getView = fragmentProvider::get
        )
    }

    @Binds
    @IntoMap
    @FragmentKey(MainFragment::class)
    abstract fun bindMainFragment(mainFragment: MainFragment): Fragment
}