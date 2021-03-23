package com.example.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import com.example.presentation.MainContract
import com.example.ui.R
import com.example.ui.databinding.RecyclerViewBinding
import com.example.ui.util.viewBinding
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter
import java.util.*

class MainFragment(
    private val getPresenter: (MainFragment) -> MainContract.Presenter
) : Fragment(R.layout.recycler_view),
    MainContract.View {

    private val presenter get() = getPresenter(this)

    private val binding by viewBinding(RecyclerViewBinding::bind)

    private val adapter by lazy {
        AsyncListDifferDelegationAdapter(
            object : DiffUtil.ItemCallback<Any>() {
                override fun areItemsTheSame(oldItem: Any, newItem: Any) = oldItem === newItem

                override fun areContentsTheSame(oldItem: Any, newItem: Any) =
                    Objects.equals(oldItem, newItem)

            },
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