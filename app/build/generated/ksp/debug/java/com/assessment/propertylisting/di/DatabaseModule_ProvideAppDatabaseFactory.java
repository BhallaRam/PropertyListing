package com.assessment.propertylisting.di;

import android.content.Context;
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
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DatabaseModule_ProvideAppDatabaseFactory implements Factory<AppDatabase> {
  private final Provider<Context> contextProvider;

  private final Provider<PropertyDao> propertyDaoProvider;

  public DatabaseModule_ProvideAppDatabaseFactory(Provider<Context> contextProvider,
      Provider<PropertyDao> propertyDaoProvider) {
    this.contextProvider = contextProvider;
    this.propertyDaoProvider = propertyDaoProvider;
  }

  @Override
  public AppDatabase get() {
    return provideAppDatabase(contextProvider.get(), propertyDaoProvider);
  }

  public static DatabaseModule_ProvideAppDatabaseFactory create(Provider<Context> contextProvider,
      Provider<PropertyDao> propertyDaoProvider) {
    return new DatabaseModule_ProvideAppDatabaseFactory(contextProvider, propertyDaoProvider);
  }

  public static AppDatabase provideAppDatabase(Context context,
      Provider<PropertyDao> propertyDaoProvider) {
    return Preconditions.checkNotNullFromProvides(DatabaseModule.INSTANCE.provideAppDatabase(context, propertyDaoProvider));
  }
}
