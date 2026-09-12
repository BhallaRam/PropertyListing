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
public final class GetOwnerPropertiesUseCase_Factory implements Factory<GetOwnerPropertiesUseCase> {
  private final Provider<PropertyRepository> propertyRepositoryProvider;

  public GetOwnerPropertiesUseCase_Factory(
      Provider<PropertyRepository> propertyRepositoryProvider) {
    this.propertyRepositoryProvider = propertyRepositoryProvider;
  }

  @Override
  public GetOwnerPropertiesUseCase get() {
    return newInstance(propertyRepositoryProvider.get());
  }

  public static GetOwnerPropertiesUseCase_Factory create(
      Provider<PropertyRepository> propertyRepositoryProvider) {
    return new GetOwnerPropertiesUseCase_Factory(propertyRepositoryProvider);
  }

  public static GetOwnerPropertiesUseCase newInstance(PropertyRepository propertyRepository) {
    return new GetOwnerPropertiesUseCase(propertyRepository);
  }
}
