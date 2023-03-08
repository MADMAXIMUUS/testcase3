package ru.madmax.testcase3.presentation.signIn

import ru.madmax.testcase3.domain.model.User

data class SignInScreenState(
    val firstName: String = "",
    val firstNameError: Boolean = false,
    val lastName: String = "",
    val lastNameError: Boolean = false,
    val email: String = "",
    val emailError: Boolean = false
) {
    fun toUserModel(): User {
        return User(
            firstName = firstName,
            lastName = lastName,
            email = email
        )
    }
}
