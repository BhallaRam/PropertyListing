package com.assessment.propertylisting.domain.usecase

import com.assessment.propertylisting.domain.model.Interest
import com.assessment.propertylisting.domain.repository.InterestRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class SubmitInterestUseCaseTest {

    private lateinit var submitInterestUseCase: SubmitInterestUseCase
    private lateinit var fakeRepository: FakeInterestRepository

    class FakeInterestRepository : InterestRepository {
        val savedInterests = mutableListOf<Interest>()

        override suspend fun submitInterest(interest: Interest): Result<Unit> {
            savedInterests.add(interest)
            return Result.success(Unit)
        }

        override fun getInterestsByOwner(ownerId: String): Flow<List<Interest>> {
            return flowOf(savedInterests.filter { it.ownerId == ownerId })
        }

        override fun getInterestsByProperty(propertyId: String): Flow<List<Interest>> {
            return flowOf(savedInterests.filter { it.propertyId == propertyId })
        }
    }

    @Before
    fun setUp() {
        fakeRepository = FakeInterestRepository()
        submitInterestUseCase = SubmitInterestUseCase(fakeRepository)
    }

    @Test
    fun `validate with blank name returns nameError`() {
        val params = SubmitInterestUseCase.Params(
            propertyId = "prop_1",
            propertyName = "Royal Palms",
            ownerId = "owner_1",
            userName = "",
            mobileNumber = "9876543210",
            email = "buyer@test.com",
            message = "Interested in this property"
        )
        val validation = submitInterestUseCase.validate(params)
        assertTrue(validation is SubmitInterestUseCase.ValidationResult.Invalid)
        assertNotNull((validation as SubmitInterestUseCase.ValidationResult.Invalid).nameError)
    }

    @Test
    fun `validate with invalid mobile returns mobileError`() {
        val params = SubmitInterestUseCase.Params(
            propertyId = "prop_1",
            propertyName = "Royal Palms",
            ownerId = "owner_1",
            userName = "Amit Verma",
            mobileNumber = "12345", // Less than 10 digits
            email = "buyer@test.com",
            message = "Interested in this property"
        )
        val validation = submitInterestUseCase.validate(params)
        assertTrue(validation is SubmitInterestUseCase.ValidationResult.Invalid)
        assertNotNull((validation as SubmitInterestUseCase.ValidationResult.Invalid).mobileError)
    }

    @Test
    fun `validate with invalid email returns emailError`() {
        val params = SubmitInterestUseCase.Params(
            propertyId = "prop_1",
            propertyName = "Royal Palms",
            ownerId = "owner_1",
            userName = "Amit Verma",
            mobileNumber = "9876543210",
            email = "invalid-email-format",
            message = "Interested in this property"
        )
        val validation = submitInterestUseCase.validate(params)
        assertTrue(validation is SubmitInterestUseCase.ValidationResult.Invalid)
        assertNotNull((validation as SubmitInterestUseCase.ValidationResult.Invalid).emailError)
    }

    @Test
    fun `validate with blank message returns messageError`() {
        val params = SubmitInterestUseCase.Params(
            propertyId = "prop_1",
            propertyName = "Royal Palms",
            ownerId = "owner_1",
            userName = "Amit Verma",
            mobileNumber = "9876543210",
            email = "buyer@test.com",
            message = "   "
        )
        val validation = submitInterestUseCase.validate(params)
        assertTrue(validation is SubmitInterestUseCase.ValidationResult.Invalid)
        assertNotNull((validation as SubmitInterestUseCase.ValidationResult.Invalid).messageError)
    }

    @Test
    fun `valid parameters save interest successfully to repository`() = runTest {
        val params = SubmitInterestUseCase.Params(
            propertyId = "prop_101",
            propertyName = "Royal Palms Villa",
            ownerId = "owner_01",
            userName = "Amit Verma",
            mobileNumber = "9876543210",
            email = "buyer@test.com",
            message = "Would love to visit this Sunday"
        )

        val result = submitInterestUseCase(params)

        assertTrue(result.isSuccess)
        assertEquals(1, fakeRepository.savedInterests.size)
        val saved = fakeRepository.savedInterests.first()
        assertEquals("prop_101", saved.propertyId)
        assertEquals("owner_01", saved.ownerId)
        assertEquals("Amit Verma", saved.userName)
        assertEquals("9876543210", saved.mobileNumber)
        assertEquals("buyer@test.com", saved.email)
        assertEquals("Would love to visit this Sunday", saved.message)
    }
}
