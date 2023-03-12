package ru.madmax.testcase3.presentation.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.madmax.testcase3.databinding.ItemFlashBinding
import ru.madmax.testcase3.presentation.home.itemStates.LatestItem
import ru.madmax.testcase3.presentation.home.util.DelegateAdapter

class LatestAdapter :
    DelegateAdapter<LatestItem, LatestAdapter.LatestViewHolder>(LatestItem::class.java) {

    inner class LatestViewHolder(private val binding: ItemFlashBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: LatestItem) {

        }

    }

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding =
            ItemFlashBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LatestViewHolder(binding)
    }

    override fun bindViewHolder(model: LatestItem, viewHolder: LatestViewHolder) {
        viewHolder.bind(model)
    }

}