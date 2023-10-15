package ru.conqueror.game.di.fragmentFactory

import androidx.fragment.app.Fragment
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER)
@Retention(AnnotationRetention.RUNTIME)
internal annotation class FragmentKey(val value: KClass<out Fragment>)