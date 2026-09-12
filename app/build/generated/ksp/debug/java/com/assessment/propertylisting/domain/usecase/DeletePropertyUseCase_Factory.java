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
public final class DeletePropertyUseCase_Factory implements Factory<DeletePropertyUseCase> {
  private final Provider<PropertyRepository> propertyRepositoryProvider;

  public DeletePropertyUseCase_Factory(Provider<PropertyRepository> propertyRepositoryProvider) {
    this.propertyRepositoryProvider = propertyRepositoryProvider;
  }

  @Override
  public DeletePropertyUseCase get() {
    return newInstance(propertyRepositoryProvider.get());
  }

  public static DeletePropertyUseCase_Factory create(
      Provider<PropertyRepository> propertyRepositoryProvider) {
    return new DeletePropertyUseCase_Factory(propertyRepositoryProvider);
  }

  public static DeletePropertyUseCase newInstance(PropertyRepository propertyRepository) {
    return new DeletePropertyUseCase(propertyRepository);
  }
}
