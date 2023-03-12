package ru.madmax.testcase3.presentation.profile

import android.net.Uri
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(

) : ViewModel() {

    private val _uiState = MutableStateFlow(ProfileScreenState())
    val uiState = _uiState.asStateFlow()

    init {
        _uiState.update { currentState ->
            currentState.copy(
                name = "Satri Adhi Pradana",
                cash = 1593
            )
        }
    }

    fun updateProfilePhoto(url: Uri) {
        _uiState.update { currentState ->
            currentState.copy(
                profilePhoto = url
            )
        }
    }

}