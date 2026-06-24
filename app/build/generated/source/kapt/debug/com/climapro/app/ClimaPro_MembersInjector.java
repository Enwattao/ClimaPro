package com.climapro.app;

import androidx.hilt.work.HiltWorkerFactory;
import dagger.MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

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
public final class ClimaPro_MembersInjector implements MembersInjector<ClimaPro> {
  private final Provider<HiltWorkerFactory> workerFactoryProvider;

  public ClimaPro_MembersInjector(Provider<HiltWorkerFactory> workerFactoryProvider) {
    this.workerFactoryProvider = workerFactoryProvider;
  }

  public static MembersInjector<ClimaPro> create(
      Provider<HiltWorkerFactory> workerFactoryProvider) {
    return new ClimaPro_MembersInjector(workerFactoryProvider);
  }

  @Override
  public void injectMembers(ClimaPro instance) {
    injectWorkerFactory(instance, workerFactoryProvider.get());
  }

  @InjectedFieldSignature("com.climapro.app.ClimaPro.workerFactory")
  public static void injectWorkerFactory(ClimaPro instance, HiltWorkerFactory workerFactory) {
    instance.workerFactory = workerFactory;
  }
}
