package com.climapro.app.util;

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
public final class UpdateChecker_Factory implements Factory<UpdateChecker> {
  private final Provider<UpdateApi> apiProvider;

  public UpdateChecker_Factory(Provider<UpdateApi> apiProvider) {
    this.apiProvider = apiProvider;
  }

  @Override
  public UpdateChecker get() {
    return newInstance(apiProvider.get());
  }

  public static UpdateChecker_Factory create(Provider<UpdateApi> apiProvider) {
    return new UpdateChecker_Factory(apiProvider);
  }

  public static UpdateChecker newInstance(UpdateApi api) {
    return new UpdateChecker(api);
  }
}
