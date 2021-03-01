package com.example.conqueror.util

import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.DefaultLifecycleObserver
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.viewbinding.ViewBinding
import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty


internal class FragmentViewBindingDelegate<T : ViewBinding>(
    val fragment: Fragment,
    val viewBindingFactory: (View) -> T
) : ReadOnlyProperty<Fragment, T> {
    private var binding: T? = null

    init {
        val fragmentLifecycleObserver = object : DefaultLifecycleObserver {
            val viewLifecycleOwnerLiveDataObserver = Observer<LifecycleOwner?> {
                val viewLifecycleOwner = it ?: return@Observer
                val viewLifecycleObserver = object : DefaultLifecycleObserver {
                    override fun onDestroy(owner: LifecycleOwner) {
                        binding = null
                    }
                }
                viewLifecycleOwner.lifecycle.addObserver(viewLifecycleObserver)
            }

            override fun onCreate(owner: LifecycleOwner) {
                fragment.viewLifecycleOwnerLiveData.observeForever(
                    viewLifecycleOwnerLiveDataObserver
                )
            }

            override fun onDestroy(owner: LifecycleOwner) {
                fragment.viewLifecycleOwnerLiveData.removeObserver(
                    viewLifecycleOwnerLiveDataObserver
                )
            }
        }
        fragment.lifecycle.addObserver(fragmentLifecycleObserver)
    }

    override fun getValue(thisRef: Fragment, property: KProperty<*>): T {
        val binding = binding
        if (binding != null) return binding

        val lifecycle = fragment.viewLifecycleOwner.lifecycle
        check(lifecycle.currentState.isAtLeast(Lifecycle.State.INITIALIZED)) {
            "Should not attempt to get bindings when Fragment views are destroyed"
        }

        return viewBindingFactory(thisRef.requireView()).also { this.binding = it }
    }
}

internal fun <T : ViewBinding> Fragment.viewBinding(viewBindingFactory: (View) -> T) =
    FragmentViewBindingDelegate(this, viewBindingFactory)