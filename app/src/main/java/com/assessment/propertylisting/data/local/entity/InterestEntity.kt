package com.assessment.propertylisting.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "interests")
data class InterestEntity(
    @PrimaryKey
    val id: String,
    val propertyId: String,
    val propertyName: String,
    val ownerId: String,
    val userName: String,
    val mobileNumber: String,
    val email: String,
    val message: String,
    val createdAt: Long
)
