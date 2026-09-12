package com.assessment.propertylisting.domain.usecase

import com.assessment.propertylisting.domain.repository.PropertyRepository
import javax.inject.Inject

/**
 * Use case to delete a property listing from the local database.
 */
class DeletePropertyUseCase @Inject constructor(
    private val propertyRepository: PropertyRepository
) {
    suspend operator fun invoke(propertyId: String): Result<Unit> {
        if (propertyId.isBlank()) {
            return Result.failure(IllegalArgumentException("Property ID cannot be empty"))
        }
        return propertyRepository.deleteProperty(propertyId)
    }
}
