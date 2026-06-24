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
public final class MantenimientosViewModel_Factory implements Factory<MantenimientosViewModel> {
  private final Provider<MantenimientoRepository> repoProvider;

  public MantenimientosViewModel_Factory(Provider<MantenimientoRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public MantenimientosViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static MantenimientosViewModel_Factory create(
      Provider<MantenimientoRepository> repoProvider) {
    return new MantenimientosViewModel_Factory(repoProvider);
  }

  public static MantenimientosViewModel newInstance(MantenimientoRepository repo) {
    return new MantenimientosViewModel(repo);
  }
}
