package com.climapro.app;

import android.app.Activity;
import android.app.Service;
import android.content.Context;
import android.view.View;
import androidx.fragment.app.Fragment;
import androidx.hilt.work.HiltWorkerFactory;
import androidx.hilt.work.WorkerAssistedFactory;
import androidx.hilt.work.WorkerFactoryModule_ProvideFactoryFactory;
import androidx.lifecycle.SavedStateHandle;
import androidx.lifecycle.ViewModel;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import com.climapro.app.data.db.AppDatabase;
import com.climapro.app.data.db.dao.MantenimientoDao;
import com.climapro.app.data.db.dao.MontajeDao;
import com.climapro.app.data.preferences.AppPreferences;
import com.climapro.app.data.repository.MantenimientoRepository;
import com.climapro.app.data.repository.MontajeRepository;
import com.climapro.app.di.AppModule_ProvideDatabaseFactory;
import com.climapro.app.di.AppModule_ProvideMantenimientoDaoFactory;
import com.climapro.app.di.AppModule_ProvideMontajeDaoFactory;
import com.climapro.app.di.AppModule_ProvideOkHttpFactory;
import com.climapro.app.di.AppModule_ProvideRetrofitFactory;
import com.climapro.app.di.AppModule_ProvideUpdateApiFactory;
import com.climapro.app.ui.screens.ajustes.AjustesViewModel;
import com.climapro.app.ui.screens.ajustes.AjustesViewModel_HiltModules;
import com.climapro.app.ui.screens.calendario.CalendarioViewModel;
import com.climapro.app.ui.screens.calendario.CalendarioViewModel_HiltModules;
import com.climapro.app.ui.screens.consultas.ConsultasViewModel;
import com.climapro.app.ui.screens.consultas.ConsultasViewModel_HiltModules;
import com.climapro.app.ui.screens.home.HomeViewModel;
import com.climapro.app.ui.screens.home.HomeViewModel_HiltModules;
import com.climapro.app.ui.screens.mantenimientos.MantenimientoDetalleViewModel;
import com.climapro.app.ui.screens.mantenimientos.MantenimientoDetalleViewModel_HiltModules;
import com.climapro.app.ui.screens.mantenimientos.MantenimientoFormViewModel;
import com.climapro.app.ui.screens.mantenimientos.MantenimientoFormViewModel_HiltModules;
import com.climapro.app.ui.screens.mantenimientos.MantenimientosViewModel;
import com.climapro.app.ui.screens.mantenimientos.MantenimientosViewModel_HiltModules;
import com.climapro.app.ui.screens.montajes.MontajeDetalleViewModel;
import com.climapro.app.ui.screens.montajes.MontajeDetalleViewModel_HiltModules;
import com.climapro.app.ui.screens.montajes.MontajeFormViewModel;
import com.climapro.app.ui.screens.montajes.MontajeFormViewModel_HiltModules;
import com.climapro.app.ui.screens.montajes.MontajesViewModel;
import com.climapro.app.ui.screens.montajes.MontajesViewModel_HiltModules;
import com.climapro.app.util.UpdateApi;
import com.climapro.app.util.UpdateChecker;
import com.climapro.app.worker.NotificationScheduler;
import com.climapro.app.worker.NotificationWorker;
import com.climapro.app.worker.NotificationWorker_AssistedFactory;
import com.climapro.app.worker.RescheduleWorker;
import com.climapro.app.worker.RescheduleWorker_AssistedFactory;
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
import dagger.internal.DoubleCheck;
import dagger.internal.IdentifierNameString;
import dagger.internal.KeepFieldType;
import dagger.internal.LazyClassKeyMap;
import dagger.internal.MapBuilder;
import dagger.internal.Preconditions;
import dagger.internal.Provider;
import dagger.internal.SingleCheck;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.Generated;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

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
public final class DaggerClimaPro_HiltComponents_SingletonC {
  private DaggerClimaPro_HiltComponents_SingletonC() {
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

    public ClimaPro_HiltComponents.SingletonC build() {
      Preconditions.checkBuilderRequirement(applicationContextModule, ApplicationContextModule.class);
      return new SingletonCImpl(applicationContextModule);
    }
  }

