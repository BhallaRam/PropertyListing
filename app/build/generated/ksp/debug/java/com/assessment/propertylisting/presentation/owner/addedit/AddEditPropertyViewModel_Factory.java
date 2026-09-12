package com.assessment.propertylisting.presentation.owner.addedit;

import androidx.lifecycle.SavedStateHandle;
import com.assessment.propertylisting.domain.usecase.AddPropertyUseCase;
import com.assessment.propertylisting.domain.usecase.GetPropertyByIdUseCase;
import com.assessment.propertylisting.domain.usecase.UpdatePropertyUseCase;
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
public final class AddEditPropertyViewModel_Factory implements Factory<AddEditPropertyViewModel> {
  private final Provider<AddPropertyUseCase> addPropertyUseCaseProvider;

  private final Provider<UpdatePropertyUseCase> updatePropertyUseCaseProvider;

  private final Provider<GetPropertyByIdUseCase> getPropertyByIdUseCaseProvider;

  private final Provider<SavedStateHandle> savedStateHandleProvider;

  public AddEditPropertyViewModel_Factory(Provider<AddPropertyUseCase> addPropertyUseCaseProvider,
      Provider<UpdatePropertyUseCase> updatePropertyUseCaseProvider,
      Provider<GetPropertyByIdUseCase> getPropertyByIdUseCaseProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    this.addPropertyUseCaseProvider = addPropertyUseCaseProvider;
    this.updatePropertyUseCaseProvider = updatePropertyUseCaseProvider;
    this.getPropertyByIdUseCaseProvider = getPropertyByIdUseCaseProvider;
    this.savedStateHandleProvider = savedStateHandleProvider;
  }

  @Override
  public AddEditPropertyViewModel get() {
    return newInstance(addPropertyUseCaseProvider.get(), updatePropertyUseCaseProvider.get(), getPropertyByIdUseCaseProvider.get(), savedStateHandleProvider.get());
  }

  public static AddEditPropertyViewModel_Factory create(
      Provider<AddPropertyUseCase> addPropertyUseCaseProvider,
      Provider<UpdatePropertyUseCase> updatePropertyUseCaseProvider,
      Provider<GetPropertyByIdUseCase> getPropertyByIdUseCaseProvider,
      Provider<SavedStateHandle> savedStateHandleProvider) {
    return new AddEditPropertyViewModel_Factory(addPropertyUseCaseProvider, updatePropertyUseCaseProvider, getPropertyByIdUseCaseProvider, savedStateHandleProvider);
  }

  public static AddEditPropertyViewModel newInstance(AddPropertyUseCase addPropertyUseCase,
      UpdatePropertyUseCase updatePropertyUseCase, GetPropertyByIdUseCase getPropertyByIdUseCase,
      SavedStateHandle savedStateHandle) {
    return new AddEditPropertyViewModel(addPropertyUseCase, updatePropertyUseCase, getPropertyByIdUseCase, savedStateHandle);
  }
}
