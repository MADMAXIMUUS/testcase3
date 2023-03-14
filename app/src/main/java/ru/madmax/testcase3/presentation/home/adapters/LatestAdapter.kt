package ru.madmax.testcase3.presentation.home.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.madmax.testcase3.databinding.ItemLatestBinding
import ru.madmax.testcase3.presentation.home.itemStates.LatestItem
import ru.madmax.testcase3.presentation.home.util.DelegateAdapter

class LatestAdapter :
    DelegateAdapter<LatestItem, LatestAdapter.LatestViewHolder>(LatestItem::class.java) {

    inner class LatestViewHolder(private val binding: ItemLatestBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: LatestItem) {
            with(binding) {
                itemLatestTitle.text = item.title
                itemLatestCategory.text = item.category
                itemLatestCost.text = "$${item.cost}"
                Glide
                    .with(itemLatestImage.context)
                    .load(item.image)
                    .into(itemLatestImage)
            }
        }

    }

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding =
            ItemLatestBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LatestViewHolder(binding)
    }

    override fun bindViewHolder(model: LatestItem, viewHolder: LatestViewHolder) {
        viewHolder.bind(model)
    }

}