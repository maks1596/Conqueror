package com.example.conqueror.di

import com.example.conqueror.MainActivity
import com.example.conqueror.di.main.MainActivityModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface ActivityModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    fun provideMainActivity(): MainActivity
}