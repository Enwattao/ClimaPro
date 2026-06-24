package com.climapro.app.ui.screens.montajes;

import com.climapro.app.data.repository.MontajeRepository;
import com.climapro.app.worker.NotificationScheduler;
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
public final class MontajesViewModel_Factory implements Factory<MontajesViewModel> {
  private final Provider<MontajeRepository> repoProvider;

  private final Provider<NotificationScheduler> schedulerProvider;

  public MontajesViewModel_Factory(Provider<MontajeRepository> repoProvider,
      Provider<NotificationScheduler> schedulerProvider) {
    this.repoProvider = repoProvider;
    this.schedulerProvider = schedulerProvider;
  }

  @Override
  public MontajesViewModel get() {
    return newInstance(repoProvider.get(), schedulerProvider.get());
  }

  public static MontajesViewModel_Factory create(Provider<MontajeRepository> repoProvider,
      Provider<NotificationScheduler> schedulerProvider) {
    return new MontajesViewModel_Factory(repoProvider, schedulerProvider);
  }

  public static MontajesViewModel newInstance(MontajeRepository repo,
      NotificationScheduler scheduler) {
    return new MontajesViewModel(repo, scheduler);
  }
}
