package com.climapro.app.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
import com.climapro.app.data.repository.MantenimientoRepository;
import com.climapro.app.data.repository.MontajeRepository;
import dagger.internal.DaggerGenerated;
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
public final class RescheduleWorker_Factory {
  private final Provider<MontajeRepository> montajeRepoProvider;

  private final Provider<MantenimientoRepository> mantRepoProvider;

  private final Provider<NotificationScheduler> schedulerProvider;

  public RescheduleWorker_Factory(Provider<MontajeRepository> montajeRepoProvider,
      Provider<MantenimientoRepository> mantRepoProvider,
      Provider<NotificationScheduler> schedulerProvider) {
    this.montajeRepoProvider = montajeRepoProvider;
    this.mantRepoProvider = mantRepoProvider;
    this.schedulerProvider = schedulerProvider;
  }

  public RescheduleWorker get(Context context, WorkerParameters params) {
    return newInstance(context, params, montajeRepoProvider.get(), mantRepoProvider.get(), schedulerProvider.get());
  }

  public static RescheduleWorker_Factory create(Provider<MontajeRepository> montajeRepoProvider,
      Provider<MantenimientoRepository> mantRepoProvider,
      Provider<NotificationScheduler> schedulerProvider) {
    return new RescheduleWorker_Factory(montajeRepoProvider, mantRepoProvider, schedulerProvider);
  }

  public static RescheduleWorker newInstance(Context context, WorkerParameters params,
      MontajeRepository montajeRepo, MantenimientoRepository mantRepo,
      NotificationScheduler scheduler) {
    return new RescheduleWorker(context, params, montajeRepo, mantRepo, scheduler);
  }
}
