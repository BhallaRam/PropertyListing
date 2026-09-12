package com.assessment.propertylisting.di;

import com.assessment.propertylisting.data.local.AppDatabase;
import com.assessment.propertylisting.data.local.dao.PropertyDao;
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
public final class DatabaseModule_ProvidePropertyDaoFactory implements Factory<PropertyDao> {
  private final Provider<AppDatabase> databaseProvider;

  public DatabaseModule_ProvidePropertyDaoFactory(Provider<AppDatabase> databaseProvider) {
    this.databaseProvider = databaseProvider;
  }

  @Override
  public PropertyDao get() {
    return providePropertyDao(databaseProvider.get());
  }

  public static DatabaseModule_ProvidePropertyDaoFactory create(
      Provider<AppDatabase> databaseProvider) {
    return new DatabaseModule_ProvidePropertyDaoFactory(databaseProvider);
  }

  public static PropertyDao providePropertyDao(AppDatabase database) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.providePropertyDao(database));
  }
}
