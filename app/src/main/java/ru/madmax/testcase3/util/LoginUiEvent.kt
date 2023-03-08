package ru.madmax.testcase3.util

import androidx.annotation.StringRes

sealed class LoginUiEvent {
    data class ShowDialog(@StringRes val message: Int) : LoginUiEvent()
    object Login : LoginUiEvent()
}
