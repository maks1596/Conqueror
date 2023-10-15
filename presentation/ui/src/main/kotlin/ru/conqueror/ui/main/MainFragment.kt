package ru.conqueror.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import kotlinx.coroutines.launch
import ru.conqueror.ui.R
import ru.conqueror.ui.common.AnyDiffCallback
import ru.conqueror.ui.databinding.MainFragmentBinding
import ru.conqueror.viewModel.MainState
import ru.conqueror.viewModel.MainViewModel

class MainFragment(
    private val viewModelFactory: ViewModelProvider.Factory
) : Fragment(R.layout.main_fragment) {

    private val viewModel: MainViewModel by viewModels { viewModelFactory }

    private val binding by viewBinding(MainFragmentBinding::bind)

    private val adapter by lazy {
        AsyncListDifferDelegationAdapter(
            AnyDiffCallback,
            KingdomState.AdapterDelegateFactory.create(),
            Squad.AdapterDelegateFactory.create()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.root.adapter = adapter
        binding.addPeopleButton.setOnClickListener {
            viewModel.onAddPeopleButtonClicked()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.stateFlow
                .flowWithLifecycle(viewLifecycleOwner.lifecycle)
                .collect(::onStateChanged)
        }
    }

    private fun onStateChanged(state: MainState) {
        adapter.items = listOfNotNull(
            KingdomState.ListItem(
                population = state.population,
                balance = state.balance
            ),
            *state.availableSquads.map { squad ->
                Squad.ListItem(
                    squad = squad,
                    available = true
                )
            }.toTypedArray(),
            state.nextAvailableSquad?.let {
                Squad.ListItem(
                    squad = it,
                    available = false
                )
            }
        )
    }
}