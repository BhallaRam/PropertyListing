package com.assessment.propertylisting.domain.usecase

import com.assessment.propertylisting.domain.model.Property
import com.assessment.propertylisting.domain.model.PropertyFilter
import com.assessment.propertylisting.domain.model.PropertyStatus
import com.assessment.propertylisting.domain.model.PropertyType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class FilterPropertiesUseCaseTest {

    private lateinit var filterPropertiesUseCase: FilterPropertiesUseCase
    private lateinit var sampleProperties: List<Property>

    @Before
    fun setUp() {
        filterPropertiesUseCase = FilterPropertiesUseCase()
        sampleProperties = listOf(
            Property(
                id = "1",
                propertyName = "Royal Palms Villa",
                propertyType = PropertyType.VILLA,
                location = "Jaipur",
                price = 22000000.0, // 2.2 Cr
                area = 3500,
                configuration = "4 BHK",
                status = PropertyStatus.AVAILABLE,
                description = "Luxury villa in Civil Lines Jaipur",
                imageUrl = "",
                ownerId = "owner_1",
                ownerName = "Rajesh Sharma"
            ),
            Property(
                id = "2",
                propertyName = "Emerald Heights",
                propertyType = PropertyType.APARTMENT,
                location = "Jaipur",
                price = 8500000.0, // 85 Lac
                area = 1600,
                configuration = "3 BHK",
                status = PropertyStatus.AVAILABLE,
                description = "Modern apartment in Malviya Nagar",
                imageUrl = "",
                ownerId = "owner_1",
                ownerName = "Rajesh Sharma"
            ),
            Property(
                id = "3",
                propertyName = "Cyber Residency",
                propertyType = PropertyType.APARTMENT,
                location = "Bangalore",
                price = 12000000.0, // 1.2 Cr
                area = 1800,
                configuration = "3 BHK",
                status = PropertyStatus.RENTED,
                description = "Smart apartment in Whitefield",
                imageUrl = "",
                ownerId = "owner_2",
                ownerName = "Pooja Malhotra"
            ),
            Property(
                id = "4",
                propertyName = "Marwar Row House",
                propertyType = PropertyType.ROW_HOUSE,
                location = "Jodhpur",
                price = 6500000.0, // 65 Lac
                area = 1400,
                configuration = "2 BHK",
                status = PropertyStatus.SOLD,
                description = "Sandstone row house in Ratanada",
                imageUrl = "",
                ownerId = "owner_1",
                ownerName = "Rajesh Sharma"
            )
        )
    }

    @Test
    fun `when filter is empty, returns all properties`() {
        val filter = PropertyFilter()
        val result = filterPropertiesUseCase(sampleProperties, filter)
        assertEquals(4, result.size)
    }

    @Test
    fun `filter by location returns matching city only`() {
        val filter = PropertyFilter(location = "Jaipur")
        val result = filterPropertiesUseCase(sampleProperties, filter)
        assertEquals(2, result.size)
        assertTrue(result.all { it.location.equals("Jaipur", ignoreCase = true) })
    }

    @Test
    fun `filter by property type returns matching type only`() {
        val filter = PropertyFilter(propertyType = PropertyType.VILLA)
        val result = filterPropertiesUseCase(sampleProperties, filter)
        assertEquals(1, result.size)
        assertEquals("Royal Palms Villa", result.first().propertyName)
    }

    @Test
    fun `filter by price range returns properties within bounds`() {
        val filter = PropertyFilter(
            minimumPrice = 8000000.0,
            maximumPrice = 15000000.0
        )
        val result = filterPropertiesUseCase(sampleProperties, filter)
        assertEquals(2, result.size)
        assertTrue(result.all { it.price in 8000000.0..15000000.0 })
    }

    @Test
    fun `filter by area range returns properties within square feet bounds`() {
        val filter = PropertyFilter(
            minimumArea = 1500,
            maximumArea = 2000
        )
        val result = filterPropertiesUseCase(sampleProperties, filter)
        assertEquals(2, result.size)
        assertTrue(result.all { it.area in 1500..2000 })
    }

    @Test
    fun `filter by status returns matching status properties`() {
        val filter = PropertyFilter(status = PropertyStatus.AVAILABLE)
        val result = filterPropertiesUseCase(sampleProperties, filter)
        assertEquals(2, result.size)
        assertTrue(result.all { it.status == PropertyStatus.AVAILABLE })
    }

    @Test
    fun `filter by configuration returns matching room configuration`() {
        val filter = PropertyFilter(configuration = "3 BHK")
        val result = filterPropertiesUseCase(sampleProperties, filter)
        assertEquals(2, result.size)
        assertTrue(result.all { it.configuration == "3 BHK" })
    }

    @Test
    fun `search query matches title, city or description case-insensitively`() {
        val filter = PropertyFilter(searchQuery = "malviya")
        val result = filterPropertiesUseCase(sampleProperties, filter)
        assertEquals(1, result.size)
        assertEquals("Emerald Heights", result.first().propertyName)
    }

    @Test
    fun `combined multi-criteria filter works with AND conjunction`() {
        val filter = PropertyFilter(
            location = "Jaipur",
            propertyType = PropertyType.APARTMENT,
            configuration = "3 BHK",
            status = PropertyStatus.AVAILABLE,
            maximumPrice = 10000000.0
        )
        val result = filterPropertiesUseCase(sampleProperties, filter)
        assertEquals(1, result.size)
        assertEquals("Emerald Heights", result.first().propertyName)
    }

    @Test
    fun `when no properties match filter, returns empty list`() {
        val filter = PropertyFilter(
            location = "Mumbai", // Not in sampleProperties
            propertyType = PropertyType.VILLA
        )
        val result = filterPropertiesUseCase(sampleProperties, filter)
        assertTrue(result.isEmpty())
    }
}
