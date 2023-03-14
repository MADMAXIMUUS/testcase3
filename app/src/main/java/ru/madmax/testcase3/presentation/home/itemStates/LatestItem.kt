package ru.madmax.testcase3.presentation.home.itemStates

data class LatestItem(
    val category: String,
    val cost: Int,
    val title: String,
    val image: String
) : AdapterItem {

    override fun id(): Any = title

    override fun content(): Any {
        return title
    }

}
