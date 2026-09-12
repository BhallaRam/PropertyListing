package com.assessment.propertylisting.presentation.user.propertydetail

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessment.propertylisting.domain.model.UserRole
import com.assessment.propertylisting.domain.repository.AuthRepository
import com.assessment.propertylisting.domain.usecase.GetPropertyByIdUseCase
import com.assessment.propertylisting.presentation.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel managing Property Detail state, retrieving property data by ID,
 * and checking current user session to determine owner vs buyer view.
 */
@HiltViewModel
class PropertyDetailViewModel @Inject constructor(
    private val getPropertyByIdUseCase: GetPropertyByIdUseCase,
    private val authRepository: AuthRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val propertyId: String = checkNotNull(savedStateHandle[Routes.PropertyDetail.ARG_PROPERTY_ID])

    private val _uiState = MutableStateFlow(PropertyDetailUiState())
    val uiState: StateFlow<PropertyDetailUiState> = _uiState.asStateFlow()

    init {
        loadProperty()
    }

    fun loadProperty() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }
            val currentUser = authRepository.getCurrentUser().firstOrNull()
            val isOwner = currentUser?.role == UserRole.PROPERTY_OWNER
            val property = getPropertyByIdUseCase(propertyId)

            if (property != null) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        property = property,
                        isOwnerView = isOwner || currentUser?.id == property.ownerId,
                        errorMessage = null
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
}
