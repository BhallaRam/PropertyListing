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
public final class UpdatePropertyUseCase_Factory implements Factory<UpdatePropertyUseCase> {
  private final Provider<PropertyRepository> propertyRepositoryProvider;

  private final Provider<AddPropertyUseCase> addPropertyUseCaseProvider;

  public UpdatePropertyUseCase_Factory(Provider<PropertyRepository> propertyRepositoryProvider,
      Provider<AddPropertyUseCase> addPropertyUseCaseProvider) {
    this.propertyRepositoryProvider = propertyRepositoryProvider;
    this.addPropertyUseCaseProvider = addPropertyUseCaseProvider;
  }

  @Override
  public UpdatePropertyUseCase get() {
    return newInstance(propertyRepositoryProvider.get(), addPropertyUseCaseProvider.get());
  }

  public static UpdatePropertyUseCase_Factory create(
      Provider<PropertyRepository> propertyRepositoryProvider,
      Provider<AddPropertyUseCase> addPropertyUseCaseProvider) {
    return new UpdatePropertyUseCase_Factory(propertyRepositoryProvider, addPropertyUseCaseProvider);
  }

  public static UpdatePropertyUseCase newInstance(PropertyRepository propertyRepository,
      AddPropertyUseCase addPropertyUseCase) {
    return new UpdatePropertyUseCase(propertyRepository, addPropertyUseCase);
  }
}
