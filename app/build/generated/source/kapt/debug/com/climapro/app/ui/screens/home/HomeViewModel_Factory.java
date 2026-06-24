package com.climapro.app.ui.screens.home;

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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<MontajeRepository> montajeRepoProvider;

  private final Provider<MantenimientoRepository> mantenimientoRepoProvider;

  public HomeViewModel_Factory(Provider<MontajeRepository> montajeRepoProvider,
      Provider<MantenimientoRepository> mantenimientoRepoProvider) {
    this.montajeRepoProvider = montajeRepoProvider;
    this.mantenimientoRepoProvider = mantenimientoRepoProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(montajeRepoProvider.get(), mantenimientoRepoProvider.get());
  }

  public static HomeViewModel_Factory create(Provider<MontajeRepository> montajeRepoProvider,
      Provider<MantenimientoRepository> mantenimientoRepoProvider) {
    return new HomeViewModel_Factory(montajeRepoProvider, mantenimientoRepoProvider);
  }

  public static HomeViewModel newInstance(MontajeRepository montajeRepo,
      MantenimientoRepository mantenimientoRepo) {
    return new HomeViewModel(montajeRepo, mantenimientoRepo);
  }
}
