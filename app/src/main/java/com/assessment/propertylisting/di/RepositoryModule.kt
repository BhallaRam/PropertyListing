package com.assessment.propertylisting.di

import com.assessment.propertylisting.data.repository.AuthRepositoryImpl
import com.assessment.propertylisting.data.repository.InterestRepositoryImpl
import com.assessment.propertylisting.data.repository.PropertyRepositoryImpl
import com.assessment.propertylisting.domain.repository.AuthRepository
import com.assessment.propertylisting.domain.repository.InterestRepository
import com.assessment.propertylisting.domain.repository.PropertyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindPropertyRepository(
        impl: PropertyRepositoryImpl
    ): PropertyRepository

    @Binds
    @Singleton
    abstract fun bindInterestRepository(
        impl: InterestRepositoryImpl
    ): InterestRepository

    @Binds
    @Singleton
    abstract fun bindAuthRepository(
        impl: AuthRepositoryImpl
    ): AuthRepository
}
