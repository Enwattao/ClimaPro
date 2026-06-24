package com.climapro.app.ui.screens.mantenimientos;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
@QualifierMetadata("dagger.hilt.android.internal.lifecycle.HiltViewModelMap.KeySet")
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
public final class MantenimientoDetalleViewModel_HiltModules_KeyModule_ProvideFactory implements Factory<Boolean> {
  @Override
  public Boolean get() {
    return provide();
  }

  public static MantenimientoDetalleViewModel_HiltModules_KeyModule_ProvideFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static boolean provide() {
    return MantenimientoDetalleViewModel_HiltModules.KeyModule.provide();
  }

  private static final class InstanceHolder {
    private static final MantenimientoDetalleViewModel_HiltModules_KeyModule_ProvideFactory INSTANCE = new MantenimientoDetalleViewModel_HiltModules_KeyModule_ProvideFactory();
  }
}
