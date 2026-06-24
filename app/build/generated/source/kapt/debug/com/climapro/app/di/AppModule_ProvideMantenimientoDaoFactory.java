package com.climapro.app.di;

import com.climapro.app.data.db.AppDatabase;
import com.climapro.app.data.db.dao.MantenimientoDao;
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
public final class AppModule_ProvideMantenimientoDaoFactory implements Factory<MantenimientoDao> {
  private final Provider<AppDatabase> dbProvider;

  public AppModule_ProvideMantenimientoDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public MantenimientoDao get() {
    return provideMantenimientoDao(dbProvider.get());
  }

  public static AppModule_ProvideMantenimientoDaoFactory create(Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvideMantenimientoDaoFactory(dbProvider);
  }

  public static MantenimientoDao provideMantenimientoDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideMantenimientoDao(db));
  }
}
