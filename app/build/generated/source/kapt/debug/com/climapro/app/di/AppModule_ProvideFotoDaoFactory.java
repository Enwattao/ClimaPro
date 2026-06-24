package com.climapro.app.di;

import com.climapro.app.data.db.AppDatabase;
import com.climapro.app.data.db.dao.FotoDao;
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
public final class AppModule_ProvideFotoDaoFactory implements Factory<FotoDao> {
  private final Provider<AppDatabase> dbProvider;

  public AppModule_ProvideFotoDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public FotoDao get() {
    return provideFotoDao(dbProvider.get());
  }

  public static AppModule_ProvideFotoDaoFactory create(Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvideFotoDaoFactory(dbProvider);
  }

  public static FotoDao provideFotoDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideFotoDao(db));
  }
}
