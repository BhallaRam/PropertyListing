package com.assessment.propertylisting.domain.usecase;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class FilterPropertiesUseCase_Factory implements Factory<FilterPropertiesUseCase> {
  @Override
  public FilterPropertiesUseCase get() {
    return newInstance();
  }

  public static FilterPropertiesUseCase_Factory create() {
    return InstanceHolder.INSTANCE;
  }

  public static FilterPropertiesUseCase newInstance() {
    return new FilterPropertiesUseCase();
  }

  private static final class InstanceHolder {
    private static final FilterPropertiesUseCase_Factory INSTANCE = new FilterPropertiesUseCase_Factory();
  }
}
