package com.example.ui.main

import com.example.model.Squad
import com.example.ui.R
import com.example.ui.common.getLocalizedName
import com.example.ui.databinding.SquadListItemBinding
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

/**
 * Пространство имён для отображения отряда в списке
 */
internal sealed class Squad {

    object AdapterDelegateFactory {

        fun create() = adapterDelegateViewBinding<ListItem, Any, SquadListItemBinding>(
            { layoutInflater, parent ->
                SquadListItemBinding.inflate(layoutInflater, parent, false)
            }
        ) {
            bind {
                binding.strengthTextView.text = getString(
                    R.string.squad_strength_format,
                    item.squad.strength
                )
                binding.nameTextView.text = item.squad.getLocalizedName(itemView.resources)
                binding.nameTextView.isEnabled = item.available
            }
        }
    }

    /**
     * Элемент списка для отображения отряда в списке
     */
    data class ListItem(

        /**
         * Модель данных отряда
         */
        val squad: Squad,

        /**
         * Доступен ли отряд для выбора
         */
        val available: Boolean
    )
}
