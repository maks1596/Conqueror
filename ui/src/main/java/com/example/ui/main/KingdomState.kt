package com.example.ui.main

import com.example.ui.R
import com.example.ui.databinding.KingdomStateBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

/**
 * Пространство имён для отображения состояния королевства в списке
 */
internal sealed class KingdomState {

    object AdapterDelegateFactory {

        fun create() = adapterDelegateViewBinding<ListItem, Any, KingdomStateBinding>(
            { layoutInflater, parent -> KingdomStateBinding.inflate(layoutInflater, parent, false) }
        ) {
            bind {
                binding.balanceTextView.text = getString(
                    R.string.kingdom_balance_format,
                    item.balance
                )
                binding.populationTextView.text = getString(
                    R.string.kingdom_population_format,
                    item.population
                )
            }
        }
    }

    /**
     * Элемент списка для отображения состояния королевства в списке
     */
    data class ListItem(

        /**
         * Количество населения в королевстве
         */
        val population: Int,

        /**
         * Количество монет в казне королевства
         */
        val balance: Int
    )
}