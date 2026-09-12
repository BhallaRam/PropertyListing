package com.assessment.propertylisting.presentation.user.interest;

import androidx.lifecycle.SavedStateHandle;
import com.assessment.propertylisting.domain.usecase.GetPropertyByIdUseCase;
import com.assessment.propertylisting.domain.usecase.SubmitInterestUseCase;
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
public final class InterestViewModel_Factory implements Factory<InterestViewModel> {
  private final Provider<GetPropertyByIdUseCase> getPropertyByIdUseCaseProvider;

  private final Provider<SubmitInterestUseCase> submitInterestUseCaseProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public InterestViewModel_Factory(Provider<GetPropertyByIdUseCase> getPropertyByIdUseCaseProvider,
      Provider<SubmitInterestUseCase> submitInterestUseCaseProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.getPropertyByIdUseCaseProvider = getPropertyByIdUseCaseProvider;
    this.submitInterestUseCaseProvider = submitInterestUseCaseProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public InterestViewModel get() {
    return newInstance(getPropertyByIdUseCaseProvider.get(), submitInterestUseCaseProvider.get(), savedStateHandleProvider.get());
  }

  public static InterestViewModel_Factory create(
      Provider<GetPropertyByIdUseCase> getPropertyByIdUseCaseProvider,
      Provider<SubmitInterestUseCase> submitInterestUseCaseProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new InterestViewModel_Factory(getPropertyByIdUseCaseProvider, submitInterestUseCaseProvider, savedStateHandleProvider);
  }

  public static InterestViewModel newInstance(GetPropertyByIdUseCase getPropertyByIdUseCase,
      SubmitInterestUseCase submitInterestUseCase, SavedStateHandle savedStateHandle) {
    return new InterestViewModel(getPropertyByIdUseCase, submitInterestUseCase, savedStateHandle);
  }
}
