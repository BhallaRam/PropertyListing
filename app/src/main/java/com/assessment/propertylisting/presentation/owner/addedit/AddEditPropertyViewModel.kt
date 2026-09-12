package com.assessment.propertylisting.presentation.owner.addedit

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessment.propertylisting.domain.model.Property
import com.assessment.propertylisting.domain.model.PropertyStatus
import com.assessment.propertylisting.domain.model.PropertyType
import com.assessment.propertylisting.domain.usecase.AddPropertyUseCase
import com.assessment.propertylisting.domain.usecase.GetPropertyByIdUseCase
import com.assessment.propertylisting.domain.usecase.UpdatePropertyUseCase
import com.assessment.propertylisting.presentation.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel managing property creation and editing state for property owners.
 */
@HiltViewModel
class AddEditPropertyViewModel @Inject constructor(
    private val addPropertyUseCase: AddPropertyUseCase,
    private val updatePropertyUseCase: UpdatePropertyUseCase,
    private val getPropertyByIdUseCase: GetPropertyByIdUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val ownerId: String = savedStateHandle.get<String>(Routes.AddEditProperty.ARG_OWNER_ID) ?: "owner_01"
    private val propertyId: String? = savedStateHandle.get<String>(Routes.AddEditProperty.ARG_PROPERTY_ID)

    private val _uiState = MutableStateFlow(
        AddEditPropertyUiState(
            ownerId = ownerId,
            ownerName = if (ownerId == "owner_02") "Pooja Malhotra" else "Rajesh Sharma",
            isEditMode = !propertyId.isNullOrBlank(),
            propertyId = propertyId ?: ""
        )
    )
    val uiState: StateFlow<AddEditPropertyUiState> = _uiState.asStateFlow()

    init {
        if (!propertyId.isNullOrBlank()) {
            loadExistingProperty(propertyId)
        }
    }

    private fun loadExistingProperty(id: String) {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val property = getPropertyByIdUseCase(id)
            if (property != null) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        propertyName = property.propertyName,
                        propertyType = property.propertyType,
                        location = property.location,
                        priceInput = property.price.toLong().toString(),
                        areaInput = property.area.toString(),
                        configuration = property.configuration,
                        status = property.status,
                        description = property.description,
                        imageUrl = property.imageUrl,
                        ownerId = property.ownerId,
                        ownerName = property.ownerName
                    )
                }
            } else {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = "Property not found"
                    )
                }
            }
        }
    }

    fun onPropertyNameChange(name: String) {
        _uiState.update { it.copy(propertyName = name, nameError = null) }
    }

    fun onPropertyTypeChange(type: PropertyType) {
        _uiState.update { it.copy(propertyType = type) }
    }

    fun onLocationChange(location: String) {
        _uiState.update { it.copy(location = location, locationError = null) }
    }

    fun onPriceChange(price: String) {
        val clean = price.filter { it.isDigit() }
        _uiState.update { it.copy(priceInput = clean, priceError = null) }
    }

    fun onAreaChange(area: String) {
        val clean = area.filter { it.isDigit() }
        _uiState.update { it.copy(areaInput = clean, areaError = null) }
    }

    fun onConfigurationChange(config: String) {
        _uiState.update { it.copy(configuration = config) }
    }

    fun onStatusChange(status: PropertyStatus) {
        _uiState.update { it.copy(status = status) }
    }

    fun onDescriptionChange(desc: String) {
        _uiState.update { it.copy(description = desc, descriptionError = null) }
    }

    fun onImageUrlChange(url: String) {
        _uiState.update { it.copy(imageUrl = url) }
    }

    fun saveProperty() {
        val state = _uiState.value
        val price = state.priceInput.toDoubleOrNull() ?: 0.0
        val area = state.areaInput.toIntOrNull() ?: 0

        val property = Property(
            id = state.propertyId,
            propertyName = state.propertyName.trim(),
            propertyType = state.propertyType,
            location = state.location.trim(),
            price = price,
            area = area,
            configuration = state.configuration.trim(),
            status = state.status,
            description = state.description.trim(),
            imageUrl = state.imageUrl.trim(),
            ownerId = state.ownerId,
            ownerName = state.ownerName
        )

        val validation = addPropertyUseCase.validate(property)
        if (!validation.isValid) {
            _uiState.update {
                it.copy(
                    nameError = validation.nameError,
                    locationError = validation.locationError,
                    priceError = validation.priceError,
                    areaError = validation.areaError,
                    descriptionError = validation.descriptionError
                )
            }
            return
        }

        _uiState.update { it.copy(isSaving = true, errorMessage = null) }

        viewModelScope.launch {
            val result = if (state.isEditMode) {
                updatePropertyUseCase(property)
            } else {
                addPropertyUseCase(property).map { Unit }
            }

            result.onSuccess {
                _uiState.update {
                    it.copy(
                        isSaving = false,
                        isSavedSuccessfully = true,
                        errorMessage = null
                    )
                }
            }.onFailure { error ->
                _uiState.update {
                    it.copy(
                        isSaving = false,
                        errorMessage = error.message ?: "Failed to save property. Please try again."
                    )
                }
            }
        }
    }
}
