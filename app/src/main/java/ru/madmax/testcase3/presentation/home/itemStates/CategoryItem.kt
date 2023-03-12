package ru.madmax.testcase3.presentation.home.itemStates

import androidx.annotation.DrawableRes

data class CategoryItem(
    val id: Int,
    val title: String,
    @DrawableRes val icon: Int
) : AdapterItem {

    override fun id(): Int = id

    override fun content(): Any {
        return icon
    }

}
