package ru.madmax.testcase3.presentation.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ru.madmax.testcase3.databinding.ItemParentRawBinding
import ru.madmax.testcase3.presentation.home.itemStates.ParentRawItem
import ru.madmax.testcase3.presentation.home.util.DelegateAdapter
import ru.madmax.testcase3.util.HorizontalListsItemDecoration
import ru.madmax.testcase3.util.showIf

class ParentRawAdapter :
    DelegateAdapter<ParentRawItem, ParentRawAdapter.ParentRawViewHolder>(ParentRawItem::class.java) {

    inner class ParentRawViewHolder(private val binding: ItemParentRawBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: ParentRawItem) {

            val horizontalAdapter = MainAdapter.Builder()
                .add(CategoryAdapter())
                .add(FlashAdapter())
                .add(LatestAdapter())
                .add(BrandsAdapter())
                .build()

            horizontalAdapter.submitList(item.items)

            with(binding) {
                itemRawTitle.text = item.title
                itemRawTitle.showIf { item.isTitleNeeded }
                itemRawViewAll.showIf { item.isTitleNeeded }
                itemRawRv.apply {
                    this.adapter = horizontalAdapter
                    layoutManager = LinearLayoutManager(context, RecyclerView.HORIZONTAL, false)
                    addItemDecoration(HorizontalListsItemDecoration(20, 20))
                }
            }
        }

    }

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding =
            ItemParentRawBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ParentRawViewHolder(binding)
    }

    override fun bindViewHolder(model: ParentRawItem, viewHolder: ParentRawViewHolder) {
        viewHolder.bind(model)
    }

}