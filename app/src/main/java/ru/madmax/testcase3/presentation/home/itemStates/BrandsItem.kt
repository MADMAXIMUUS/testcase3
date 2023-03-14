package ru.madmax.testcase3.presentation.home.itemStates

import androidx.annotation.DrawableRes

data class BrandsItem(
    val id: Int,
    val title: String,
    val category: String,
    val amount: Int,
    @DrawableRes val image: Int,
) : AdapterItem {

    override fun id(): Int = id

    override fun content(): Any {
        return title
    }

}
