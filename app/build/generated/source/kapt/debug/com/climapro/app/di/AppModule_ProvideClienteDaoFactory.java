package com.climapro.app.di;

import com.climapro.app.data.db.AppDatabase;
import com.climapro.app.data.db.dao.ClienteDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideClienteDaoFactory implements Factory<ClienteDao> {
  private final Provider<AppDatabase> dbProvider;

  public AppModule_ProvideClienteDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public ClienteDao get() {
    return provideClienteDao(dbProvider.get());
  }

  public static AppModule_ProvideClienteDaoFactory create(Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvideClienteDaoFactory(dbProvider);
  }

  public static ClienteDao provideClienteDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideClienteDao(db));
  }
}
