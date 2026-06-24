package com.climapro.app.di;

import com.climapro.app.data.db.AppDatabase;
import com.climapro.app.data.db.dao.MontajeDao;
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
public final class AppModule_ProvideMontajeDaoFactory implements Factory<MontajeDao> {
  private final Provider<AppDatabase> dbProvider;

  public AppModule_ProvideMontajeDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public MontajeDao get() {
    return provideMontajeDao(dbProvider.get());
  }

  public static AppModule_ProvideMontajeDaoFactory create(Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvideMontajeDaoFactory(dbProvider);
  }

  public static MontajeDao provideMontajeDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideMontajeDao(db));
  }
}
