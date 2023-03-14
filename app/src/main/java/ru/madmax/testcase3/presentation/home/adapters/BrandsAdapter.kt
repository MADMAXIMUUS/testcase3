package ru.madmax.testcase3.presentation.home.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import ru.madmax.testcase3.databinding.ItemBrandsBinding
import ru.madmax.testcase3.presentation.home.itemStates.BrandsItem
import ru.madmax.testcase3.presentation.home.util.DelegateAdapter

class BrandsAdapter :
    DelegateAdapter<BrandsItem, BrandsAdapter.BrandsViewHolder>(BrandsItem::class.java) {

    inner class BrandsViewHolder(private val binding: ItemBrandsBinding) :
        RecyclerView.ViewHolder(binding.root) {

        @SuppressLint("SetTextI18n")
        fun bind(item: BrandsItem) {
            with(binding) {
                itemBrandsTitle.text = item.title
                itemBrandsCategory.text = item.category
                itemBrandsCost.text = "$${item.amount}"
                Glide
                    .with(itemBrandsImage.context)
                    .load(item.image)
                    .into(itemBrandsImage)
            }
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