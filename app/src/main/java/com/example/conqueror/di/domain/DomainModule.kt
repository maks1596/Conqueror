package com.example.conqueror.di.domain

import com.netology.data.KingdomStateRepository
import com.netology.domain.KingdomInteractor
import com.netology.domain.impl.KingdomInteractorImpl
import dagger.Module
import dagger.Provides

@Module
internal class DomainModule {

    @Provides
    fun provideKingdomInteractor(
        kingdomStateRepository: KingdomStateRepository
    ): KingdomInteractor = KingdomInteractorImpl(
        kingdomStateRepository = kingdomStateRepository
    )
}