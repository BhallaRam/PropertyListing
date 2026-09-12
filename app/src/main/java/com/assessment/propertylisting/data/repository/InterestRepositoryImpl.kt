package com.assessment.propertylisting.data.repository

import com.assessment.propertylisting.data.local.dao.InterestDao
import com.assessment.propertylisting.data.mapper.toDomain
import com.assessment.propertylisting.data.mapper.toEntity
import com.assessment.propertylisting.domain.model.Interest
import com.assessment.propertylisting.domain.repository.InterestRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InterestRepositoryImpl @Inject constructor(
    private val interestDao: InterestDao
) : InterestRepository {

    override suspend fun submitInterest(interest: Interest): Result<Unit> {
        return runCatching {
            interestDao.insertInterest(interest.toEntity())
        }
    }

    override fun getInterestsByOwner(ownerId: String): Flow<List<Interest>> {
        return interestDao.getInterestsForOwner(ownerId).map { entities ->
            entities.map { it.toDomain() }
        }
    }

    override fun getInterestsByProperty(propertyId: String): Flow<List<Interest>> {
        return interestDao.getInterestsForProperty(propertyId).map { entities ->
            entities.map { it.toDomain() }
        }
    }
}
