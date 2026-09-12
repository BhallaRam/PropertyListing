package com.assessment.propertylisting.presentation.user.dashboard

import com.assessment.propertylisting.domain.model.Property
import com.assessment.propertylisting.domain.model.PropertyFilter

data class UserDashboardUiState(
    val isLoading: Boolean = true,
    val allProperties: List<Property> = emptyList(),
    val filteredProperties: List<Property> = emptyList(),
    val filter: PropertyFilter = PropertyFilter(),
    val errorMessage: String? = null
)
