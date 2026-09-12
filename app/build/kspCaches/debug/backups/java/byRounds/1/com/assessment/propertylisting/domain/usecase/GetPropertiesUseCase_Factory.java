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
public final class GetPropertiesUseCase_Factory implements Factory<GetPropertiesUseCase> {
  private final Provider<PropertyRepository> propertyRepositoryProvider;

  public GetPropertiesUseCase_Factory(Provider<PropertyRepository> propertyRepositoryProvider) {
    this.propertyRepositoryProvider = propertyRepositoryProvider;
  }

  @Override
  public GetPropertiesUseCase get() {
    return newInstance(propertyRepositoryProvider.get());
  }

  public static GetPropertiesUseCase_Factory create(
      Provider<PropertyRepository> propertyRepositoryProvider) {
    return new GetPropertiesUseCase_Factory(propertyRepositoryProvider);
  }

  public static GetPropertiesUseCase newInstance(PropertyRepository propertyRepository) {
    return new GetPropertiesUseCase(propertyRepository);
  }
}
