package com.assessment.propertylisting.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.assessment.propertylisting.data.local.entity.PropertyEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for Room persistence of Real Estate Property records.
 * Provides reactive Flow streams for live database observing and suspend functions for CRUD operations.
 */
@Dao
interface PropertyDao {

    /**
     * Observes all property listings in the local database ordered by rowid descending.
     */
    @Query("SELECT * FROM properties")
    fun getAllProperties(): Flow<List<PropertyEntity>>

    /**
     * Retrieves a single property record by its unique identifier.
     */
    @Query("SELECT * FROM properties WHERE id = :id LIMIT 1")
    suspend fun getPropertyById(id: String): PropertyEntity?

    /**
     * Observes properties belonging strictly to a specific owner.
     */
    @Query("SELECT * FROM properties WHERE ownerId = :ownerId")
    fun getPropertiesByOwner(ownerId: String): Flow<List<PropertyEntity>>

    /**
     * Inserts a single property or replaces on conflict.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProperty(property: PropertyEntity)

    /**
     * Inserts a list of property records (used during initial database seeding).
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertProperties(properties: List<PropertyEntity>)

    /**
     * Updates an existing property record.
     */
    @Update
    suspend fun updateProperty(property: PropertyEntity)

    /**
     * Deletes a property record by its unique ID.
     */
    @Query("DELETE FROM properties WHERE id = :id")
    suspend fun deletePropertyById(id: String)

    /**
     * Returns total number of property records currently stored.
     */
    @Query("SELECT COUNT(*) FROM properties")
    suspend fun getCount(): Int
}
