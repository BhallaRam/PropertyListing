package com.assessment.propertylisting.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.assessment.propertylisting.data.local.entity.InterestEntity
import kotlinx.coroutines.flow.Flow

/**
 * Data Access Object for Room persistence of buyer interest submissions.
 * Handles insert operations and owner-scoped inquiry queries.
 */
@Dao
interface InterestDao {

    /**
     * Inserts a new buyer interest inquiry record into Room.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertInterest(interest: InterestEntity)

    /**
     * Observes all inquiries submitted for properties owned by a specific ownerId.
     * Enforces strict data isolation so that owners only see inquiries for their own listings.
     */
    @Query("SELECT * FROM interests WHERE ownerId = :ownerId ORDER BY createdAt DESC")
    fun getInterestsForOwner(ownerId: String): Flow<List<InterestEntity>>

    /**
     * Observes inquiries submitted for a specific property listing.
     */
    @Query("SELECT * FROM interests WHERE propertyId = :propertyId ORDER BY createdAt DESC")
    fun getInterestsForProperty(propertyId: String): Flow<List<InterestEntity>>

    /**
     * Observes the count of inquiries received for a specific property listing.
     */
    @Query("SELECT COUNT(*) FROM interests WHERE propertyId = :propertyId")
    fun getInterestCountForProperty(propertyId: String): Flow<Int>
}
