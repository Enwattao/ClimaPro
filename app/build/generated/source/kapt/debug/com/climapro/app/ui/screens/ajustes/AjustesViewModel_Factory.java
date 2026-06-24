package com.climapro.app.ui.screens.ajustes;

import com.climapro.app.data.preferences.AppPreferences;
import com.climapro.app.util.UpdateChecker;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class AjustesViewModel_Factory implements Factory<AjustesViewModel> {
  private final Provider<AppPreferences> prefsProvider;

  private final Provider<UpdateChecker> updateCheckerProvider;

  public AjustesViewModel_Factory(Provider<AppPreferences> prefsProvider,
      Provider<UpdateChecker> updateCheckerProvider) {
    this.prefsProvider = prefsProvider;
    this.updateCheckerProvider = updateCheckerProvider;
  }

  @Override
  public AjustesViewModel get() {
    return newInstance(prefsProvider.get(), updateCheckerProvider.get());
  }

  public static AjustesViewModel_Factory create(Provider<AppPreferences> prefsProvider,
      Provider<UpdateChecker> updateCheckerProvider) {
    return new AjustesViewModel_Factory(prefsProvider, updateCheckerProvider);
  }

  public static AjustesViewModel newInstance(AppPreferences prefs, UpdateChecker updateChecker) {
    return new AjustesViewModel(prefs, updateChecker);
  }
}
