package com.assessment.propertylisting.presentation.user.interest

import com.assessment.propertylisting.domain.model.Property

data class InterestUiState(
    val isLoading: Boolean = true,
    val property: Property? = null,
    val userName: String = "Amit Verma",
    val nameError: String? = null,
    val mobileNumber: String = "9876543210",
    val mobileError: String? = null,
    val email: String = "user@test.com",
    val emailError: String? = null,
    val message: String = "Hi, I am interested in this property and would like to schedule a site visit.",
    val messageError: String? = null,
    val isSubmitting: Boolean = false,
    val isSubmittedSuccessfully: Boolean = false,
    val errorMessage: String? = null
)
