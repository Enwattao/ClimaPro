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
public final class MontajeFormViewModel_Factory implements Factory<MontajeFormViewModel> {
  private final Provider<MontajeRepository> repoProvider;

  public MontajeFormViewModel_Factory(Provider<MontajeRepository> repoProvider) {
    this.repoProvider = repoProvider;
  }

  @Override
  public MontajeFormViewModel get() {
    return newInstance(repoProvider.get());
  }

  public static MontajeFormViewModel_Factory create(Provider<MontajeRepository> repoProvider) {
    return new MontajeFormViewModel_Factory(repoProvider);
  }

  public static MontajeFormViewModel newInstance(MontajeRepository repo) {
    return new MontajeFormViewModel(repo);
  }
}
