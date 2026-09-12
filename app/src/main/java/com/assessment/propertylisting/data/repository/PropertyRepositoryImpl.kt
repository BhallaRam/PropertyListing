package com.assessment.propertylisting.data.repository

import com.assessment.propertylisting.data.local.dao.PropertyDao
import com.assessment.propertylisting.data.mapper.toDomain
import com.assessment.propertylisting.data.mapper.toEntity
import com.assessment.propertylisting.domain.model.Property
import com.assessment.propertylisting.domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Concrete implementation of PropertyRepository communicating with Room PropertyDao.
 */
@Singleton
class PropertyRepositoryImpl @Inject constructor(
    private val propertyDao: PropertyDao
) : PropertyRepository {

    override fun getAllProperties(): Flow<List<Property>> {
        return propertyDao.getAllProperties().map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun getPropertyById(id: String): Property? {
        return propertyDao.getPropertyById(id)?.toDomain()
    }

    override fun getPropertiesByOwner(ownerId: String): Flow<List<Property>> {
        return propertyDao.getPropertiesByOwner(ownerId).map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override suspend fun saveProperty(property: Property): Result<Unit> {
        return runCatching {
            propertyDao.insertProperty(property.toEntity())
        }
    }

    override suspend fun updateProperty(property: Property): Result<Unit> {
        return runCatching {
            propertyDao.updateProperty(property.toEntity())
        }
    }

    override suspend fun deleteProperty(id: String): Result<Unit> {
        return runCatching {
            propertyDao.deletePropertyById(id)
        }
    }

    override suspend fun insertProperties(properties: List<Property>) {
        propertyDao.insertProperties(properties.map { it.toEntity() })
    }

    override suspend fun getPropertyCount(): Int {
        return propertyDao.getCount()
    }
}
