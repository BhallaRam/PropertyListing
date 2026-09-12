package com.assessment.propertylisting.domain.model

enum class UserRole {
    USER,
    PROPERTY_OWNER;

    val displayName: String
        get() = when (this) {
            USER -> "User"
            PROPERTY_OWNER -> "Property Owner"
        }
}
