package com.climapro.app.ui.screens.montajes;

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
public final class MontajeDetalleViewModel_Factory implements Factory<MontajeDetalleViewModel> {
  private final Provider<MontajeRepository> repoProvider;

  public MontajeDetalleViewModel_Factory(Provider<MontajeRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public MontajeDetalleViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static MontajeDetalleViewModel_Factory create(Provider<MontajeRepository> repoProvider) {
    return new MontajeDetalleViewModel_Factory(repoProvider);
  }

  public static MontajeDetalleViewModel newInstance(MontajeRepository repo) {
    return new MontajeDetalleViewModel(repo);
  }
}
