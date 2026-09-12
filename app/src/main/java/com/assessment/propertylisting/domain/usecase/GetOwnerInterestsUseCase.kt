package com.assessment.propertylisting.domain.usecase

import com.assessment.propertylisting.domain.model.Interest
import com.assessment.propertylisting.domain.repository.InterestRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetOwnerInterestsUseCase @Inject constructor(
    private val interestRepository: InterestRepository
) {
    operator fun invoke(ownerId: String): Flow<List<Interest>> {
        return interestRepository.getInterestsByOwner(ownerId)
    }
}
