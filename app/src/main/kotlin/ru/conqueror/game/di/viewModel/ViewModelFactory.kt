package ru.conqueror.game.di.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras
import ru.conqueror.game.di.scope.ActivityScope
import javax.inject.Inject

@ActivityScope
internal class ViewModelFactory @Inject constructor(
    private val initializers: Set<@JvmSuppressWildcards ViewModelInitializer<*>>
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(
        modelClass: Class<T>,
        extras: CreationExtras
    ) = initializers.find {
        it.clazz == modelClass
    }?.let {
        @Suppress("UNCHECKED_CAST")
        it.initializer(extras) as? T
    } ?: throw IllegalArgumentException(
        "No initializer set for given class ${modelClass.name}"
    )
}