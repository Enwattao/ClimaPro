package com.climapro.app.ui.screens.consultas;

import com.climapro.app.data.repository.MantenimientoRepository;
import com.climapro.app.data.repository.MontajeRepository;
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
public final class ConsultasViewModel_Factory implements Factory<ConsultasViewModel> {
  private final Provider<MontajeRepository> montajeRepoProvider;

  private final Provider<MantenimientoRepository> mantRepoProvider;

  public ConsultasViewModel_Factory(Provider<MontajeRepository> montajeRepoProvider,
      Provider<MantenimientoRepository> mantRepoProvider) {
    this.montajeRepoProvider = montajeRepoProvider;
    this.mantRepoProvider = mantRepoProvider;
  }

  @Override
  public ConsultasViewModel get() {
    return newInstance(montajeRepoProvider.get(), mantRepoProvider.get());
  }

  public static ConsultasViewModel_Factory create(Provider<MontajeRepository> montajeRepoProvider,
      Provider<MantenimientoRepository> mantRepoProvider) {
    return new ConsultasViewModel_Factory(montajeRepoProvider, mantRepoProvider);
  }

  public static ConsultasViewModel newInstance(MontajeRepository montajeRepo,
      MantenimientoRepository mantRepo) {
    return new ConsultasViewModel(montajeRepo, mantRepo);
  }
}
