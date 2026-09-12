package com.assessment.propertylisting.domain.repository

import com.assessment.propertylisting.domain.model.Interest
import kotlinx.coroutines.flow.Flow

interface InterestRepository {
    suspend fun submitInterest(interest: Interest): Result<Unit>
    fun getInterestsByOwner(ownerId: String): Flow<List<Interest>>
    fun getInterestsByProperty(propertyId: String): Flow<List<Interest>>
}
