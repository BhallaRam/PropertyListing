package com.assessment.propertylisting.presentation.owner.dashboard;

import androidx.lifecycle.SavedStateHandle;
import com.assessment.propertylisting.domain.repository.AuthRepository;
import com.assessment.propertylisting.domain.usecase.DeletePropertyUseCase;
import com.assessment.propertylisting.domain.usecase.GetOwnerInterestsUseCase;
import com.assessment.propertylisting.domain.usecase.GetOwnerPropertiesUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast"
})
public final class OwnerDashboardViewModel_Factory implements Factory<OwnerDashboardViewModel> {
  private final Provider<GetOwnerPropertiesUseCase> getOwnerPropertiesUseCaseProvider;

  private final Provider<GetOwnerInterestsUseCase> getOwnerInterestsUseCaseProvider;

  private final Provider<DeletePropertyUseCase> deletePropertyUseCaseProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public OwnerDashboardViewModel_Factory(
      Provider<GetOwnerPropertiesUseCase> getOwnerPropertiesUseCaseProvider,
      Provider<GetOwnerInterestsUseCase> getOwnerInterestsUseCaseProvider,
      Provider<DeletePropertyUseCase> deletePropertyUseCaseProvider,
      Provider<AuthRepository> authRepositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.getOwnerPropertiesUseCaseProvider = getOwnerPropertiesUseCaseProvider;
    this.getOwnerInterestsUseCaseProvider = getOwnerInterestsUseCaseProvider;
    this.deletePropertyUseCaseProvider = deletePropertyUseCaseProvider;
    this.authRepositoryProvider = authRepositoryProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public OwnerDashboardViewModel get() {
    return newInstance(getOwnerPropertiesUseCaseProvider.get(), getOwnerInterestsUseCaseProvider.get(), deletePropertyUseCaseProvider.get(), authRepositoryProvider.get(), savedStateHandleProvider.get());
  }

  public static OwnerDashboardViewModel_Factory create(
      Provider<GetOwnerPropertiesUseCase> getOwnerPropertiesUseCaseProvider,
      Provider<GetOwnerInterestsUseCase> getOwnerInterestsUseCaseProvider,
      Provider<DeletePropertyUseCase> deletePropertyUseCaseProvider,
      Provider<AuthRepository> authRepositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new OwnerDashboardViewModel_Factory(getOwnerPropertiesUseCaseProvider, getOwnerInterestsUseCaseProvider, deletePropertyUseCaseProvider, authRepositoryProvider, savedStateHandleProvider);
  }

  public static OwnerDashboardViewModel newInstance(
      GetOwnerPropertiesUseCase getOwnerPropertiesUseCase,
      GetOwnerInterestsUseCase getOwnerInterestsUseCase,
      DeletePropertyUseCase deletePropertyUseCase, AuthRepository authRepository,
      SavedStateHandle savedStateHandle) {
    return new OwnerDashboardViewModel(getOwnerPropertiesUseCase, getOwnerInterestsUseCase, deletePropertyUseCase, authRepository, savedStateHandle);
  }
}
