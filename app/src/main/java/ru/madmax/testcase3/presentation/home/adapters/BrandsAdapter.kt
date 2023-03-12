package ru.madmax.testcase3.presentation.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.madmax.testcase3.databinding.ItemBrandsBinding
import ru.madmax.testcase3.presentation.home.itemStates.BrandsItem
import ru.madmax.testcase3.presentation.home.util.DelegateAdapter

class BrandsAdapter :
    DelegateAdapter<BrandsItem, BrandsAdapter.BrandsViewHolder>(BrandsItem::class.java) {

    inner class BrandsViewHolder(private val binding: ItemBrandsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: BrandsItem) {

        }

    }

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding =
            ItemBrandsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BrandsViewHolder(binding)
    }

    override fun bindViewHolder(model: BrandsItem, viewHolder: BrandsViewHolder) {
        viewHolder.bind(model)
    }

}