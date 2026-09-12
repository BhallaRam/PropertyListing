package com.assessment.propertylisting;

import android.app.Activity;
import android.app.Service;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import com.assessment.propertylisting.data.local.AppDatabase;
import com.assessment.propertylisting.data.local.dao.InterestDao;
import com.assessment.propertylisting.data.local.dao.PropertyDao;
import com.assessment.propertylisting.data.repository.AuthRepositoryImpl;
import com.assessment.propertylisting.data.repository.InterestRepositoryImpl;
import com.assessment.propertylisting.data.repository.PropertyRepositoryImpl;
import com.assessment.propertylisting.di.DatabaseModule_ProvideAppDatabaseFactory;
import com.assessment.propertylisting.di.DatabaseModule_ProvideInterestDaoFactory;
import com.assessment.propertylisting.di.DatabaseModule_ProvidePropertyDaoFactory;
import com.assessment.propertylisting.domain.usecase.AddPropertyUseCase;
import com.assessment.propertylisting.domain.usecase.DeletePropertyUseCase;
import com.assessment.propertylisting.domain.usecase.FilterPropertiesUseCase;
import com.assessment.propertylisting.domain.usecase.GetOwnerInterestsUseCase;
import com.assessment.propertylisting.domain.usecase.GetOwnerPropertiesUseCase;
import com.assessment.propertylisting.domain.usecase.GetPropertiesUseCase;
import com.assessment.propertylisting.domain.usecase.GetPropertyByIdUseCase;
import com.assessment.propertylisting.domain.usecase.LoginUseCase;
import com.assessment.propertylisting.domain.usecase.SubmitInterestUseCase;
import com.assessment.propertylisting.domain.usecase.UpdatePropertyUseCase;
import com.assessment.propertylisting.presentation.login.LoginViewModel;
import com.assessment.propertylisting.presentation.login.LoginViewModel_HiltModules;
import com.assessment.propertylisting.presentation.owner.addedit.AddEditPropertyViewModel;
import com.assessment.propertylisting.presentation.owner.addedit.AddEditPropertyViewModel_HiltModules;
import com.assessment.propertylisting.presentation.owner.dashboard.OwnerDashboardViewModel;
import com.assessment.propertylisting.presentation.owner.dashboard.OwnerDashboardViewModel_HiltModules;
import com.assessment.propertylisting.presentation.user.dashboard.UserDashboardViewModel;
import com.assessment.propertylisting.presentation.user.dashboard.UserDashboardViewModel_HiltModules;
import com.assessment.propertylisting.presentation.user.interest.InterestViewModel;
import com.assessment.propertylisting.presentation.user.interest.InterestViewModel_HiltModules;
import com.assessment.propertylisting.presentation.user.propertydetail.PropertyDetailViewModel;
import com.assessment.propertylisting.presentation.user.propertydetail.PropertyDetailViewModel_HiltModules;
import dagger.hilt.android.ActivityRetainedLifecycle;
import dagger.hilt.android.ViewModelLifecycle;
import dagger.hilt.android.internal.builders.ActivityComponentBuilder;
import dagger.hilt.android.internal.builders.ActivityRetainedComponentBuilder;
import dagger.hilt.android.internal.builders.FragmentComponentBuilder;
import dagger.hilt.android.internal.builders.ServiceComponentBuilder;
import dagger.hilt.android.internal.builders.ViewComponentBuilder;
import dagger.hilt.android.internal.builders.ViewModelComponentBuilder;
import dagger.hilt.android.internal.builders.ViewWithFragmentComponentBuilder;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories;
import dagger.hilt.android.internal.lifecycle.DefaultViewModelFactories_InternalFactoryFactory_Factory;
import dagger.hilt.android.internal.managers.ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory;
import dagger.hilt.android.internal.managers.SavedStateHandleHolder;
import dagger.hilt.android.internal.modules.ApplicationContextModule;
import dagger.hilt.android.internal.modules.ApplicationContextModule_ProvideContextFactory;
import dagger.internal.DaggerGenerated;
import dagger.internal.DelegateFactory;
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;

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
public final class DaggerPropertyListingApp_HiltComponents_SingletonC {
  private DaggerPropertyListingApp_HiltComponents_SingletonC() {
  }

