package ru.conqueror.ui.common

import androidx.recyclerview.widget.DiffUtil
import java.util.Objects

internal object AnyDiffCallback : DiffUtil.ItemCallback<Any>() {

    override fun areItemsTheSame(oldItem: Any, newItem: Any) =
        oldItem === newItem

    override fun areContentsTheSame(oldItem: Any, newItem: Any) =
        Objects.equals(oldItem, newItem)
}