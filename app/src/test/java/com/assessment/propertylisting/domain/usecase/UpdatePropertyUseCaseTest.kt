package com.assessment.propertylisting.domain.usecase

import com.assessment.propertylisting.domain.model.Property
import com.assessment.propertylisting.domain.model.PropertyStatus
import com.assessment.propertylisting.domain.model.PropertyType
import com.assessment.propertylisting.domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class UpdatePropertyUseCaseTest {

    private lateinit var updatePropertyUseCase: UpdatePropertyUseCase
    private lateinit var addPropertyUseCase: AddPropertyUseCase
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
        addPropertyUseCase = AddPropertyUseCase(fakePropertyRepository)
        updatePropertyUseCase = UpdatePropertyUseCase(fakePropertyRepository, addPropertyUseCase)

        fakePropertyRepository.properties.add(
            Property(
                id = "prop_101",
                propertyName = "Original Title",
                propertyType = PropertyType.APARTMENT,
                location = "Jaipur",
                price = 8500000.0,
                area = 1600,
                configuration = "3 BHK",
                status = PropertyStatus.AVAILABLE,
                description = "Original description",
                imageUrl = "",
                ownerId = "owner_01",
                ownerName = "Rajesh Sharma"
            )
        )
    }

    @Test
    fun `updating property modifies existing repository record`() = runTest {
        val updatedProperty = Property(
            id = "prop_101",
            propertyName = "Updated Luxury Residence",
            propertyType = PropertyType.APARTMENT,
            location = "Jaipur",
            price = 9000000.0,
            area = 1650,
            configuration = "3 BHK",
            status = PropertyStatus.SOLD,
            description = "Updated description with renovation details",
            imageUrl = "",
            ownerId = "owner_01",
            ownerName = "Rajesh Sharma"
        )

        val result = updatePropertyUseCase(updatedProperty)
        assertTrue(result.isSuccess)
        val stored = fakePropertyRepository.getPropertyById("prop_101")
        assertEquals("Updated Luxury Residence", stored?.propertyName)
        assertEquals(PropertyStatus.SOLD, stored?.status)
        assertEquals(9000000.0, stored?.price ?: 0.0, 0.01)
    }

    @Test
    fun `updating property with blank ID fails`() = runTest {
        val updatedProperty = Property(
            id = "",
            propertyName = "Invalid Update",
            propertyType = PropertyType.APARTMENT,
            location = "Jaipur",
            price = 9000000.0,
            area = 1650,
            configuration = "3 BHK",
            status = PropertyStatus.AVAILABLE,
            description = "Valid description",
            imageUrl = "",
            ownerId = "owner_01",
            ownerName = "Rajesh Sharma"
        )

        val result = updatePropertyUseCase(updatedProperty)
        assertTrue(result.isFailure)
    }
}
