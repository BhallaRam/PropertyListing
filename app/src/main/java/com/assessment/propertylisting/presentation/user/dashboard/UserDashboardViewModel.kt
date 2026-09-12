package com.assessment.propertylisting.presentation.user.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessment.propertylisting.data.local.seed.DatabaseSeeder
import com.assessment.propertylisting.data.mapper.toDomain
import com.assessment.propertylisting.domain.model.PropertyFilter
import com.assessment.propertylisting.domain.model.PropertyType
import com.assessment.propertylisting.domain.repository.AuthRepository
import com.assessment.propertylisting.domain.repository.PropertyRepository
import com.assessment.propertylisting.domain.usecase.FilterPropertiesUseCase
import com.assessment.propertylisting.domain.usecase.GetPropertiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDashboardViewModel @Inject constructor(
    private val getPropertiesUseCase: GetPropertiesUseCase,
    private val filterPropertiesUseCase: FilterPropertiesUseCase,
    private val propertyRepository: PropertyRepository,
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _uiState = MutableStateFlow(UserDashboardUiState())
    val uiState: StateFlow<UserDashboardUiState> = _uiState.asStateFlow()

    init {
        ensureDatabaseSeededAndLoadProperties()
    }

    private fun ensureDatabaseSeededAndLoadProperties() {
        viewModelScope.launch {
            // Check if DB is empty; if so, populate initial seed properties
            if (propertyRepository.getPropertyCount() == 0) {
                propertyRepository.insertProperties(DatabaseSeeder.INITIAL_PROPERTIES.map { it.toDomain() })
            }

            getPropertiesUseCase()
                .catch { error ->
                    _uiState.update {
                        it.copy(
                            isLoading = false,
                            errorMessage = error.message ?: "Failed to load properties"
                        )
                    }
                }
                .collect { properties ->
                    _uiState.update { state ->
                        val filtered = filterPropertiesUseCase(properties, state.filter)
                        state.copy(
                            isLoading = false,
                            allProperties = properties,
                            filteredProperties = filtered,
                            errorMessage = null
                        )
                    }
                }
        }
    }

    fun onSearchQueryChange(query: String) {
        val updatedFilter = _uiState.value.filter.copy(searchQuery = query)
        applyNewFilter(updatedFilter)
    }

    fun onPropertyTypeQuickFilter(type: PropertyType?) {
        val updatedType = if (_uiState.value.filter.propertyType == type) null else type
        val updatedFilter = _uiState.value.filter.copy(propertyType = updatedType)
        applyNewFilter(updatedFilter)
    }

    fun onApplyFilter(filter: PropertyFilter) {
        applyNewFilter(filter)
    }

    fun onClearFilter() {
        val resetFilter = PropertyFilter()
        applyNewFilter(resetFilter)
    }

    private fun applyNewFilter(filter: PropertyFilter) {
        _uiState.update { state ->
            val filtered = filterPropertiesUseCase(state.allProperties, filter)
            state.copy(
                filter = filter,
                filteredProperties = filtered
            )
        }
    }

    fun logout(onLoggedOut: () -> Unit) {
        viewModelScope.launch {
            authRepository.logout()
            onLoggedOut()
        }
    }

    fun retry() {
        _uiState.update { it.copy(isLoading = true, errorMessage = null) }
        ensureDatabaseSeededAndLoadProperties()
    }
}
