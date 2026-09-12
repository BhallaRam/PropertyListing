package com.assessment.propertylisting.domain.usecase

import com.assessment.propertylisting.domain.model.Property
import com.assessment.propertylisting.domain.model.PropertyStatus
import com.assessment.propertylisting.domain.model.PropertyType
import com.assessment.propertylisting.domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class AddPropertyUseCaseTest {

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
    }

    @Test
    fun `validate with blank property name returns nameError`() {
        val property = Property(
            id = "",
            propertyName = "",
            propertyType = PropertyType.APARTMENT,
            location = "Jaipur",
            price = 5000000.0,
            area = 1200,
            configuration = "2 BHK",
            status = PropertyStatus.AVAILABLE,
            description = "Good apartment",
            imageUrl = "",
            ownerId = "owner_01",
            ownerName = "Rajesh Sharma"
        )
        val validation = addPropertyUseCase.validate(property)
        assertNotNull(validation.nameError)
    }

    @Test
    fun `validate with invalid zero price returns priceError`() {
        val property = Property(
            id = "",
            propertyName = "Sunrise Apartment",
            propertyType = PropertyType.APARTMENT,
            location = "Jaipur",
            price = 0.0,
            area = 1200,
            configuration = "2 BHK",
            status = PropertyStatus.AVAILABLE,
            description = "Good apartment",
            imageUrl = "",
            ownerId = "owner_01",
            ownerName = "Rajesh Sharma"
        )
        val validation = addPropertyUseCase.validate(property)
        assertNotNull(validation.priceError)
    }

    @Test
    fun `valid property is saved successfully into repository`() = runTest {
        val property = Property(
            id = "",
            propertyName = "Sunrise Villa",
            propertyType = PropertyType.VILLA,
            location = "Jaipur",
            price = 15000000.0,
            area = 2500,
            configuration = "4 BHK",
            status = PropertyStatus.AVAILABLE,
            description = "Spacious modern villa",
            imageUrl = "http://example.com/image.jpg",
            ownerId = "owner_01",
            ownerName = "Rajesh Sharma"
        )

        val result = addPropertyUseCase(property)
        assertTrue(result.isSuccess)
        assertEquals(1, fakePropertyRepository.properties.size)
        assertTrue(fakePropertyRepository.properties.first().id.startsWith("prop_"))
    }
}
