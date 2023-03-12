package ru.madmax.testcase3.presentation.home.itemStates

import android.net.Uri

data class LatestItem(
    val id: Int,
    val category: String,
    val cost: String,
    val title: String,
    val image: Uri
) : AdapterItem {

    override fun id(): Int = id

    override fun content(): Any {
        return title
    }

}
