package ru.madmax.testcase3.presentation.signIn

import android.util.Patterns
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import ru.madmax.testcase3.R
import ru.madmax.testcase3.domain.useCase.LoginUseCases
import ru.madmax.testcase3.util.LoginUiEvent
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val loginUseCases: LoginUseCases
) : ViewModel() {

    private val _uiState = MutableStateFlow(SignInScreenState())
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

    fun updateLastName(name: String) {
        _uiState.update { currentState ->
            currentState.copy(
                lastName = name,
                lastNameError = name.isEmpty()
            )
        }
    }

    fun updateEmail(email: String) {
        _uiState.update { currentState ->
            currentState.copy(
                email = email,
                emailError = !isEmailValid(email)
            )
        }
    }

    fun signIn() {
        checkFields()
        if (!uiState.value.firstNameError &&
            !uiState.value.lastNameError &&
            !uiState.value.emailError
        ) {
            viewModelScope.launch {
                val userExist = loginUseCases.checkUserExistByEmailUseCase(uiState.value.email)
                if (userExist) {
                    _eventFlow.emit(LoginUiEvent.ShowDialog(R.string.user_exist))
                } else {
                    loginUseCases.createUserUseCase(uiState.value.toUserModel())
                    _eventFlow.emit(LoginUiEvent.Login)
                }
            }
        }
    }

    private fun checkFields() {
        _uiState.update { currentState ->
            currentState.copy(
                emailError = !isEmailValid(uiState.value.email),
                firstNameError = uiState.value.firstName.isEmpty(),
                lastNameError = uiState.value.lastName.isEmpty()
            )
        }
    }

    private fun isEmailValid(email: String): Boolean {
        return (email.isNotEmpty() && Patterns.EMAIL_ADDRESS.matcher(email).matches())
    }
}