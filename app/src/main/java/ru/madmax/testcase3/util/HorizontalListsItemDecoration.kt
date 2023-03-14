package ru.madmax.testcase3.util

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class HorizontalListsItemDecoration(
    private val spaceLeft: Int,
    private val spaceRight: Int
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
            0 -> {
                outRect.left = spaceLeft
                outRect.right = 0
            }
            else -> {
                outRect.left = spaceLeft
                outRect.right = spaceRight
            }
        }
    }
}