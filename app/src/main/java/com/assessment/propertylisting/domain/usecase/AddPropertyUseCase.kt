package com.assessment.propertylisting.domain.usecase

import com.assessment.propertylisting.domain.model.Property
import com.assessment.propertylisting.domain.repository.PropertyRepository
import java.util.UUID
import javax.inject.Inject

/**
 * Use case to validate and persist a new property listing created by an owner.
 */
class AddPropertyUseCase @Inject constructor(
    private val propertyRepository: PropertyRepository
) {

    data class ValidationResult(
        val nameError: String? = null,
        val locationError: String? = null,
        val priceError: String? = null,
        val areaError: String? = null,
        val descriptionError: String? = null
    ) {
        val isValid: Boolean
            get() = nameError == null && locationError == null && priceError == null && areaError == null && descriptionError == null
    }

    fun validate(property: Property): ValidationResult {
        var nameError: String? = null
        var locationError: String? = null
        var priceError: String? = null
        var areaError: String? = null
        var descriptionError: String? = null

        if (property.propertyName.isBlank()) {
            nameError = "Property name is required"
        }
        if (property.location.isBlank()) {
            locationError = "Location / City is required"
        }
        if (property.price <= 0) {
            priceError = "Please enter a valid price greater than 0"
        }
        if (property.area <= 0) {
            areaError = "Please enter a valid carpet area in sq.ft"
        }
        if (property.description.isBlank()) {
            descriptionError = "Property description is required"
        }

        return ValidationResult(
            nameError = nameError,
            locationError = locationError,
            priceError = priceError,
            areaError = areaError,
            descriptionError = descriptionError
        )
    }

    suspend operator fun invoke(property: Property): Result<Property> {
        val validation = validate(property)
        if (!validation.isValid) {
            val errorMsg = validation.nameError
                ?: validation.locationError
                ?: validation.priceError
                ?: validation.areaError
                ?: validation.descriptionError
                ?: "Invalid input"
            return Result.failure(IllegalArgumentException(errorMsg))
        }

        val propertyWithId = if (property.id.isBlank()) {
            property.copy(id = "prop_${UUID.randomUUID().toString().take(8)}")
        } else {
            property
        }

        return propertyRepository.saveProperty(propertyWithId).map { propertyWithId }
    }
}
