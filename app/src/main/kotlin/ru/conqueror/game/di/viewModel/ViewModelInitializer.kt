package ru.conqueror.game.di.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.CreationExtras

internal class ViewModelInitializer<T : ViewModel>(
    val clazz: Class<T>,
    val initializer: CreationExtras.() -> T,
)

internal inline fun <reified VM : ViewModel> ViewModelInitializer(
    noinline initializer: CreationExtras.() -> VM
): ViewModelInitializer<*> = ViewModelInitializer(VM::class.java, initializer)