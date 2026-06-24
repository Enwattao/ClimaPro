package com.climapro.app.data.repository;

import com.climapro.app.data.db.dao.AlbaranDao;
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
public final class AlbaranRepository_Factory implements Factory<AlbaranRepository> {
  private final Provider<AlbaranDao> daoProvider;

  public AlbaranRepository_Factory(Provider<AlbaranDao> daoProvider) {
    this.daoProvider = daoProvider;
  }

  @Override
  public AlbaranRepository get() {
    return newInstance(daoProvider.get());
  }

  public static AlbaranRepository_Factory create(Provider<AlbaranDao> daoProvider) {
    return new AlbaranRepository_Factory(daoProvider);
  }

  public static AlbaranRepository newInstance(AlbaranDao dao) {
    return new AlbaranRepository(dao);
  }
}
