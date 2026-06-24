package com.climapro.app.di;

import com.climapro.app.data.db.AppDatabase;
import com.climapro.app.data.db.dao.AlbaranDao;
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
public final class AppModule_ProvideAlbaranDaoFactory implements Factory<AlbaranDao> {
  private final Provider<AppDatabase> dbProvider;

  public AppModule_ProvideAlbaranDaoFactory(Provider<AppDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public AlbaranDao get() {
    return provideAlbaranDao(dbProvider.get());
  }

  public static AppModule_ProvideAlbaranDaoFactory create(Provider<AppDatabase> dbProvider) {
    return new AppModule_ProvideAlbaranDaoFactory(dbProvider);
  }

  public static AlbaranDao provideAlbaranDao(AppDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideAlbaranDao(db));
  }
}
