package com.assessment.propertylisting.domain.usecase;

import com.assessment.propertylisting.domain.repository.PropertyRepository;
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
public final class GetPropertyByIdUseCase_Factory implements Factory<GetPropertyByIdUseCase> {
  private final Provider<PropertyRepository> propertyRepositoryProvider;

  public GetPropertyByIdUseCase_Factory(Provider<PropertyRepository> propertyRepositoryProvider) {
    this.propertyRepositoryProvider = propertyRepositoryProvider;
  }

  @Override
  public GetPropertyByIdUseCase get() {
    return newInstance(propertyRepositoryProvider.get());
  }

  public static GetPropertyByIdUseCase_Factory create(
      Provider<PropertyRepository> propertyRepositoryProvider) {
    return new GetPropertyByIdUseCase_Factory(propertyRepositoryProvider);
  }

  public static GetPropertyByIdUseCase newInstance(PropertyRepository propertyRepository) {
    return new GetPropertyByIdUseCase(propertyRepository);
  }
}