  public static Builder builder() {
    return new Builder();
  }

  public static final class Builder {
    private ApplicationContextModule applicationContextModule;

    private Builder() {
    }

    public Builder applicationContextModule(ApplicationContextModule applicationContextModule) {
      this.applicationContextModule = Preconditions.checkNotNull(applicationContextModule);
      return this;
    }

    public PropertyListingApp_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements PropertyListingApp_HiltComponents.ActivityRetainedC.Builder {
    private final SingletonCImpl singletonCImpl;

    private SavedStateHandleHolder savedStateHandleHolder;

    private ActivityRetainedCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ActivityRetainedCBuilder savedStateHandleHolder(
        SavedStateHandleHolder savedStateHandleHolder) {
      this.savedStateHandleHolder = Preconditions.checkNotNull(savedStateHandleHolder);
      return this;
    }

    @Override
    public PropertyListingApp_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements PropertyListingApp_HiltComponents.ActivityC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private Activity activity;

    private ActivityCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ActivityCBuilder activity(Activity activity) {
      this.activity = Preconditions.checkNotNull(activity);
      return this;
    }

    @Override
    public PropertyListingApp_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements PropertyListingApp_HiltComponents.FragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private Fragment fragment;

    private FragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public FragmentCBuilder fragment(Fragment fragment) {
      this.fragment = Preconditions.checkNotNull(fragment);
      return this;
    }

    @Override
    public PropertyListingApp_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements PropertyListingApp_HiltComponents.ViewWithFragmentC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private View view;

    private ViewWithFragmentCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;
    }

    @Override
    public ViewWithFragmentCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public PropertyListingApp_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements PropertyListingApp_HiltComponents.ViewC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private View view;

    private ViewCBuilder(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
    }

    @Override
    public ViewCBuilder view(View view) {
      this.view = Preconditions.checkNotNull(view);
      return this;
    }

    @Override
    public PropertyListingApp_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements PropertyListingApp_HiltComponents.ViewModelC.Builder {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private SavedStateHandle savedStateHandle;

    private ViewModelLifecycle viewModelLifecycle;

    private ViewModelCBuilder(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
    }

    @Override
    public ViewModelCBuilder savedStateHandle(SavedStateHandle handle) {
      this.savedStateHandle = Preconditions.checkNotNull(handle);
      return this;
    }

    @Override
    public ViewModelCBuilder viewModelLifecycle(ViewModelLifecycle viewModelLifecycle) {
      this.viewModelLifecycle = Preconditions.checkNotNull(viewModelLifecycle);
      return this;
    }

    @Override
    public PropertyListingApp_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements PropertyListingApp_HiltComponents.ServiceC.Builder {
    private final SingletonCImpl singletonCImpl;

    private Service service;

    private ServiceCBuilder(SingletonCImpl singletonCImpl) {
      this.singletonCImpl = singletonCImpl;
    }

    @Override
    public ServiceCBuilder service(Service service) {
      this.service = Preconditions.checkNotNull(service);
      return this;
    }

    @Override
    public PropertyListingApp_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends PropertyListingApp_HiltComponents.ViewWithFragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl;

    private final ViewWithFragmentCImpl viewWithFragmentCImpl = this;

    private ViewWithFragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        FragmentCImpl fragmentCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;
      this.fragmentCImpl = fragmentCImpl;


    }
  }

  private static final class FragmentCImpl extends PropertyListingApp_HiltComponents.FragmentC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final FragmentCImpl fragmentCImpl = this;

    private FragmentCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, ActivityCImpl activityCImpl,
        Fragment fragmentParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return activityCImpl.getHiltInternalFactoryFactory();
    }