  private static final class ActivityRetainedCBuilder implements ClimaPro_HiltComponents.ActivityRetainedC.Builder {
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
    public ClimaPro_HiltComponents.ActivityRetainedC build() {
      Preconditions.checkBuilderRequirement(savedStateHandleHolder, SavedStateHandleHolder.class);
      return new ActivityRetainedCImpl(singletonCImpl, savedStateHandleHolder);
    }
  }

  private static final class ActivityCBuilder implements ClimaPro_HiltComponents.ActivityC.Builder {
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
    public ClimaPro_HiltComponents.ActivityC build() {
      Preconditions.checkBuilderRequirement(activity, Activity.class);
      return new ActivityCImpl(singletonCImpl, activityRetainedCImpl, activity);
    }
  }

  private static final class FragmentCBuilder implements ClimaPro_HiltComponents.FragmentC.Builder {
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
    public ClimaPro_HiltComponents.FragmentC build() {
      Preconditions.checkBuilderRequirement(fragment, Fragment.class);
      return new FragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragment);
    }
  }

  private static final class ViewWithFragmentCBuilder implements ClimaPro_HiltComponents.ViewWithFragmentC.Builder {
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
    public ClimaPro_HiltComponents.ViewWithFragmentC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewWithFragmentCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, fragmentCImpl, view);
    }
  }

  private static final class ViewCBuilder implements ClimaPro_HiltComponents.ViewC.Builder {
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
    public ClimaPro_HiltComponents.ViewC build() {
      Preconditions.checkBuilderRequirement(view, View.class);
      return new ViewCImpl(singletonCImpl, activityRetainedCImpl, activityCImpl, view);
    }
  }

  private static final class ViewModelCBuilder implements ClimaPro_HiltComponents.ViewModelC.Builder {
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
    public ClimaPro_HiltComponents.ViewModelC build() {
      Preconditions.checkBuilderRequirement(savedStateHandle, SavedStateHandle.class);
      Preconditions.checkBuilderRequirement(viewModelLifecycle, ViewModelLifecycle.class);
      return new ViewModelCImpl(singletonCImpl, activityRetainedCImpl, savedStateHandle, viewModelLifecycle);
    }
  }

  private static final class ServiceCBuilder implements ClimaPro_HiltComponents.ServiceC.Builder {
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
    public ClimaPro_HiltComponents.ServiceC build() {
      Preconditions.checkBuilderRequirement(service, Service.class);
      return new ServiceCImpl(singletonCImpl, service);
    }
  }

  private static final class ViewWithFragmentCImpl extends ClimaPro_HiltComponents.ViewWithFragmentC {
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

  private static final class FragmentCImpl extends ClimaPro_HiltComponents.FragmentC {
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

  private static final class ViewCImpl extends ClimaPro_HiltComponents.ViewC {
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

  private static final class ActivityCImpl extends ClimaPro_HiltComponents.ActivityC {
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
      return LazyClassKeyMap.<Boolean>of(MapBuilder.<String, Boolean>newMapBuilder(10).put(LazyClassKeyProvider.com_climapro_app_ui_screens_ajustes_AjustesViewModel, AjustesViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_climapro_app_ui_screens_calendario_CalendarioViewModel, CalendarioViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_climapro_app_ui_screens_consultas_ConsultasViewModel, ConsultasViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_climapro_app_ui_screens_home_HomeViewModel, HomeViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_climapro_app_ui_screens_mantenimientos_MantenimientoDetalleViewModel, MantenimientoDetalleViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_climapro_app_ui_screens_mantenimientos_MantenimientoFormViewModel, MantenimientoFormViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_climapro_app_ui_screens_mantenimientos_MantenimientosViewModel, MantenimientosViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_climapro_app_ui_screens_montajes_MontajeDetalleViewModel, MontajeDetalleViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_climapro_app_ui_screens_montajes_MontajeFormViewModel, MontajeFormViewModel_HiltModules.KeyModule.provide()).put(LazyClassKeyProvider.com_climapro_app_ui_screens_montajes_MontajesViewModel, MontajesViewModel_HiltModules.KeyModule.provide()).build());
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
      static String com_climapro_app_ui_screens_ajustes_AjustesViewModel = "com.climapro.app.ui.screens.ajustes.AjustesViewModel";

      static String com_climapro_app_ui_screens_montajes_MontajeFormViewModel = "com.climapro.app.ui.screens.montajes.MontajeFormViewModel";

      static String com_climapro_app_ui_screens_home_HomeViewModel = "com.climapro.app.ui.screens.home.HomeViewModel";

      static String com_climapro_app_ui_screens_mantenimientos_MantenimientoDetalleViewModel = "com.climapro.app.ui.screens.mantenimientos.MantenimientoDetalleViewModel";

      static String com_climapro_app_ui_screens_calendario_CalendarioViewModel = "com.climapro.app.ui.screens.calendario.CalendarioViewModel";

      static String com_climapro_app_ui_screens_mantenimientos_MantenimientoFormViewModel = "com.climapro.app.ui.screens.mantenimientos.MantenimientoFormViewModel";

      static String com_climapro_app_ui_screens_montajes_MontajeDetalleViewModel = "com.climapro.app.ui.screens.montajes.MontajeDetalleViewModel";

      static String com_climapro_app_ui_screens_mantenimientos_MantenimientosViewModel = "com.climapro.app.ui.screens.mantenimientos.MantenimientosViewModel";

      static String com_climapro_app_ui_screens_montajes_MontajesViewModel = "com.climapro.app.ui.screens.montajes.MontajesViewModel";

      static String com_climapro_app_ui_screens_consultas_ConsultasViewModel = "com.climapro.app.ui.screens.consultas.ConsultasViewModel";

      @KeepFieldType
      AjustesViewModel com_climapro_app_ui_screens_ajustes_AjustesViewModel2;

      @KeepFieldType
      MontajeFormViewModel com_climapro_app_ui_screens_montajes_MontajeFormViewModel2;

      @KeepFieldType
      HomeViewModel com_climapro_app_ui_screens_home_HomeViewModel2;

      @KeepFieldType
      MantenimientoDetalleViewModel com_climapro_app_ui_screens_mantenimientos_MantenimientoDetalleViewModel2;

      @KeepFieldType
      CalendarioViewModel com_climapro_app_ui_screens_calendario_CalendarioViewModel2;

      @KeepFieldType
      MantenimientoFormViewModel com_climapro_app_ui_screens_mantenimientos_MantenimientoFormViewModel2;

      @KeepFieldType
      MontajeDetalleViewModel com_climapro_app_ui_screens_montajes_MontajeDetalleViewModel2;

      @KeepFieldType
      MantenimientosViewModel com_climapro_app_ui_screens_mantenimientos_MantenimientosViewModel2;

      @KeepFieldType
      MontajesViewModel com_climapro_app_ui_screens_montajes_MontajesViewModel2;

      @KeepFieldType
      ConsultasViewModel com_climapro_app_ui_screens_consultas_ConsultasViewModel2;
    }
  }

  private static final class ViewModelCImpl extends ClimaPro_HiltComponents.ViewModelC {
    private final SingletonCImpl singletonCImpl;

    private final ActivityRetainedCImpl activityRetainedCImpl;

    private final ViewModelCImpl viewModelCImpl = this;

    private Provider<AjustesViewModel> ajustesViewModelProvider;

    private Provider<CalendarioViewModel> calendarioViewModelProvider;

    private Provider<ConsultasViewModel> consultasViewModelProvider;

    private Provider<HomeViewModel> homeViewModelProvider;

    private Provider<MantenimientoDetalleViewModel> mantenimientoDetalleViewModelProvider;

    private Provider<MantenimientoFormViewModel> mantenimientoFormViewModelProvider;

    private Provider<MantenimientosViewModel> mantenimientosViewModelProvider;

    private Provider<MontajeDetalleViewModel> montajeDetalleViewModelProvider;

    private Provider<MontajeFormViewModel> montajeFormViewModelProvider;

    private Provider<MontajesViewModel> montajesViewModelProvider;

    private ViewModelCImpl(SingletonCImpl singletonCImpl,
        ActivityRetainedCImpl activityRetainedCImpl, SavedStateHandle savedStateHandleParam,
        ViewModelLifecycle viewModelLifecycleParam) {
      this.singletonCImpl = singletonCImpl;
      this.activityRetainedCImpl = activityRetainedCImpl;

      initialize(savedStateHandleParam, viewModelLifecycleParam);

    }

    @SuppressWarnings("unchecked")
    private void initialize(final SavedStateHandle savedStateHandleParam,
        final ViewModelLifecycle viewModelLifecycleParam) {
      this.ajustesViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 0);
      this.calendarioViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 1);
      this.consultasViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 2);
      this.homeViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 3);
      this.mantenimientoDetalleViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 4);
      this.mantenimientoFormViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 5);
      this.mantenimientosViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 6);
      this.montajeDetalleViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 7);
      this.montajeFormViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 8);
      this.montajesViewModelProvider = new SwitchingProvider<>(singletonCImpl, activityRetainedCImpl, viewModelCImpl, 9);
    }

    @Override
    public Map<Class<?>, javax.inject.Provider<ViewModel>> getHiltViewModelMap() {
      return LazyClassKeyMap.<javax.inject.Provider<ViewModel>>of(MapBuilder.<String, javax.inject.Provider<ViewModel>>newMapBuilder(10).put(LazyClassKeyProvider.com_climapro_app_ui_screens_ajustes_AjustesViewModel, ((Provider) ajustesViewModelProvider)).put(LazyClassKeyProvider.com_climapro_app_ui_screens_calendario_CalendarioViewModel, ((Provider) calendarioViewModelProvider)).put(LazyClassKeyProvider.com_climapro_app_ui_screens_consultas_ConsultasViewModel, ((Provider) consultasViewModelProvider)).put(LazyClassKeyProvider.com_climapro_app_ui_screens_home_HomeViewModel, ((Provider) homeViewModelProvider)).put(LazyClassKeyProvider.com_climapro_app_ui_screens_mantenimientos_MantenimientoDetalleViewModel, ((Provider) mantenimientoDetalleViewModelProvider)).put(LazyClassKeyProvider.com_climapro_app_ui_screens_mantenimientos_MantenimientoFormViewModel, ((Provider) mantenimientoFormViewModelProvider)).put(LazyClassKeyProvider.com_climapro_app_ui_screens_mantenimientos_MantenimientosViewModel, ((Provider) mantenimientosViewModelProvider)).put(LazyClassKeyProvider.com_climapro_app_ui_screens_montajes_MontajeDetalleViewModel, ((Provider) montajeDetalleViewModelProvider)).put(LazyClassKeyProvider.com_climapro_app_ui_screens_montajes_MontajeFormViewModel, ((Provider) montajeFormViewModelProvider)).put(LazyClassKeyProvider.com_climapro_app_ui_screens_montajes_MontajesViewModel, ((Provider) montajesViewModelProvider)).build());
    }

    @Override
    public Map<Class<?>, Object> getHiltViewModelAssistedMap() {
      return Collections.<Class<?>, Object>emptyMap();
    }

    @IdentifierNameString
    private static final class LazyClassKeyProvider {
      static String com_climapro_app_ui_screens_home_HomeViewModel = "com.climapro.app.ui.screens.home.HomeViewModel";

      static String com_climapro_app_ui_screens_mantenimientos_MantenimientosViewModel = "com.climapro.app.ui.screens.mantenimientos.MantenimientosViewModel";

      static String com_climapro_app_ui_screens_montajes_MontajeFormViewModel = "com.climapro.app.ui.screens.montajes.MontajeFormViewModel";

      static String com_climapro_app_ui_screens_calendario_CalendarioViewModel = "com.climapro.app.ui.screens.calendario.CalendarioViewModel";

      static String com_climapro_app_ui_screens_montajes_MontajesViewModel = "com.climapro.app.ui.screens.montajes.MontajesViewModel";

      static String com_climapro_app_ui_screens_montajes_MontajeDetalleViewModel = "com.climapro.app.ui.screens.montajes.MontajeDetalleViewModel";

      static String com_climapro_app_ui_screens_ajustes_AjustesViewModel = "com.climapro.app.ui.screens.ajustes.AjustesViewModel";

      static String com_climapro_app_ui_screens_consultas_ConsultasViewModel = "com.climapro.app.ui.screens.consultas.ConsultasViewModel";

      static String com_climapro_app_ui_screens_mantenimientos_MantenimientoFormViewModel = "com.climapro.app.ui.screens.mantenimientos.MantenimientoFormViewModel";

      static String com_climapro_app_ui_screens_mantenimientos_MantenimientoDetalleViewModel = "com.climapro.app.ui.screens.mantenimientos.MantenimientoDetalleViewModel";

      @KeepFieldType
      HomeViewModel com_climapro_app_ui_screens_home_HomeViewModel2;

      @KeepFieldType
      MantenimientosViewModel com_climapro_app_ui_screens_mantenimientos_MantenimientosViewModel2;

      @KeepFieldType
      MontajeFormViewModel com_climapro_app_ui_screens_montajes_MontajeFormViewModel2;

      @KeepFieldType
      CalendarioViewModel com_climapro_app_ui_screens_calendario_CalendarioViewModel2;

      @KeepFieldType
      MontajesViewModel com_climapro_app_ui_screens_montajes_MontajesViewModel2;

      @KeepFieldType
      MontajeDetalleViewModel com_climapro_app_ui_screens_montajes_MontajeDetalleViewModel2;

      @KeepFieldType
      AjustesViewModel com_climapro_app_ui_screens_ajustes_AjustesViewModel2;

      @KeepFieldType
      ConsultasViewModel com_climapro_app_ui_screens_consultas_ConsultasViewModel2;

      @KeepFieldType
      MantenimientoFormViewModel com_climapro_app_ui_screens_mantenimientos_MantenimientoFormViewModel2;

      @KeepFieldType
      MantenimientoDetalleViewModel com_climapro_app_ui_screens_mantenimientos_MantenimientoDetalleViewModel2;
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
          case 0: // com.climapro.app.ui.screens.ajustes.AjustesViewModel 
          return (T) new AjustesViewModel(singletonCImpl.appPreferencesProvider.get(), singletonCImpl.updateCheckerProvider.get());

          case 1: // com.climapro.app.ui.screens.calendario.CalendarioViewModel 
          return (T) new CalendarioViewModel(singletonCImpl.montajeRepositoryProvider.get(), singletonCImpl.mantenimientoRepositoryProvider.get());

          case 2: // com.climapro.app.ui.screens.consultas.ConsultasViewModel 
          return (T) new ConsultasViewModel(singletonCImpl.montajeRepositoryProvider.get(), singletonCImpl.mantenimientoRepositoryProvider.get());

          case 3: // com.climapro.app.ui.screens.home.HomeViewModel 
          return (T) new HomeViewModel(singletonCImpl.montajeRepositoryProvider.get(), singletonCImpl.mantenimientoRepositoryProvider.get());

          case 4: // com.climapro.app.ui.screens.mantenimientos.MantenimientoDetalleViewModel 
          return (T) new MantenimientoDetalleViewModel(singletonCImpl.mantenimientoRepositoryProvider.get());

          case 5: // com.climapro.app.ui.screens.mantenimientos.MantenimientoFormViewModel 
          return (T) new MantenimientoFormViewModel(singletonCImpl.mantenimientoRepositoryProvider.get());

          case 6: // com.climapro.app.ui.screens.mantenimientos.MantenimientosViewModel 
          return (T) new MantenimientosViewModel(singletonCImpl.mantenimientoRepositoryProvider.get());

          case 7: // com.climapro.app.ui.screens.montajes.MontajeDetalleViewModel 
          return (T) new MontajeDetalleViewModel(singletonCImpl.montajeRepositoryProvider.get());

          case 8: // com.climapro.app.ui.screens.montajes.MontajeFormViewModel 
          return (T) new MontajeFormViewModel(singletonCImpl.montajeRepositoryProvider.get());

          case 9: // com.climapro.app.ui.screens.montajes.MontajesViewModel 
          return (T) new MontajesViewModel(singletonCImpl.montajeRepositoryProvider.get(), singletonCImpl.notificationSchedulerProvider.get());

          default: throw new AssertionError(id);
        }
      }
    }
  }

  private static final class ActivityRetainedCImpl extends ClimaPro_HiltComponents.ActivityRetainedC {
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

  private static final class ServiceCImpl extends ClimaPro_HiltComponents.ServiceC {
    private final SingletonCImpl singletonCImpl;

    private final ServiceCImpl serviceCImpl = this;

    private ServiceCImpl(SingletonCImpl singletonCImpl, Service serviceParam) {
      this.singletonCImpl = singletonCImpl;


    }
  }

  private static final class SingletonCImpl extends ClimaPro_HiltComponents.SingletonC {
    private final ApplicationContextModule applicationContextModule;

    private final SingletonCImpl singletonCImpl = this;

    private Provider<NotificationWorker_AssistedFactory> notificationWorker_AssistedFactoryProvider;

    private Provider<AppDatabase> provideDatabaseProvider;

    private Provider<MontajeRepository> montajeRepositoryProvider;

    private Provider<MantenimientoRepository> mantenimientoRepositoryProvider;

    private Provider<NotificationScheduler> notificationSchedulerProvider;

    private Provider<RescheduleWorker_AssistedFactory> rescheduleWorker_AssistedFactoryProvider;

    private Provider<AppPreferences> appPreferencesProvider;

    private Provider<OkHttpClient> provideOkHttpProvider;

    private Provider<Retrofit> provideRetrofitProvider;

    private Provider<UpdateApi> provideUpdateApiProvider;

    private Provider<UpdateChecker> updateCheckerProvider;

    private SingletonCImpl(ApplicationContextModule applicationContextModuleParam) {
      this.applicationContextModule = applicationContextModuleParam;
      initialize(applicationContextModuleParam);

    }

    private MontajeDao montajeDao() {
      return AppModule_ProvideMontajeDaoFactory.provideMontajeDao(provideDatabaseProvider.get());
    }

    private MantenimientoDao mantenimientoDao() {
      return AppModule_ProvideMantenimientoDaoFactory.provideMantenimientoDao(provideDatabaseProvider.get());
    }

    private Map<String, javax.inject.Provider<WorkerAssistedFactory<? extends ListenableWorker>>> mapOfStringAndProviderOfWorkerAssistedFactoryOf(
        ) {
      return MapBuilder.<String, javax.inject.Provider<WorkerAssistedFactory<? extends ListenableWorker>>>newMapBuilder(2).put("com.climapro.app.worker.NotificationWorker", ((Provider) notificationWorker_AssistedFactoryProvider)).put("com.climapro.app.worker.RescheduleWorker", ((Provider) rescheduleWorker_AssistedFactoryProvider)).build();
    }

    private HiltWorkerFactory hiltWorkerFactory() {
      return WorkerFactoryModule_ProvideFactoryFactory.provideFactory(mapOfStringAndProviderOfWorkerAssistedFactoryOf());
    }

    @SuppressWarnings("unchecked")
    private void initialize(final ApplicationContextModule applicationContextModuleParam) {
      this.notificationWorker_AssistedFactoryProvider = SingleCheck.provider(new SwitchingProvider<NotificationWorker_AssistedFactory>(singletonCImpl, 0));
      this.provideDatabaseProvider = DoubleCheck.provider(new SwitchingProvider<AppDatabase>(singletonCImpl, 3));
      this.montajeRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<MontajeRepository>(singletonCImpl, 2));
      this.mantenimientoRepositoryProvider = DoubleCheck.provider(new SwitchingProvider<MantenimientoRepository>(singletonCImpl, 4));
      this.notificationSchedulerProvider = DoubleCheck.provider(new SwitchingProvider<NotificationScheduler>(singletonCImpl, 5));
      this.rescheduleWorker_AssistedFactoryProvider = SingleCheck.provider(new SwitchingProvider<RescheduleWorker_AssistedFactory>(singletonCImpl, 1));
      this.appPreferencesProvider = DoubleCheck.provider(new SwitchingProvider<AppPreferences>(singletonCImpl, 6));
      this.provideOkHttpProvider = DoubleCheck.provider(new SwitchingProvider<OkHttpClient>(singletonCImpl, 10));
      this.provideRetrofitProvider = DoubleCheck.provider(new SwitchingProvider<Retrofit>(singletonCImpl, 9));
      this.provideUpdateApiProvider = DoubleCheck.provider(new SwitchingProvider<UpdateApi>(singletonCImpl, 8));
      this.updateCheckerProvider = DoubleCheck.provider(new SwitchingProvider<UpdateChecker>(singletonCImpl, 7));
    }

    @Override
    public void injectClimaPro(ClimaPro climaPro) {
      injectClimaPro2(climaPro);
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

    private ClimaPro injectClimaPro2(ClimaPro instance) {
      ClimaPro_MembersInjector.injectWorkerFactory(instance, hiltWorkerFactory());
      return instance;
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
          case 0: // com.climapro.app.worker.NotificationWorker_AssistedFactory 
          return (T) new NotificationWorker_AssistedFactory() {
            @Override
            public NotificationWorker create(Context context, WorkerParameters params) {
              return new NotificationWorker(context, params);
            }
          };

          case 1: // com.climapro.app.worker.RescheduleWorker_AssistedFactory 
          return (T) new RescheduleWorker_AssistedFactory() {
            @Override
            public RescheduleWorker create(Context context2, WorkerParameters params2) {
              return new RescheduleWorker(context2, params2, singletonCImpl.montajeRepositoryProvider.get(), singletonCImpl.mantenimientoRepositoryProvider.get(), singletonCImpl.notificationSchedulerProvider.get());
            }
          };

          case 2: // com.climapro.app.data.repository.MontajeRepository 
          return (T) new MontajeRepository(singletonCImpl.montajeDao());

          case 3: // com.climapro.app.data.db.AppDatabase 
          return (T) AppModule_ProvideDatabaseFactory.provideDatabase(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 4: // com.climapro.app.data.repository.MantenimientoRepository 
          return (T) new MantenimientoRepository(singletonCImpl.mantenimientoDao());

          case 5: // com.climapro.app.worker.NotificationScheduler 
          return (T) new NotificationScheduler(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 6: // com.climapro.app.data.preferences.AppPreferences 
          return (T) new AppPreferences(ApplicationContextModule_ProvideContextFactory.provideContext(singletonCImpl.applicationContextModule));

          case 7: // com.climapro.app.util.UpdateChecker 
          return (T) new UpdateChecker(singletonCImpl.provideUpdateApiProvider.get());

          case 8: // com.climapro.app.util.UpdateApi 
          return (T) AppModule_ProvideUpdateApiFactory.provideUpdateApi(singletonCImpl.provideRetrofitProvider.get());

          case 9: // retrofit2.Retrofit 
          return (T) AppModule_ProvideRetrofitFactory.provideRetrofit(singletonCImpl.provideOkHttpProvider.get());

          case 10: // okhttp3.OkHttpClient 
          return (T) AppModule_ProvideOkHttpFactory.provideOkHttp();

          default: throw new AssertionError(id);
        }
      }
    }
  }
}
