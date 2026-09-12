package com.assessment.propertylisting.presentation.owner.dashboard

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessment.propertylisting.domain.repository.AuthRepository
import com.assessment.propertylisting.domain.usecase.DeletePropertyUseCase
import com.assessment.propertylisting.domain.usecase.GetOwnerInterestsUseCase
import com.assessment.propertylisting.domain.usecase.GetOwnerPropertiesUseCase
import com.assessment.propertylisting.presentation.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * ViewModel for Owner Portal combining owner properties, received inquiries, and deletion operations.
 */
@HiltViewModel
class OwnerDashboardViewModel @Inject constructor(
    private val getOwnerPropertiesUseCase: GetOwnerPropertiesUseCase,
    private val getOwnerInterestsUseCase: GetOwnerInterestsUseCase,
    private val deletePropertyUseCase: DeletePropertyUseCase,
    private val authRepository: AuthRepository,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    val ownerId: String = savedStateHandle.get<String>(Routes.OwnerDashboard.ARG_OWNER_ID) ?: "owner_01"

    private val _uiState = MutableStateFlow(
        OwnerDashboardUiState(
            ownerId = ownerId,
            ownerName = if (ownerId == "owner_02") "Pooja Malhotra" else "Rajesh Sharma"
        )
    )
    val uiState: StateFlow<OwnerDashboardUiState> = _uiState.asStateFlow()

    init {
        loadOwnerData()
    }

    private fun loadOwnerData() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true, errorMessage = null) }

            combine(
                getOwnerPropertiesUseCase(ownerId),
                getOwnerInterestsUseCase(ownerId)
            ) { properties, interests ->
                properties to interests
            }.catch { error ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        errorMessage = error.message ?: "Failed to load dashboard data"
                    )
                }
            }.collect { (properties, interests) ->
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        properties = properties,
                        interests = interests,
                        ownerName = properties.firstOrNull()?.ownerName ?: it.ownerName,
                        errorMessage = null
                    )
                }
            }
        }
    }

    fun deleteProperty(propertyId: String) {
        viewModelScope.launch {
            deletePropertyUseCase(propertyId)
        }
    }

    fun onSelectTab(tabIndex: Int) {
        _uiState.update { it.copy(selectedTab = tabIndex) }
    }

    fun logout(onLoggedOut: () -> Unit) {
        viewModelScope.launch {
            authRepository.logout()
            onLoggedOut()
        }
    }

    fun retry() {
        loadOwnerData()
    }
}
