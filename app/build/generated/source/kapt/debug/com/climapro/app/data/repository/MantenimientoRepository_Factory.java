package com.climapro.app.data.repository;

import com.climapro.app.data.db.dao.MantenimientoDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class MantenimientoRepository_Factory implements Factory<MantenimientoRepository> {
  private final Provider<MantenimientoDao> daoProvider;

  public MantenimientoRepository_Factory(Provider<MantenimientoDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public MantenimientoRepository get() {
    return newInstance(daoProvider.get());
  }

  public static MantenimientoRepository_Factory create(Provider<MantenimientoDao> daoProvider) {
    return new MantenimientoRepository_Factory(daoProvider);
  }

  public static MantenimientoRepository newInstance(MantenimientoDao dao) {
    return new MantenimientoRepository(dao);
  }
}
