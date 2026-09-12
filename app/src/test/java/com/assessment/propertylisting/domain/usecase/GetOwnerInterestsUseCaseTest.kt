package com.assessment.propertylisting.domain.usecase

import com.assessment.propertylisting.domain.model.Interest
import com.assessment.propertylisting.domain.repository.InterestRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class GetOwnerInterestsUseCaseTest {

    private lateinit var getOwnerInterestsUseCase: GetOwnerInterestsUseCase
    private lateinit var fakeInterestRepository: FakeInterestRepository

    class FakeInterestRepository : InterestRepository {
        val interests = mutableListOf<Interest>()

        override suspend fun submitInterest(interest: Interest): Result<Unit> {
            interests.add(interest)
            return Result.success(Unit)
        }

        override fun getInterestsByOwner(ownerId: String): Flow<List<Interest>> {
            return flowOf(interests.filter { it.ownerId == ownerId })
        }

        override fun getInterestsByProperty(propertyId: String): Flow<List<Interest>> {
            return flowOf(interests.filter { it.propertyId == propertyId })
        }
    }

    @Before
    fun setUp() {
        fakeInterestRepository = FakeInterestRepository()
        getOwnerInterestsUseCase = GetOwnerInterestsUseCase(fakeInterestRepository)

        // Seed with inquiries for multiple owners
        fakeInterestRepository.interests.addAll(
            listOf(
                Interest(
                    id = "i1",
                    propertyId = "prop_101",
                    propertyName = "Royal Palms",
                    ownerId = "owner_01",
                    userName = "User One",
                    mobileNumber = "9999999991",
                    email = "u1@test.com",
                    message = "Inquiry 1"
                ),
                Interest(
                    id = "i2",
                    propertyId = "prop_102",
                    propertyName = "Emerald Heights",
                    ownerId = "owner_01",
                    userName = "User Two",
                    mobileNumber = "9999999992",
                    email = "u2@test.com",
                    message = "Inquiry 2"
                ),
                Interest(
                    id = "i3",
                    propertyId = "prop_108",
                    propertyName = "Koregaon Manor",
                    ownerId = "owner_02",
                    userName = "User Three",
                    mobileNumber = "9999999993",
                    email = "u3@test.com",
                    message = "Inquiry 3"
                )
            )
        )
    }

    @Test
    fun `owner 01 retrieves only their own property inquiries`() = runTest {
        val result = getOwnerInterestsUseCase("owner_01").first()
        assertEquals(2, result.size)
        assertTrue(result.all { it.ownerId == "owner_01" })
    }

    @Test
    fun `owner 02 retrieves only their own property inquiries`() = runTest {
        val result = getOwnerInterestsUseCase("owner_02").first()
        assertEquals(1, result.size)
        assertEquals("owner_02", result.first().ownerId)
        assertEquals("Koregaon Manor", result.first().propertyName)
    }

    @Test
    fun `owner with no inquiries returns empty list`() = runTest {
        val result = getOwnerInterestsUseCase("owner_99").first()
        assertTrue(result.isEmpty())
    }
}
