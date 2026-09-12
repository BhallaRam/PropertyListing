package com.assessment.propertylisting.domain.usecase

import com.assessment.propertylisting.domain.model.User
import com.assessment.propertylisting.domain.model.UserRole
import com.assessment.propertylisting.domain.repository.AuthRepository
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(email: String, password: String, role: UserRole): Result<User> {
        if (email.isBlank()) {
            return Result.failure(IllegalArgumentException("Email cannot be empty."))
        }
        if (password.isBlank()) {
            return Result.failure(IllegalArgumentException("Password cannot be empty."))
        }
        return authRepository.login(email, password, role)
    }
}
