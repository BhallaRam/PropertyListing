package com.assessment.propertylisting.domain.repository

import com.assessment.propertylisting.domain.model.Property
import kotlinx.coroutines.flow.Flow

/**
 * Repository interface defining property data operations.
 * Implemented in the data layer to decouple domain logic from Room persistence.
 */
interface PropertyRepository {
    /**
     * Observes all property listings as a reactive Flow stream.
     */
    fun getAllProperties(): Flow<List<Property>>

    /**
     * Fetches a single property by its unique ID.
     */
    suspend fun getPropertyById(id: String): Property?

    /**
     * Observes properties belonging to a specific ownerId.
     */
    fun getPropertiesByOwner(ownerId: String): Flow<List<Property>>

    /**
     * Saves a single property record (create).
     */
    suspend fun saveProperty(property: Property): Result<Unit>

    /**
     * Updates an existing property record.
     */
    suspend fun updateProperty(property: Property): Result<Unit>

    /**
     * Deletes a property record by ID.
     */
    suspend fun deleteProperty(id: String): Result<Unit>

    /**
     * Inserts a list of properties (used during initial database seeding).
     */
    suspend fun insertProperties(properties: List<Property>)

    /**
     * Returns total count of properties in the local database.
     */
    suspend fun getPropertyCount(): Int
}
