package com.assessment.propertylisting.presentation.user.propertydetail

import com.assessment.propertylisting.domain.model.Property

/**
 * State representing the Property Detail screen.
 * Includes isOwnerView flag to conditionally show/hide buyer-specific actions like "Express Interest".
 */
data class PropertyDetailUiState(
    val isLoading: Boolean = true,
    val property: Property? = null,
    val isOwnerView: Boolean = false,
    val errorMessage: String? = null
)
