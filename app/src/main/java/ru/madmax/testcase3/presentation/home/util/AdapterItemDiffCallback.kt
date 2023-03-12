package ru.madmax.testcase3.presentation.home.util

import android.annotation.SuppressLint
import androidx.recyclerview.widget.DiffUtil
import ru.madmax.testcase3.presentation.home.itemStates.AdapterItem

internal class AdapterItemDiffCallback: DiffUtil.ItemCallback<AdapterItem>() {

    override fun areItemsTheSame(oldItem: AdapterItem, newItem: AdapterItem): Boolean =
        oldItem::class == newItem::class && oldItem.id() == newItem.id()

    @SuppressLint("DiffUtilEquals")
    override fun areContentsTheSame(oldItem: AdapterItem, newItem: AdapterItem): Boolean =
        oldItem.content() == newItem.content()
}