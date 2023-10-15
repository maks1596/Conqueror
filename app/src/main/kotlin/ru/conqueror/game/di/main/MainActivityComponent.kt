package ru.conqueror.game.di.main

import androidx.fragment.app.FragmentFactory
import dagger.Subcomponent
import ru.conqueror.game.di.fragmentFactory.FragmentFactoryModule
import ru.conqueror.game.di.main.main.MainModule
import ru.conqueror.game.di.scope.ActivityScope
import ru.conqueror.game.di.viewModel.ViewModelModule

@Subcomponent(
    modules = [
        FragmentFactoryModule::class,
        ViewModelModule::class,
        MainModule::class
    ]
)
@ActivityScope
internal interface MainActivityComponent {

    val fragmentFactory: FragmentFactory
}