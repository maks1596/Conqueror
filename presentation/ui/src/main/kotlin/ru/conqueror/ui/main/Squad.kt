package ru.conqueror.ui.main

import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding
import ru.conqueror.model.Squad
import ru.conqueror.ui.R
import ru.conqueror.ui.common.getLocalizedName
import ru.conqueror.ui.databinding.SquadListItemBinding

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
