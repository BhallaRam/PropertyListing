package com.assessment.propertylisting.domain.model

enum class PropertyType {
    APARTMENT,
    VILLA,
    ROW_HOUSE;

    val displayName: String
        get() = when (this) {
            APARTMENT -> "Apartment"
            VILLA -> "Villa"
            ROW_HOUSE -> "Row House"
        }
}
