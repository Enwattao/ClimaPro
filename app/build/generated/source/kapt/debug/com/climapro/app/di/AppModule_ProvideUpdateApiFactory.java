package com.climapro.app.di;

import com.climapro.app.util.UpdateApi;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import retrofit2.Retrofit;

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
public final class AppModule_ProvideUpdateApiFactory implements Factory<UpdateApi> {
  private final Provider<Retrofit> retrofitProvider;

  public AppModule_ProvideUpdateApiFactory(Provider<Retrofit> retrofitProvider) {
    this.retrofitProvider = retrofitProvider;
  }

  @Override
  public UpdateApi get() {
    return provideUpdateApi(retrofitProvider.get());
  }

  public static AppModule_ProvideUpdateApiFactory create(Provider<Retrofit> retrofitProvider) {
    return new AppModule_ProvideUpdateApiFactory(retrofitProvider);
  }

  public static UpdateApi provideUpdateApi(Retrofit retrofit) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideUpdateApi(retrofit));
  }
}
