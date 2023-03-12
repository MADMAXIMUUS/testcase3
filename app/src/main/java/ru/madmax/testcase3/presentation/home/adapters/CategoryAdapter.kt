package ru.madmax.testcase3.presentation.home.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.madmax.testcase3.databinding.ItemCategoryBinding
import ru.madmax.testcase3.presentation.home.itemStates.CategoryItem
import ru.madmax.testcase3.presentation.home.util.DelegateAdapter

class CategoryAdapter :
    DelegateAdapter<CategoryItem, CategoryAdapter.CategoryViewHolder>(CategoryItem::class.java) {

    inner class CategoryViewHolder(private val binding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: CategoryItem) {

        }

    }

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding =
            ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CategoryViewHolder(binding)
    }

    override fun bindViewHolder(model: CategoryItem, viewHolder: CategoryViewHolder) {
        viewHolder.bind(model)
    }

}