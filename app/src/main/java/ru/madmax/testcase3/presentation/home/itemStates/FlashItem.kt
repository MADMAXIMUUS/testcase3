package ru.madmax.testcase3.presentation.home.itemStates

import android.net.Uri

data class FlashItem(
    val id: Int,
    val category: String,
    val title: String,
    val cost: String,
    val discount: String,
    val image: Uri,
    val userImage: Uri
) : AdapterItem {

    override fun id(): Int = id

    override fun content(): Any {
        return title
    }

}
