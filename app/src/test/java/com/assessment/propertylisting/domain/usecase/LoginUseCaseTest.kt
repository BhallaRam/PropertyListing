package com.assessment.propertylisting.domain.usecase

import com.assessment.propertylisting.data.repository.AuthRepositoryImpl
import com.assessment.propertylisting.domain.model.UserRole
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class LoginUseCaseTest {

    private lateinit var loginUseCase: LoginUseCase
    private lateinit var authRepository: AuthRepositoryImpl

    @Before
    fun setUp() {
        authRepository = AuthRepositoryImpl()
        loginUseCase = LoginUseCase(authRepository)
    }

    @Test
    fun `user login with valid credentials succeeds`() = runTest {
        val result = loginUseCase("user@test.com", "user123", UserRole.USER)
        assertTrue(result.isSuccess)
        assertEquals(UserRole.USER, result.getOrNull()?.role)
        assertEquals("user@test.com", result.getOrNull()?.email)
    }

    @Test
    fun `owner login with valid credentials succeeds`() = runTest {
        val result = loginUseCase("owner@test.com", "owner123", UserRole.PROPERTY_OWNER)
        assertTrue(result.isSuccess)
        assertEquals(UserRole.PROPERTY_OWNER, result.getOrNull()?.role)
        assertEquals("owner_01", result.getOrNull()?.id)
    }

    @Test
    fun `login with empty email fails`() = runTest {
        val result = loginUseCase("", "user123", UserRole.USER)
        assertTrue(result.isFailure)
    }

    @Test
    fun `login with empty password fails`() = runTest {
        val result = loginUseCase("user@test.com", "", UserRole.USER)
        assertTrue(result.isFailure)
    }

    @Test
    fun `login with incorrect credentials fails`() = runTest {
        val result = loginUseCase("user@test.com", "wrongpass", UserRole.USER)
        assertTrue(result.isFailure)
    }
}
