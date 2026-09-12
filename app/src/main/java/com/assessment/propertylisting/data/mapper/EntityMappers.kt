package com.assessment.propertylisting.data.mapper

import com.assessment.propertylisting.data.local.entity.InterestEntity
import com.assessment.propertylisting.data.local.entity.PropertyEntity
import com.assessment.propertylisting.domain.model.Interest
import com.assessment.propertylisting.domain.model.Property
import com.assessment.propertylisting.domain.model.PropertyStatus
import com.assessment.propertylisting.domain.model.PropertyType

fun PropertyEntity.toDomain(): Property {
    return Property(
        id = id,
        propertyName = propertyName,
        propertyType = runCatching { PropertyType.valueOf(propertyType) }.getOrDefault(PropertyType.APARTMENT),
        location = location,
        price = price,
        area = area,
        configuration = configuration,
        status = runCatching { PropertyStatus.valueOf(status) }.getOrDefault(PropertyStatus.AVAILABLE),
        description = description,
        imageUrl = imageUrl,
        ownerId = ownerId,
        ownerName = ownerName
    )
}

fun Property.toEntity(): PropertyEntity {
    return PropertyEntity(
        id = id,
        propertyName = propertyName,
        propertyType = propertyType.name,
        location = location,
        price = price,
        area = area,
        configuration = configuration,
        status = status.name,
        description = description,
        imageUrl = imageUrl,
        ownerId = ownerId,
        ownerName = ownerName
    )
}

fun InterestEntity.toDomain(): Interest {
    return Interest(
        id = id,
        propertyId = propertyId,
        propertyName = propertyName,
        ownerId = ownerId,
        userName = userName,
        mobileNumber = mobileNumber,
        email = email,
        message = message,
        createdAt = createdAt
    )
}

fun Interest.toEntity(): InterestEntity {
    return InterestEntity(
        id = id,
        propertyId = propertyId,
        propertyName = propertyName,
        ownerId = ownerId,
        userName = userName,
        mobileNumber = mobileNumber,
        email = email,
        message = message,
        createdAt = createdAt
    )
}
