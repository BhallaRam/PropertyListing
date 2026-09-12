package com.assessment.propertylisting.presentation.owner.dashboard

import com.assessment.propertylisting.domain.model.Interest
import com.assessment.propertylisting.domain.model.Property

data class OwnerDashboardUiState(
    val isLoading: Boolean = true,
    val ownerId: String = "",
    val ownerName: String = "",
    val properties: List<Property> = emptyList(),
    val interests: List<Interest> = emptyList(),
    val selectedTab: Int = 0, // 0: My Properties, 1: Received Inquiries
    val errorMessage: String? = null
) {
    val totalInquiries: Int
        get() = interests.size

    val propertyInterestCounts: Map<String, Int>
        get() = interests.groupingBy { it.propertyId }.eachCount()
}
