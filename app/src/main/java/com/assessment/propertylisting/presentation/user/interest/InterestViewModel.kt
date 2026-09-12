package com.assessment.propertylisting.presentation.user.interest

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.assessment.propertylisting.domain.usecase.GetPropertyByIdUseCase
import com.assessment.propertylisting.domain.usecase.SubmitInterestUseCase
import com.assessment.propertylisting.presentation.navigation.Routes
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InterestViewModel @Inject constructor(
    private val getPropertyByIdUseCase: GetPropertyByIdUseCase,
    private val submitInterestUseCase: SubmitInterestUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val propertyId: String = checkNotNull(savedStateHandle[Routes.InterestForm.ARG_PROPERTY_ID])

    private val _uiState = MutableStateFlow(InterestUiState())
    val uiState: StateFlow<InterestUiState> = _uiState.asStateFlow()

    init {
        loadProperty()
    }

    private fun loadProperty() {
        viewModelScope.launch {
            _uiState.update { it.copy(isLoading = true) }
            val property = getPropertyByIdUseCase(propertyId)
            if (property != null) {
                _uiState.update {
                    it.copy(
                        isLoading = false,
                        property = property,
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

    fun onNameChange(name: String) {
        _uiState.update { it.copy(userName = name, nameError = null) }
    }

    fun onMobileChange(mobile: String) {
        val clean = mobile.filter { it.isDigit() }.take(10)
        _uiState.update { it.copy(mobileNumber = clean, mobileError = null) }
    }

    fun onEmailChange(email: String) {
        _uiState.update { it.copy(email = email, emailError = null) }
    }

    fun onMessageChange(message: String) {
        _uiState.update { it.copy(message = message, messageError = null) }
    }

    fun submitInterest() {
        val state = _uiState.value
        val property = state.property ?: return

        if (state.isSubmitting) return // Prevent duplicate clicks

        val params = SubmitInterestUseCase.Params(
            propertyId = property.id,
            propertyName = property.propertyName,
            ownerId = property.ownerId,
            userName = state.userName,
            mobileNumber = state.mobileNumber,
            email = state.email,
            message = state.message
        )

        val validation = submitInterestUseCase.validate(params)
        if (validation is SubmitInterestUseCase.ValidationResult.Invalid) {
            _uiState.update {
                it.copy(
                    nameError = validation.nameError,
                    mobileError = validation.mobileError,
                    emailError = validation.emailError,
                    messageError = validation.messageError
                )
            }
            return
        }

        _uiState.update { it.copy(isSubmitting = true, errorMessage = null) }

        viewModelScope.launch {
            val result = submitInterestUseCase(params)
            result.onSuccess {
                _uiState.update {
                    it.copy(
                        isSubmitting = false,
                        isSubmittedSuccessfully = true,
                        errorMessage = null
                    )
                }
            }.onFailure { error ->
                _uiState.update {
                    it.copy(
                        isSubmitting = false,
                        errorMessage = error.message ?: "Failed to submit interest. Please try again."
                    )
                }
            }
        }
    }
}