    @Override
    public ViewWithFragmentComponentBuilder viewWithFragmentComponentBuilder() {
      return new ViewWithFragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl);
    }
  }

  private static final class ViewCImpl extends PropertyListingApp_HiltComponents.ViewC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl;

    private final ViewCImpl viewCImpl = this;

    private ViewCImpl(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
        ActivityCImpl activityCImpl, View viewParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.activityCImpl = activityCImpl;


    }
  }

  private static final class ActivityCImpl extends PropertyListingApp_HiltComponents.ActivityC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ActivityCImpl activityCImpl = this;

    private ActivityCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, Activity activityParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;


    }

    @Override
    public void injectMainActivity(MainActivity mainActivity) {
    }

    @Override
    public DefaultViewModelFactories.InternalFactoryFactory getHiltInternalFactoryFactory() {
      return DefaultViewModelFactories_InternalFactoryFactory_Factory.newInstance(getViewModelKeys(), new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl));
    }

    @Override
    public Map<Class<?>, Boolean> getViewModelKeys() {
      return LazyClassKeyMap.<Boolean>of(MapBuilder.<String, Boolean>newMapBuilder(6).put(LazyClassKeyProvider.com_assessment_propertylisting_presentation_owner_addedit_AddEditPropertyViewModel, AddEditPropertyViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_assessment_propertylisting_presentation_user_interest_InterestViewModel, InterestViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_assessment_propertylisting_presentation_login_LoginViewModel, LoginViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_assessment_propertylisting_presentation_owner_dashboard_OwnerDashboardViewModel, OwnerDashboardViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_assessment_propertylisting_presentation_user_propertydetail_PropertyDetailViewModel, PropertyDetailViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_assessment_propertylisting_presentation_user_dashboard_UserDashboardViewModel, UserDashboardViewModel_HiltModules.KeyModule.provide()).build());
    }

    @Override
    public ViewModelComponentBuilder getViewModelComponentBuilder() {
      return new ViewModelCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public FragmentComponentBuilder fragmentComponentBuilder() {
      return new FragmentCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @Override
    public ViewComponentBuilder viewComponentBuilder() {
      return new ViewCBuilder(singletonCImpl, activityRetainedCImpl, activityCImpl);
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_assessment_propertylisting_presentation_user_dashboard_UserDashboardViewModel = "com.assessment.propertylisting.presentation.user.dashboard.UserDashboardViewModel";

      static String com_assessment_propertylisting_presentation_login_LoginViewModel = "com.assessment.propertylisting.presentation.login.LoginViewModel";

      static String com_assessment_propertylisting_presentation_owner_dashboard_OwnerDashboardViewModel = "com.assessment.propertylisting.presentation.owner.dashboard.OwnerDashboardViewModel";

      static String com_assessment_propertylisting_presentation_user_propertydetail_PropertyDetailViewModel = "com.assessment.propertylisting.presentation.user.propertydetail.PropertyDetailViewModel";

      static String com_assessment_propertylisting_presentation_owner_addedit_AddEditPropertyViewModel = "com.assessment.propertylisting.presentation.owner.addedit.AddEditPropertyViewModel";

      static String com_assessment_propertylisting_presentation_user_interest_InterestViewModel = "com.assessment.propertylisting.presentation.user.interest.InterestViewModel";

      @KeepFieldType
      UserDashboardViewModel com_assessment_propertylisting_presentation_user_dashboard_UserDashboardViewModel2;

      @KeepFieldType
      LoginViewModel com_assessment_propertylisting_presentation_login_LoginViewModel2;

      @KeepFieldType
      OwnerDashboardViewModel com_assessment_propertylisting_presentation_owner_dashboard_OwnerDashboardViewModel2;

      @KeepFieldType
      PropertyDetailViewModel com_assessment_propertylisting_presentation_user_propertydetail_PropertyDetailViewModel2;

      @KeepFieldType
      AddEditPropertyViewModel com_assessment_propertylisting_presentation_owner_addedit_AddEditPropertyViewModel2;

      @KeepFieldType
      InterestViewModel com_assessment_propertylisting_presentation_user_interest_InterestViewModel2;
    }
  }

  private static final class ViewModelCImpl extends PropertyListingApp_HiltComponents.ViewModelC {
    private final SavedStateHandle savedStateHandle;

    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AddEditPropertyViewModel> addEditPropertyViewModelProvider;

    private Provider<InterestViewModel> interestViewModelProvider;

    private Provider<LoginViewModel> loginViewModelProvider;

    private Provider<OwnerDashboardViewModel> ownerDashboardViewModelProvider;

    private Provider<PropertyDetailViewModel> propertyDetailViewModelProvider;

    private Provider<UserDashboardViewModel> userDashboardViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;
      this.savedStateHandle = savedStateHandleParam;
      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    private AddPropertyUseCase addPropertyUseCase() {
      return new AddPropertyUseCase(singletonCImpl.propertyRepositoryImplProvider.get());
    }

    private UpdatePropertyUseCase updatePropertyUseCase() {
      return new UpdatePropertyUseCase(singletonCImpl.propertyRepositoryImplProvider.get(), addPropertyUseCase());
    }

    private GetPropertyByIdUseCase getPropertyByIdUseCase() {
      return new GetPropertyByIdUseCase(singletonCImpl.propertyRepositoryImplProvider.get());
    }

    private SubmitInterestUseCase submitInterestUseCase() {
      return new SubmitInterestUseCase(singletonCImpl.interestRepositoryImplProvider.get());
    }

    private LoginUseCase loginUseCase() {
      return new LoginUseCase(singletonCImpl.authRepositoryImplProvider.get());
    }

    private GetOwnerPropertiesUseCase getOwnerPropertiesUseCase() {
      return new GetOwnerPropertiesUseCase(singletonCImpl.propertyRepositoryImplProvider.get());
    }

    private GetOwnerInterestsUseCase getOwnerInterestsUseCase() {
      return new GetOwnerInterestsUseCase(singletonCImpl.interestRepositoryImplProvider.get());
    }

    private DeletePropertyUseCase deletePropertyUseCase() {
      return new DeletePropertyUseCase(singletonCImpl.propertyRepositoryImplProvider.get());
    }

    private GetPropertiesUseCase getPropertiesUseCase() {
      return new GetPropertiesUseCase(singletonCImpl.propertyRepositoryImplProvider.get());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.addEditPropertyViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.interestViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.loginViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.ownerDashboardViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.propertyDetailViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.userDashboardViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(6).put(LazyClassKeyProvider.com_assessment_propertylisting_presentation_owner_addedit_AddEditPropertyViewModel, ((Provider) addEditPropertyViewModelProvider)).put(LazyClassKeyProvider.com_assessment_propertylisting_presentation_user_interest_InterestViewModel, ((Provider) interestViewModelProvider)).put(LazyClassKeyProvider.com_assessment_propertylisting_presentation_login_LoginViewModel, ((Provider) loginViewModelProvider)).put(LazyClassKeyProvider.com_assessment_propertylisting_presentation_owner_dashboard_OwnerDashboardViewModel, ((Provider) ownerDashboardViewModelProvider)).put(LazyClassKeyProvider.com_assessment_propertylisting_presentation_user_propertydetail_PropertyDetailViewModel, ((Provider) propertyDetailViewModelProvider)).put(LazyClassKeyProvider.com_assessment_propertylisting_presentation_user_dashboard_UserDashboardViewModel, ((Provider) userDashboardViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return Collections.<Class<?>, Object>emptyMap();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_assessment_propertylisting_presentation_owner_dashboard_OwnerDashboardViewModel = "com.assessment.propertylisting.presentation.owner.dashboard.OwnerDashboardViewModel";

      static String com_assessment_propertylisting_presentation_user_interest_InterestViewModel = "com.assessment.propertylisting.presentation.user.interest.InterestViewModel";

      static String com_assessment_propertylisting_presentation_login_LoginViewModel = "com.assessment.propertylisting.presentation.login.LoginViewModel";

      static String com_assessment_propertylisting_presentation_owner_addedit_AddEditPropertyViewModel = "com.assessment.propertylisting.presentation.owner.addedit.AddEditPropertyViewModel";

      static String com_assessment_propertylisting_presentation_user_propertydetail_PropertyDetailViewModel = "com.assessment.propertylisting.presentation.user.propertydetail.PropertyDetailViewModel";

      static String com_assessment_propertylisting_presentation_user_dashboard_UserDashboardViewModel = "com.assessment.propertylisting.presentation.user.dashboard.UserDashboardViewModel";

      @KeepFieldType
      OwnerDashboardViewModel com_assessment_propertylisting_presentation_owner_dashboard_OwnerDashboardViewModel2;

      @KeepFieldType
      InterestViewModel com_assessment_propertylisting_presentation_user_interest_InterestViewModel2;

      @KeepFieldType
      LoginViewModel com_assessment_propertylisting_presentation_login_LoginViewModel2;

      @KeepFieldType
      AddEditPropertyViewModel com_assessment_propertylisting_presentation_owner_addedit_AddEditPropertyViewModel2;

      @KeepFieldType
      PropertyDetailViewModel com_assessment_propertylisting_presentation_user_propertydetail_PropertyDetailViewModel2;

      @KeepFieldType
      UserDashboardViewModel com_assessment_propertylisting_presentation_user_dashboard_UserDashboardViewModel2;
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final ViewModelCImpl viewModelCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          ViewModelCImpl viewModelCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.viewModelCImpl = viewModelCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.assessment.propertylisting.presentation.owner.addedit.AddEditPropertyViewModel 
          return (T) new AddEditPropertyViewModel(viewModelCImpl.addPropertyUseCase(), viewModelCImpl.updatePropertyUseCase(), viewModelCImpl.getPropertyByIdUseCase(), viewModelCImpl.savedStateHandle);

          case 1: // com.assessment.propertylisting.presentation.user.interest.InterestViewModel 
          return (T) new InterestViewModel(viewModelCImpl.getPropertyByIdUseCase(), viewModelCImpl.submitInterestUseCase(), viewModelCImpl.savedStateHandle);

          case 2: // com.assessment.propertylisting.presentation.login.LoginViewModel 
          return (T) new LoginViewModel(viewModelCImpl.loginUseCase());

          case 3: // com.assessment.propertylisting.presentation.owner.dashboard.OwnerDashboardViewModel 
          return (T) new OwnerDashboardViewModel(viewModelCImpl.getOwnerPropertiesUseCase(), viewModelCImpl.getOwnerInterestsUseCase(), viewModelCImpl.deletePropertyUseCase(), singletonCImpl.authRepositoryImplProvider.get(), viewModelCImpl.savedStateHandle);

          case 4: // com.assessment.propertylisting.presentation.user.propertydetail.PropertyDetailViewModel 
          return (T) new PropertyDetailViewModel(viewModelCImpl.getPropertyByIdUseCase(), singletonCImpl.authRepositoryImplProvider.get(), viewModelCImpl.savedStateHandle);

          case 5: // com.assessment.propertylisting.presentation.user.dashboard.UserDashboardViewModel 
          return (T) new UserDashboardViewModel(viewModelCImpl.getPropertiesUseCase(), new FilterPropertiesUseCase(), singletonCImpl.propertyRepositoryImplProvider.get(), singletonCImpl.authRepositoryImplProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends PropertyListingApp_HiltComponents.ActivityRetainedC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl = this;

    private Provider<ActivityRetainedLifecycle> provideActivityRetainedLifecycleProvider;

    private ActivityRetainedCImpl(SingletonCImpl singletonCImpl,
        SavedStateHandleHolder savedStateHandleHolderParam) {
      this.singletonCImpl = singletonCImpl;

      initialize(savedStateHandleHolderParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandleHolder savedStateHandleHolderParam) {
      this.provideActivityRetainedLifecycleProvider = DoubleCheck.provider(new SwitchingProvider<ActivityRetainedLifecycle>(singletonCImpl, activityRetainedCImpl, 0));
    }

    @Override
    public ActivityComponentBuilder activityComponentBuilder() {
      return new ActivityCBuilder(singletonCImpl, activityRetainedCImpl);
    }

    @Override
    public ActivityRetainedLifecycle getActivityRetainedLifecycle() {
      return provideActivityRetainedLifecycleProvider.get();
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final ActivityRetainedCImpl activityRetainedCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, ActivityRetainedCImpl activityRetainedCImpl,
          int id) {
        this.singletonCImpl = singletonCImpl;
        this.activityRetainedCImpl = activityRetainedCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // dagger.hilt.android.ActivityRetainedLifecycle 
          return (T) ActivityRetainedComponentManager_LifecycleModule_ProvideActivityRetainedLifecycleFactory.provideActivityRetainedLifecycle();

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ServiceCImpl extends PropertyListingApp_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends PropertyListingApp_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<PropertyDao> providePropertyDaoProvider;

    private Provider<AppDatabase> provideAppDatabaseProvider;

    private Provider<PropertyRepositoryImpl> propertyRepositoryImplProvider;

    private Provider<InterestDao> provideInterestDaoProvider;

    private Provider<InterestRepositoryImpl> interestRepositoryImplProvider;

    private Provider<AuthRepositoryImpl> authRepositoryImplProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.providePropertyDaoProvider = new DelegateFactory<>();
      this.provideAppDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<AppDatabase>(singletonCImpl, 2));
      DelegateFactory.setDelegate(providePropertyDaoProvider, DoubleCheck.provider(new SwitchingProvider<PropertyDao>(singletonCImpl, 1)));
      this.propertyRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<PropertyRepositoryImpl>(singletonCImpl, 0));
      this.provideInterestDaoProvider = DoubleCheck.provider(new SwitchingProvider<InterestDao>(singletonCImpl, 4));
      this.interestRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<InterestRepositoryImpl>(singletonCImpl, 3));
      this.authRepositoryImplProvider = DoubleCheck.provider(new SwitchingProvider<AuthRepositoryImpl>(singletonCImpl, 5));
    }

    @Override
    public void injectPropertyListingApp(PropertyListingApp propertyListingApp) {
    }

    @Override
    public Set<Boolean> getDisableFragmentGetContextFix() {
      return Collections.<Boolean>emptySet();
    }

    @Override
    public ActivityRetainedComponentBuilder retainedComponentBuilder() {
      return new ActivityRetainedCBuilder(singletonCImpl);
    }

    @Override
    public ServiceComponentBuilder serviceComponentBuilder() {
      return new ServiceCBuilder(singletonCImpl);
    }

    private static final class SwitchingProvider<T> implements Provider<T> {
      private final SingletonCImpl singletonCImpl;

      private final int id;

      SwitchingProvider(SingletonCImpl singletonCImpl, int id) {
        this.singletonCImpl = singletonCImpl;
        this.id = id;
      }

      @SuppressWarnings("unchecked")
      @Override
      public T get() {
        switch (id) {
          case 0: // com.assessment.propertylisting.data.repository.PropertyRepositoryImpl 
          return (T) new PropertyRepositoryImpl(singletonCImpl.providePropertyDaoProvider.get());

          case 1: // com.assessment.propertylisting.data.local.dao.PropertyDao 
          return (T) DatabaseModule_ProvidePropertyDaoFactory.providePropertyDao(singletonCImpl.provideAppDatabaseProvider.get());

          case 2: // com.assessment.propertylisting.data.local.AppDatabase 
          return (T) DatabaseModule_ProvideAppDatabaseFactory.provideAppDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule), singletonCImpl.providePropertyDaoProvider);

          case 3: // com.assessment.propertylisting.data.repository.InterestRepositoryImpl 
          return (T) new InterestRepositoryImpl(singletonCImpl.provideInterestDaoProvider.get());

          case 4: // com.assessment.propertylisting.data.local.dao.InterestDao 
          return (T) DatabaseModule_ProvideInterestDaoFactory.provideInterestDao(singletonCImpl.provideAppDatabaseProvider.get());

          case 5: // com.assessment.propertylisting.data.repository.AuthRepositoryImpl 
          return (T) new AuthRepositoryImpl();

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
