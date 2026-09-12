package com.assessment.propertylisting.domain.usecase

import com.assessment.propertylisting.domain.model.Property
import com.assessment.propertylisting.domain.model.PropertyStatus
import com.assessment.propertylisting.domain.model.PropertyType
import com.assessment.propertylisting.domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class DeletePropertyUseCaseTest {

    private lateinit var deletePropertyUseCase: DeletePropertyUseCase
    private lateinit var fakePropertyRepository: FakePropertyRepository

    class FakePropertyRepository : PropertyRepository {
        val properties = mutableListOf<Property>()

        override fun getAllProperties(): Flow<List<Property>> = flowOf(properties)
        override suspend fun getPropertyById(id: String): Property? = properties.find { it.id == id }
        override fun getPropertiesByOwner(ownerId: String): Flow<List<Property>> = flowOf(properties.filter { it.ownerId == ownerId })
        override suspend fun saveProperty(property: Property): Result<Unit> {
            properties.add(property)
            return Result.success(Unit)
        }
        override suspend fun updateProperty(property: Property): Result<Unit> {
            val index = properties.indexOfFirst { it.id == property.id }
            if (index != -1) {
                properties[index] = property
                return Result.success(Unit)
            }
            return Result.failure(IllegalArgumentException("Property not found"))
        }
        override suspend fun deleteProperty(id: String): Result<Unit> {
            properties.removeAll { it.id == id }
            return Result.success(Unit)
        }
        override suspend fun insertProperties(properties: List<Property>) {
            this.properties.addAll(properties)
        }
        override suspend fun getPropertyCount(): Int = properties.size
    }

    @Before
    fun setUp() {
        fakePropertyRepository = FakePropertyRepository()
        deletePropertyUseCase = DeletePropertyUseCase(fakePropertyRepository)

        fakePropertyRepository.properties.add(
            Property(
                id = "prop_to_delete",
                propertyName = "Property To Remove",
                propertyType = PropertyType.VILLA,
                location = "Jaipur",
                price = 12000000.0,
                area = 2400,
                configuration = "3 BHK",
                status = PropertyStatus.AVAILABLE,
                description = "To be deleted",
                imageUrl = "",
                ownerId = "owner_01",
                ownerName = "Rajesh Sharma"
            )
        )
    }

    @Test
    fun `deleting existing property removes it from repository`() = runTest {
        assertEquals(1, fakePropertyRepository.properties.size)
        val result = deletePropertyUseCase("prop_to_delete")
        assertTrue(result.isSuccess)
        assertEquals(0, fakePropertyRepository.properties.size)
        assertNull(fakePropertyRepository.getPropertyById("prop_to_delete"))
    }

    @Test
    fun `deleting with empty ID returns failure`() = runTest {
        val result = deletePropertyUseCase("")
        assertTrue(result.isFailure)
    }
}
