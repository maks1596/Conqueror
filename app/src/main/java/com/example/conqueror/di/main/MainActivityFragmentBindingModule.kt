package com.example.conqueror.di.main

import androidx.fragment.app.Fragment
import com.example.conqueror.di.fragmentFactory.FragmentKey
import com.example.ui.main.MainFragment
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface MainActivityFragmentBindingModule {


    @Binds
    @IntoMap
    @FragmentKey(MainFragment::class)
    fun bindMainFragment(mainFragment: MainFragment): Fragment
}