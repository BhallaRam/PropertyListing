package com.assessment.propertylisting.domain.model

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

data class Interest(
    val id: String,
    val propertyId: String,
    val propertyName: String,
    val ownerId: String,
    val userName: String,
    val mobileNumber: String,
    val email: String,
    val message: String,
    val createdAt: Long = System.currentTimeMillis()
) {
    val formattedDate: String
        get() {
            val sdf = SimpleDateFormat("dd MMM yyyy, hh:mm a", Locale.getDefault())
            return sdf.format(Date(createdAt))
        }
}
