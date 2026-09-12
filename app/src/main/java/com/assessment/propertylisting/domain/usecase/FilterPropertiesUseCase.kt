package com.assessment.propertylisting.domain.usecase

import com.assessment.propertylisting.domain.model.Property
import com.assessment.propertylisting.domain.model.PropertyFilter
import javax.inject.Inject

class FilterPropertiesUseCase @Inject constructor() {

    operator fun invoke(properties: List<Property>, filter: PropertyFilter): List<Property> {
        return properties.filter { property ->
            // Search Query Filter
            val matchesQuery = if (filter.searchQuery.isBlank()) {
                true
            } else {
                val query = filter.searchQuery.trim().lowercase()
                property.propertyName.lowercase().contains(query) ||
                        property.location.lowercase().contains(query) ||
                        property.configuration.lowercase().contains(query) ||
                        property.description.lowercase().contains(query)
            }

            // Location Filter
            val matchesLocation = if (filter.location.isNullOrBlank()) {
                true
            } else {
                property.location.equals(filter.location.trim(), ignoreCase = true)
            }

            // Property Type Filter
            val matchesType = if (filter.propertyType == null) {
                true
            } else {
                property.propertyType == filter.propertyType
            }

            // Price Range Filter
            val matchesMinPrice = filter.minimumPrice?.let { property.price >= it } ?: true
            val matchesMaxPrice = filter.maximumPrice?.let { property.price <= it } ?: true

            // Area Range Filter
            val matchesMinArea = filter.minimumArea?.let { property.area >= it } ?: true
            val matchesMaxArea = filter.maximumArea?.let { property.area <= it } ?: true

            // Status Filter
            val matchesStatus = if (filter.status == null) {
                true
            } else {
                property.status == filter.status
            }

            // Configuration Filter
            val matchesConfig = if (filter.configuration.isNullOrBlank()) {
                true
            } else {
                property.configuration.equals(filter.configuration.trim(), ignoreCase = true)
            }

            matchesQuery &&
                    matchesLocation &&
                    matchesType &&
                    matchesMinPrice &&
                    matchesMaxPrice &&
                    matchesMinArea &&
                    matchesMaxArea &&
                    matchesStatus &&
                    matchesConfig
        }
    }
}
