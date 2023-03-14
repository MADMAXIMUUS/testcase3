package ru.madmax.testcase3.presentation.home

import ru.madmax.testcase3.presentation.home.itemStates.*

data class HomeScreenState(
    val parentRawItems: List<AdapterItem> = emptyList()
)
