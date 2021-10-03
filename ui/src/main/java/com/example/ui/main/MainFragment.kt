package com.example.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.presentation.MainContract
import com.example.ui.R
import com.example.ui.common.AnyDiffCallback
import com.example.ui.databinding.RecyclerViewBinding
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

class MainFragment(
    private val getPresenter: (MainFragment) -> MainContract.Presenter
) : Fragment(R.layout.recycler_view),
    MainContract.View {

    private val presenter get() = getPresenter(this)

    private val binding by viewBinding(RecyclerViewBinding::bind)

    private val adapter by lazy {
        AsyncListDifferDelegationAdapter(
            AnyDiffCallback,
            KingdomState.AdapterDelegateFactory.create()
        )
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerView.adapter = adapter
        presenter.onViewCreated()
    }

    override fun displayState(state: MainContract.State) {
        adapter.items = listOf(
            KingdomState.ListItem(
                population = state.population,
                balance = state.balance
            )
        )
    }
}