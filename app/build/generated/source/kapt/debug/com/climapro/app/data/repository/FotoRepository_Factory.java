package com.climapro.app.data.repository;

import com.climapro.app.data.db.dao.FotoDao;
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
public final class FotoRepository_Factory implements Factory<FotoRepository> {
  private final Provider<FotoDao> daoProvider;

  public FotoRepository_Factory(Provider<FotoDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public FotoRepository get() {
    return newInstance(daoProvider.get());
  }

  public static FotoRepository_Factory create(Provider<FotoDao> daoProvider) {
    return new FotoRepository_Factory(daoProvider);
  }

  public static FotoRepository newInstance(FotoDao dao) {
    return new FotoRepository(dao);
  }
}
