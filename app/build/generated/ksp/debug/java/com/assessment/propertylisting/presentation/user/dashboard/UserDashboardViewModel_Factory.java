package com.assessment.propertylisting.presentation.user.dashboard;

import com.assessment.propertylisting.domain.repository.AuthRepository;
import com.assessment.propertylisting.domain.repository.PropertyRepository;
import com.assessment.propertylisting.domain.usecase.FilterPropertiesUseCase;
import com.assessment.propertylisting.domain.usecase.GetPropertiesUseCase;
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
public final class UserDashboardViewModel_Factory implements Factory<UserDashboardViewModel> {
  private final Provider<GetPropertiesUseCase> getPropertiesUseCaseProvider;

  private final Provider<FilterPropertiesUseCase> filterPropertiesUseCaseProvider;

  private final Provider<PropertyRepository> propertyRepositoryProvider;

  private final Provider<AuthRepository> authRepositoryProvider;

  public UserDashboardViewModel_Factory(Provider<GetPropertiesUseCase> getPropertiesUseCaseProvider,
      Provider<FilterPropertiesUseCase> filterPropertiesUseCaseProvider,
      Provider<PropertyRepository> propertyRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    this.getPropertiesUseCaseProvider = getPropertiesUseCaseProvider;
    this.filterPropertiesUseCaseProvider = filterPropertiesUseCaseProvider;
    this.propertyRepositoryProvider = propertyRepositoryProvider;
    this.authRepositoryProvider = authRepositoryProvider;
  }

  @Override
  public UserDashboardViewModel get() {
    return newInstance(getPropertiesUseCaseProvider.get(), filterPropertiesUseCaseProvider.get(), propertyRepositoryProvider.get(), authRepositoryProvider.get());
  }

  public static UserDashboardViewModel_Factory create(
      Provider<GetPropertiesUseCase> getPropertiesUseCaseProvider,
      Provider<FilterPropertiesUseCase> filterPropertiesUseCaseProvider,
      Provider<PropertyRepository> propertyRepositoryProvider,
      Provider<AuthRepository> authRepositoryProvider) {
    return new UserDashboardViewModel_Factory(getPropertiesUseCaseProvider, filterPropertiesUseCaseProvider, propertyRepositoryProvider, authRepositoryProvider);
  }

  public static UserDashboardViewModel newInstance(GetPropertiesUseCase getPropertiesUseCase,
      FilterPropertiesUseCase filterPropertiesUseCase, PropertyRepository propertyRepository,
      AuthRepository authRepository) {
    return new UserDashboardViewModel(getPropertiesUseCase, filterPropertiesUseCase, propertyRepository, authRepository);
  }
}
