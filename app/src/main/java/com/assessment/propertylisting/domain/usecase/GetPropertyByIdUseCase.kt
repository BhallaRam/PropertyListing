package com.assessment.propertylisting.domain.usecase

import com.assessment.propertylisting.domain.model.Property
import com.assessment.propertylisting.domain.repository.PropertyRepository
import javax.inject.Inject

class GetPropertyByIdUseCase @Inject constructor(
    private val propertyRepository: PropertyRepository
) {
    suspend operator fun invoke(id: String): Property? {
        return propertyRepository.getPropertyById(id)
    }
}
