package com.assessment.propertylisting.domain.usecase

import com.assessment.propertylisting.domain.model.Property
import com.assessment.propertylisting.domain.repository.PropertyRepository
import javax.inject.Inject

/**
 * Use case to validate and update an existing property listing.
 */
class UpdatePropertyUseCase @Inject constructor(
    private val propertyRepository: PropertyRepository,
    private val addPropertyUseCase: AddPropertyUseCase
) {

    suspend operator fun invoke(property: Property): Result<Unit> {
        if (property.id.isBlank()) {
            return Result.failure(IllegalArgumentException("Property ID cannot be empty for update"))
        }

        val validation = addPropertyUseCase.validate(property)
        if (!validation.isValid) {
            val errorMsg = validation.nameError
                ?: validation.locationError
                ?: validation.priceError
                ?: validation.areaError
                ?: validation.descriptionError
                ?: "Invalid input"
            return Result.failure(IllegalArgumentException(errorMsg))
        }

        return propertyRepository.updateProperty(property)
    }
}
