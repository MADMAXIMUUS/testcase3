package ru.madmax.testcase3.domain.model

data class User(
    val firstName: String,
    val lastName: String,
    val email: String,
    val id: Int? = null
)
