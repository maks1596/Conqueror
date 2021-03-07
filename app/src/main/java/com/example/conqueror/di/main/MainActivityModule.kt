package com.example.conqueror.di.main

import com.example.conqueror.MainFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal interface MainActivityModule {

    @ContributesAndroidInjector
    fun provideMainFragment(): MainFragment
}