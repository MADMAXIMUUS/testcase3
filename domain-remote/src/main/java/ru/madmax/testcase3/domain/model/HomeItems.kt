package ru.madmax.testcase3.domain.model

data class HomeItems(
    val latest: List<Latest>,
    val flash: List<FlashSale>
)