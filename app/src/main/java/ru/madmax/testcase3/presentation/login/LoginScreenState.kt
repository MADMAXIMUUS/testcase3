package ru.madmax.testcase3.presentation.login

data class LoginScreenState(
    val firstName: String = "",
    val firstNameError: Boolean = false,
    val password: String = "",
    val passwordError: Boolean = false,
    val passwordVisible: Boolean = false
)
