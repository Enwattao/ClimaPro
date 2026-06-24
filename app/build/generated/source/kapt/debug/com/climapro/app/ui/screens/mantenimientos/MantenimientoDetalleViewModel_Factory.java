package com.climapro.app.ui.screens.mantenimientos;

import com.climapro.app.data.repository.MantenimientoRepository;
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
public final class MantenimientoDetalleViewModel_Factory implements Factory<MantenimientoDetalleViewModel> {
  private final Provider<MantenimientoRepository> repoProvider;

  public MantenimientoDetalleViewModel_Factory(Provider<MantenimientoRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public MantenimientoDetalleViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static MantenimientoDetalleViewModel_Factory create(
      Provider<MantenimientoRepository> repoProvider) {
    return new MantenimientoDetalleViewModel_Factory(repoProvider);
  }

  public static MantenimientoDetalleViewModel newInstance(MantenimientoRepository repo) {
    return new MantenimientoDetalleViewModel(repo);
  }
}
