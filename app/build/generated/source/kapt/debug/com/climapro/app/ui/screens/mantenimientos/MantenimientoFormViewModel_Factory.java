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
public final class MantenimientoFormViewModel_Factory implements Factory<MantenimientoFormViewModel> {
  private final Provider<MantenimientoRepository> repoProvider;

  public MantenimientoFormViewModel_Factory(Provider<MantenimientoRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public MantenimientoFormViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static MantenimientoFormViewModel_Factory create(
      Provider<MantenimientoRepository> repoProvider) {
    return new MantenimientoFormViewModel_Factory(repoProvider);
  }

  public static MantenimientoFormViewModel newInstance(MantenimientoRepository repo) {
    return new MantenimientoFormViewModel(repo);
  }
}
