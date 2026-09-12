package com.assessment.propertylisting.di;

import com.assessment.propertylisting.data.local.AppDatabase;
import com.assessment.propertylisting.data.local.dao.InterestDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class DatabaseModule_ProvideInterestDaoFactory implements Factory<InterestDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvideInterestDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public InterestDao get() {
    return provideInterestDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvideInterestDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvideInterestDaoFactory(databaseProvider);
  }

  public static InterestDao provideInterestDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideInterestDao(database));
  }
}
