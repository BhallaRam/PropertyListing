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
public final class SubmitInterestUseCase_Factory implements Factory<SubmitInterestUseCase> {
  private final Provider<InterestRepository> interestRepositoryProvider;

  public SubmitInterestUseCase_Factory(Provider<InterestRepository> interestRepositoryProvider) {
    this.interestRepositoryProvider = interestRepositoryProvider;
  }

  @Override
  public SubmitInterestUseCase get() {
    return newInstance(interestRepositoryProvider.get());
  }

  public static SubmitInterestUseCase_Factory create(
      Provider<InterestRepository> interestRepositoryProvider) {
    return new SubmitInterestUseCase_Factory(interestRepositoryProvider);
  }

  public static SubmitInterestUseCase newInstance(InterestRepository interestRepository) {
    return new SubmitInterestUseCase(interestRepository);
  }
}
