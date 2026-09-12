package com.assessment.propertylisting.domain.usecase;

import com.assessment.propertylisting.domain.repository.InterestRepository;
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
public final class GetOwnerInterestsUseCase_Factory implements Factory<GetOwnerInterestsUseCase> {
  private final Provider<InterestRepository> interestRepositoryProvider;

  public GetOwnerInterestsUseCase_Factory(Provider<InterestRepository> interestRepositoryProvider) {
    this.interestRepositoryProvider = interestRepositoryProvider;
  }

  @Override
  public GetOwnerInterestsUseCase get() {
    return newInstance(interestRepositoryProvider.get());
  }

  public static GetOwnerInterestsUseCase_Factory create(
      Provider<InterestRepository> interestRepositoryProvider) {
    return new GetOwnerInterestsUseCase_Factory(interestRepositoryProvider);
  }

  public static GetOwnerInterestsUseCase newInstance(InterestRepository interestRepository) {
    return new GetOwnerInterestsUseCase(interestRepository);
  }
}
