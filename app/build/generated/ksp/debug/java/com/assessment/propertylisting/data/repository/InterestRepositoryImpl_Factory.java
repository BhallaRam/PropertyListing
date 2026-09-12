package com.assessment.propertylisting.data.repository;

import com.assessment.propertylisting.data.local.dao.InterestDao;
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
public final class InterestRepositoryImpl_Factory implements Factory<InterestRepositoryImpl> {
  private final Provider<InterestDao> interestDaoProvider;

  public InterestRepositoryImpl_Factory(Provider<InterestDao> interestDaoProvider) {
    this.interestDaoProvider = interestDaoProvider;
  }

  @Override
  public InterestRepositoryImpl get() {
    return newInstance(interestDaoProvider.get());
  }

  public static InterestRepositoryImpl_Factory create(Provider<InterestDao> interestDaoProvider) {
    return new InterestRepositoryImpl_Factory(interestDaoProvider);
  }

  public static InterestRepositoryImpl newInstance(InterestDao interestDao) {
    return new InterestRepositoryImpl(interestDao);
  }
}
