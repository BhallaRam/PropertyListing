package com.assessment.propertylisting.domain.model

data class PropertyFilter(
    val searchQuery: String = "",
    val location: String? = null,
    val propertyType: PropertyType? = null,
    val minimumPrice: Double? = null,
    val maximumPrice: Double? = null,
    val minimumArea: Int? = null,
    val maximumArea: Int? = null,
    val status: PropertyStatus? = null,
    val configuration: String? = null
) {
    val isActive: Boolean
        get() = searchQuery.isNotBlank() ||
                !location.isNullOrBlank() ||
                propertyType != null ||
                minimumPrice != null ||
                maximumPrice != null ||
                minimumArea != null ||
                maximumArea != null ||
                status != null ||
                !configuration.isNullOrBlank()

    val activeFilterCount: Int
        get() {
            var count = 0
            if (searchQuery.isNotBlank()) count++
            if (!location.isNullOrBlank()) count++
            if (propertyType != null) count++
            if (minimumPrice != null || maximumPrice != null) count++
            if (minimumArea != null || maximumArea != null) count++
            if (status != null) count++
            if (!configuration.isNullOrBlank()) count++
            return count
        }
}
