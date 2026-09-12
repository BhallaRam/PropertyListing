package com.assessment.propertylisting.data.repository

import com.assessment.propertylisting.domain.model.User
import com.assessment.propertylisting.domain.model.UserRole
import com.assessment.propertylisting.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepositoryImpl @Inject constructor() : AuthRepository {

    private val _currentUser = MutableStateFlow<User?>(null)
    override fun getCurrentUser(): Flow<User?> = _currentUser.asStateFlow()

    override suspend fun login(email: String, password: String, role: UserRole): Result<User> {
        val trimmedEmail = email.trim().lowercase()
        val trimmedPassword = password.trim()

        return when (role) {
            UserRole.USER -> {
                if (trimmedEmail == "user@test.com" && trimmedPassword == "user123") {
                    val user = User(
                        id = "user_01",
                        name = "Amit Verma",
                        email = "user@test.com",
                        role = UserRole.USER
                    )
                    _currentUser.value = user
                    Result.success(user)
                } else {
                    Result.failure(IllegalArgumentException("Invalid user credentials. Use user@test.com / user123"))
                }
            }
            UserRole.PROPERTY_OWNER -> {
                if (trimmedEmail == "owner@test.com" && trimmedPassword == "owner123") {
                    val owner = User(
                        id = "owner_01",
                        name = "Rajesh Sharma",
                        email = "owner@test.com",
                        role = UserRole.PROPERTY_OWNER
                    )
                    _currentUser.value = owner
                    Result.success(owner)
                } else if (trimmedEmail == "owner2@test.com" && trimmedPassword == "owner123") {
                    val owner = User(
                        id = "owner_02",
                        name = "Pooja Malhotra",
                        email = "owner2@test.com",
                        role = UserRole.PROPERTY_OWNER
                    )
                    _currentUser.value = owner
                    Result.success(owner)
                } else {
                    Result.failure(IllegalArgumentException("Invalid owner credentials. Use owner@test.com / owner123"))
                }
            }
        }
    }

    override suspend fun logout() {
        _currentUser.value = null
    }
}
