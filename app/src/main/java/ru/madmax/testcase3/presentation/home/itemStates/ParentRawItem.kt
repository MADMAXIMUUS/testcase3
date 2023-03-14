package ru.madmax.testcase3.presentation.home.itemStates

data class ParentRawItem(
    val title: String,
    val isTitleNeeded: Boolean,
    val items: List<AdapterItem>
) : AdapterItem {
    override fun id(): Any = title

    override fun content(): Any = items
}
