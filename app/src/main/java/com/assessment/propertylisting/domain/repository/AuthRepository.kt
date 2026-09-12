package com.assessment.propertylisting.domain.repository

import com.assessment.propertylisting.domain.model.User
import com.assessment.propertylisting.domain.model.UserRole
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun login(email: String, password: String, role: UserRole): Result<User>
    fun getCurrentUser(): Flow<User?>
    suspend fun logout()
}
