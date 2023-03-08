package ru.madmax.testcase3.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.madmax.testcase3.R
import ru.madmax.testcase3.domain.useCases.login.LoginUseCases
import ru.madmax.testcase3.util.LoginUiEvent
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCases: LoginUseCases
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginScreenState())
    val uiState = _uiState.asStateFlow()

    private val _eventFlow = MutableSharedFlow<LoginUiEvent>()
    val eventFlow = _eventFlow.asSharedFlow()

    fun updateFirstName(name: String) {
        _uiState.update { currentState ->
            currentState.copy(
                firstName = name,
                firstNameError = name.isEmpty()
            )
        }
    }

    fun updatePassword(password: String) {
        _uiState.update { currentState ->
            currentState.copy(
                password = password,
                passwordError = password.isEmpty()
            )
        }
    }

    fun updatePasswordVisibility() {
        _uiState.update { currentState ->
            currentState.copy(
                passwordVisible = !currentState.passwordVisible
            )
        }
    }

    fun login() {
        checkFields()
        if (!uiState.value.firstNameError &&
            !uiState.value.passwordError
        ) {
            viewModelScope.launch {
                val userExist = loginUseCases.checkUserExistByName(uiState.value.firstName)
                if (!userExist) {
                    _eventFlow.emit(LoginUiEvent.ShowDialog(R.string.user_not_exist))
                } else {
                    _eventFlow.emit(LoginUiEvent.Login)
                }
            }
        }
    }

    private fun checkFields() {
        _uiState.update { currentState ->
            currentState.copy(
                firstNameError = uiState.value.firstName.isEmpty(),
                passwordError = uiState.value.password.isEmpty()
            )
        }
    }
}