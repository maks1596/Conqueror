package ru.conqueror.game.di

import dagger.Component
import ru.conqueror.game.di.data.DataModule
import ru.conqueror.game.di.domain.DomainModule
import ru.conqueror.game.di.main.MainActivityComponent
import ru.conqueror.game.di.scope.AppScope

@Component(
    modules = [
        AppModule::class,
        DataModule::class,
        DomainModule::class,
    ]
)
@AppScope
internal interface AppComponent {

    val mainActivityComponent: MainActivityComponent

    @Component.Factory
    interface Factory {

        fun create(): AppComponent
    }
}