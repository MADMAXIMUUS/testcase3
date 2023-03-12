package ru.madmax.testcase3.presentation.home.adapters

import android.util.SparseArray
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.madmax.testcase3.presentation.home.itemStates.AdapterItem
import ru.madmax.testcase3.presentation.home.util.AdapterItemDiffCallback
import ru.madmax.testcase3.presentation.home.util.DelegateAdapter

class MainAdapter(
    private val delegates: SparseArray<DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>>
) : ListAdapter<AdapterItem, RecyclerView.ViewHolder>(AdapterItemDiffCallback()) {

    override fun getItemViewType(position: Int): Int {
        for (i in 0 until delegates.size()) {
            if (delegates[i].modelClass == getItem(position).javaClass) {
                return delegates.keyAt(i)
            }
        }
        throw NullPointerException("Can not get viewType for position $position")
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return delegates[viewType].createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val delegateAdapter = delegates[getItemViewType(position)]

        if (delegateAdapter != null) {
            delegateAdapter.bindViewHolder(getItem(position), holder)
        } else {
            throw NullPointerException("can not find adapter for position $position")
        }
    }

    override fun onViewRecycled(holder: RecyclerView.ViewHolder) {
        delegates[holder.itemViewType].onViewRecycled(holder)
        super.onViewRecycled(holder)
    }

    override fun onViewDetachedFromWindow(holder: RecyclerView.ViewHolder) {
        delegates[holder.itemViewType].onViewDetachedFromWindow(holder)
        super.onViewDetachedFromWindow(holder)
    }

    override fun onViewAttachedToWindow(holder: RecyclerView.ViewHolder) {
        delegates[holder.itemViewType].onViewAttachedToWindow(holder)
        super.onViewAttachedToWindow(holder)
    }

    class Builder {

        private var count: Int = 0
        private val delegates: SparseArray<DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>> =
            SparseArray()

        fun add(delegateAdapter: DelegateAdapter<out AdapterItem, *>) = apply {
            delegates.put(
                count++,
                delegateAdapter as DelegateAdapter<AdapterItem, RecyclerView.ViewHolder>
            )
        }

        fun build(): MainAdapter {
            require(count != 0) { "Register at least one adapter" }
            return MainAdapter(delegates)
        }
    }

}