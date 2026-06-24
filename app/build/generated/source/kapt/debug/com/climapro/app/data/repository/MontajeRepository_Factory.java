package com.climapro.app.data.repository;

import com.climapro.app.data.db.dao.MontajeDao;
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
public final class MontajeRepository_Factory implements Factory<MontajeRepository> {
  private final Provider<MontajeDao> daoProvider;

  public MontajeRepository_Factory(Provider<MontajeDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public MontajeRepository get() {
    return newInstance(daoProvider.get());
  }

  public static MontajeRepository_Factory create(Provider<MontajeDao> daoProvider) {
    return new MontajeRepository_Factory(daoProvider);
  }

  public static MontajeRepository newInstance(MontajeDao dao) {
    return new MontajeRepository(dao);
  }
}
