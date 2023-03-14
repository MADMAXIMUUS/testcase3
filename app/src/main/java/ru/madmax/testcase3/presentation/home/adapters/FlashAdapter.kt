package ru.madmax.testcase3.presentation.home.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.madmax.testcase3.databinding.ItemFlashBinding
import ru.madmax.testcase3.presentation.home.itemStates.FlashItem
import ru.madmax.testcase3.presentation.home.util.DelegateAdapter

class FlashAdapter :
    DelegateAdapter<FlashItem, FlashAdapter.FlashViewHolder>(FlashItem::class.java) {

    inner class FlashViewHolder(private val binding: ItemFlashBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: FlashItem) {
            with(binding) {
                itemFlashTitle.text = item.title
                itemFlashCategory.text = item.category
                itemFlashCost.text = "$${item.cost}"
                itemFlashDiscount.text = "${item.discount}% off"
                Glide
                    .with(itemFlashImage.context)
                    .load(item.image)
                    .into(itemFlashImage)
            }

        }

    }

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        val binding =
            ItemFlashBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FlashViewHolder(binding)
    }

    override fun bindViewHolder(model: FlashItem, viewHolder: FlashViewHolder) {
        viewHolder.bind(model)
    }

}