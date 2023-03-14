package ru.madmax.testcase3.presentation.home.itemStates

data class FlashItem(
    val category: String,
    val title: String,
    val cost: Double,
    val discount: Int,
    val image: String
) : AdapterItem {

    override fun id(): Any = title

    override fun content(): Any {
        return title
    }

}
