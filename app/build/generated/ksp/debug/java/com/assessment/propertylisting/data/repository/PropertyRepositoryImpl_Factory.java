package com.assessment.propertylisting.data.repository;

import com.assessment.propertylisting.data.local.dao.PropertyDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class PropertyRepositoryImpl_Factory implements Factory<PropertyRepositoryImpl> {
  private final Provider<PropertyDao> propertyDaoProvider;

  public PropertyRepositoryImpl_Factory(Provider<PropertyDao> propertyDaoProvider) {
    this.propertyDaoProvider = propertyDaoProvider;
  }

  @Override
  public PropertyRepositoryImpl get() {
    return newInstance(propertyDaoProvider.get());
  }

  public static PropertyRepositoryImpl_Factory create(Provider<PropertyDao> propertyDaoProvider) {
    return new PropertyRepositoryImpl_Factory(propertyDaoProvider);
  }

  public static PropertyRepositoryImpl newInstance(PropertyDao propertyDao) {
    return new PropertyRepositoryImpl(propertyDao);
  }
}
