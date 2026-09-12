package com.assessment.propertylisting.presentation.owner.addedit

import com.assessment.propertylisting.domain.model.PropertyStatus
import com.assessment.propertylisting.domain.model.PropertyType

/**
 * State representing the Add / Edit Property form.
 */
data class AddEditPropertyUiState(
    val isEditMode: Boolean = false,
    val propertyId: String = "",
    val ownerId: String = "",
    val ownerName: String = "",
    val propertyName: String = "",
    val nameError: String? = null,
    val propertyType: PropertyType = PropertyType.APARTMENT,
    val location: String = "Jaipur",
    val locationError: String? = null,
    val priceInput: String = "8500000",
    val priceError: String? = null,
    val areaInput: String = "1650",
    val areaError: String? = null,
    val configuration: String = "3 BHK",
    val status: PropertyStatus = PropertyStatus.AVAILABLE,
    val description: String = "Luxury modern property equipped with premium fixtures, modular fittings, and scenic views.",
    val descriptionError: String? = null,
    val imageUrl: String = "https://images.unsplash.com/photo-1545324418-cc1a3fa10c00?auto=format&fit=crop&w=1000&q=80",
    val isLoading: Boolean = false,
    val isSaving: Boolean = false,
    val isSavedSuccessfully: Boolean = false,
    val errorMessage: String? = null
)
