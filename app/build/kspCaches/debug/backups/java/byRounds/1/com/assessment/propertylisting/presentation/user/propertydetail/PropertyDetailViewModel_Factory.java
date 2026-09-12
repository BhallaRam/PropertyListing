package com.assessment.propertylisting.presentation.user.propertydetail;

import androidx.lifecycle.SavedStateHandle;
import com.assessment.propertylisting.domain.repository.AuthRepository;
import com.assessment.propertylisting.domain.usecase.GetPropertyByIdUseCase;
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
public final class PropertyDetailViewModel_Factory implements Factory<PropertyDetailViewModel> {
  private final Provider<GetPropertyByIdUseCase> getPropertyByIdUseCaseProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public PropertyDetailViewModel_Factory(
      Provider<GetPropertyByIdUseCase> getPropertyByIdUseCaseProvider,
      Provider<AuthRepository> authRepositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.getPropertyByIdUseCaseProvider = getPropertyByIdUseCaseProvider;
    this.authRepositoryProvider = authRepositoryProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public PropertyDetailViewModel get() {
    return newInstance(getPropertyByIdUseCaseProvider.get(), authRepositoryProvider.get(), savedStateHandleProvider.get());
  }

  public static PropertyDetailViewModel_Factory create(
      Provider<GetPropertyByIdUseCase> getPropertyByIdUseCaseProvider,
      Provider<AuthRepository> authRepositoryProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new PropertyDetailViewModel_Factory(getPropertyByIdUseCaseProvider, authRepositoryProvider, savedStateHandleProvider);
  }

  public static PropertyDetailViewModel newInstance(GetPropertyByIdUseCase getPropertyByIdUseCase,
      AuthRepository authRepository, SavedStateHandle savedStateHandle) {
    return new PropertyDetailViewModel(getPropertyByIdUseCase, authRepository, savedStateHandle);
  }
}
