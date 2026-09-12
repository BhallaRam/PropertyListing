package com.assessment.propertylisting.presentation.login

import com.assessment.propertylisting.domain.model.User
import com.assessment.propertylisting.domain.model.UserRole

data class LoginUiState(
    val email: String = "user@test.com",
    val password: String = "user123",
    val selectedRole: UserRole = UserRole.USER,
    val isPasswordVisible: Boolean = false,
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val loggedInUser: User? = null
)
