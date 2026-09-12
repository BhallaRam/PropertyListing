package com.assessment.propertylisting.domain.model

enum class PropertyStatus {
    AVAILABLE,
    SOLD,
    RENTED;

    val displayName: String
        get() = when (this) {
            AVAILABLE -> "Available"
            SOLD -> "Sold"
            RENTED -> "Rented"
        }
}
