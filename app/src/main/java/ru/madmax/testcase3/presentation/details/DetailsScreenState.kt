package ru.madmax.testcase3.presentation.details

data class DetailsScreenState(
    val id: Int = -1,
    val title: String = "",
    val description: String = "",
    val rating: Double = 0.0,
    val numberOfReviews: Int = 0,
    val price: Int = 0,
    val colors: List<String> = emptyList(),
    val imageUrls: List<String> = emptyList()
)