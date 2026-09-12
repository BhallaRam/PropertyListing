package com.assessment.propertylisting.domain.usecase

import com.assessment.propertylisting.domain.model.Interest
import com.assessment.propertylisting.domain.repository.InterestRepository
import java.util.UUID
import java.util.regex.Pattern
import javax.inject.Inject

class SubmitInterestUseCase @Inject constructor(
    private val interestRepository: InterestRepository
) {

    data class Params(
        val propertyId: String,
        val propertyName: String,
        val ownerId: String,
        val userName: String,
        val mobileNumber: String,
        val email: String,
        val message: String
    )

    sealed class ValidationResult {
        object Valid : ValidationResult()
        data class Invalid(
            val nameError: String? = null,
            val mobileError: String? = null,
            val emailError: String? = null,
            val messageError: String? = null
        ) : ValidationResult()
    }

    private val emailPattern: Pattern = Pattern.compile(
        "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$"
    )

    fun validate(params: Params): ValidationResult {
        var nameError: String? = null
        var mobileError: String? = null
        var emailError: String? = null
        var messageError: String? = null

        val cleanName = params.userName.trim()
        if (cleanName.isBlank()) {
            nameError = "Full name is required"
        } else if (cleanName.length < 2) {
            nameError = "Name must be at least 2 characters"
        }

        val cleanMobile = params.mobileNumber.trim().replace(Regex("[^0-9]"), "")
        if (cleanMobile.isBlank()) {
            mobileError = "Mobile number is required"
        } else if (cleanMobile.length != 10) {
            mobileError = "Please enter a valid 10-digit mobile number"
        }

        val cleanEmail = params.email.trim()
        if (cleanEmail.isBlank()) {
            emailError = "Email ID is required"
        } else if (!emailPattern.matcher(cleanEmail).matches()) {
            emailError = "Please enter a valid email address"
        }

        val cleanMessage = params.message.trim()
        if (cleanMessage.isBlank()) {
            messageError = "Please enter your message or inquiry note"
        } else if (cleanMessage.length < 5) {
            messageError = "Message must be at least 5 characters"
        }

        return if (nameError == null && mobileError == null && emailError == null && messageError == null) {
            ValidationResult.Valid
        } else {
            ValidationResult.Invalid(nameError, mobileError, emailError, messageError)
        }
    }

    suspend operator fun invoke(params: Params): Result<Interest> {
        val validation = validate(params)
        if (validation is ValidationResult.Invalid) {
            val firstError = validation.nameError
                ?: validation.mobileError
                ?: validation.emailError
                ?: validation.messageError
                ?: "Invalid input"
            return Result.failure(IllegalArgumentException(firstError))
        }

        val interest = Interest(
            id = UUID.randomUUID().toString(),
            propertyId = params.propertyId,
            propertyName = params.propertyName,
            ownerId = params.ownerId,
            userName = params.userName.trim(),
            mobileNumber = params.mobileNumber.trim().replace(Regex("[^0-9]"), ""),
            email = params.email.trim(),
            message = params.message.trim(),
            createdAt = System.currentTimeMillis()
        )

        return interestRepository.submitInterest(interest).map { interest }
    }
}
