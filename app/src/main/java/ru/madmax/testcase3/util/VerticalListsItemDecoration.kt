package ru.madmax.testcase3.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class VerticalListsItemDecoration(
    private val spaceTop: Int,
    private val spaceBottom: Int
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        val position = parent.getChildAdapterPosition(view)
        if (position == -1) return
        when (position) {
            parent.adapter?.itemCount!! - 1 -> {
                outRect.top = spaceTop
                outRect.bottom = 100
            }
            0 -> {
                outRect.top = 0
                outRect.bottom = spaceBottom
            }
            else -> {
                outRect.bottom = spaceBottom
                outRect.top = spaceTop
            }
        }
    }
}