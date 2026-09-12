package com.assessment.propertylisting.domain.usecase

import com.assessment.propertylisting.domain.model.Property
import com.assessment.propertylisting.domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOwnerPropertiesUseCase @Inject constructor(
    private val propertyRepository: PropertyRepository
) {
    operator fun invoke(ownerId: String): Flow<List<Property>> {
        return propertyRepository.getPropertiesByOwner(ownerId)
    }
}
