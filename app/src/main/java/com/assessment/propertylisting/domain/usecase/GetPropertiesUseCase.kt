package com.assessment.propertylisting.domain.usecase

import com.assessment.propertylisting.domain.model.Property
import com.assessment.propertylisting.domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetPropertiesUseCase @Inject constructor(
    private val propertyRepository: PropertyRepository
) {
    operator fun invoke(): Flow<List<Property>> {
        return propertyRepository.getAllProperties()
    }
}
