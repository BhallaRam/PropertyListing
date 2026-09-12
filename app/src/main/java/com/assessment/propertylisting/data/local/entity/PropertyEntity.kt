package com.assessment.propertylisting.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "properties")
data class PropertyEntity(
    @PrimaryKey
    val id: String,
    val propertyName: String,
    val propertyType: String,
    val location: String,
    val price: Double,
    val area: Int,
    val configuration: String,
    val status: String,
    val description: String,
    val imageUrl: String,
    val ownerId: String,
    val ownerName: String
)
