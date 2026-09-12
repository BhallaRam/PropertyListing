package com.assessment.propertylisting.presentation.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessment.propertylisting.domain.model.User
import com.assessment.propertylisting.domain.model.UserRole
import com.assessment.propertylisting.domain.usecase.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    private val _uiState = MutableStateFlow(LoginUiState())
    val uiState: StateFlow<LoginUiState> = _uiState.asStateFlow()

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(email = email, errorMessage = null) }
    }

    fun onPasswordChange(password: String) {
        _uiState.update { it.copy(password = password, errorMessage = null) }
    }

    fun onRoleChange(role: UserRole) {
        _uiState.update {
            if (role == UserRole.USER) {
                it.copy(
                    selectedRole = role,
                    email = "user@test.com",
                    password = "user123",
                    errorMessage = null
                )
            } else {
                it.copy(
                    selectedRole = role,
                    email = "owner@test.com",
                    password = "owner123",
                    errorMessage = null
                )
            }
        }
    }

    fun togglePasswordVisibility() {
        _uiState.update { it.copy(isPasswordVisible = !it.isPasswordVisible) }
    }

    fun fillDemoCredentials() {
        onRoleChange(_uiState.value.selectedRole)
    }

    fun login(onSuccess: (User) -> Unit) {
        val currentState = _uiState.value
        _uiState.update { it.copy(isLoading = true, errorMessage = null) }

        viewModelScope.launch {
            val result = loginUseCase(
                email = currentState.email,
                password = currentState.password,
                role = currentState.selectedRole
            )

            result.onSuccess { user ->
                _uiState.update { it.copy(isLoading = false, loggedInUser = user, errorMessage = null) }
                onSuccess(user)
            }.onFailure { error ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = error.message ?: "Authentication failed. Please check credentials."
                    )
                }
            }
        }
    }
}
