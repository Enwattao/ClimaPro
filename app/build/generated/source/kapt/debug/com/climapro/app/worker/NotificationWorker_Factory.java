package com.climapro.app.worker;

import android.content.Context;
import androidx.work.WorkerParameters;
import dagger.internal.DaggerGenerated;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

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
public final class NotificationWorker_Factory {
  public NotificationWorker_Factory() {
  }

  public NotificationWorker get(Context context, WorkerParameters params) {
    return newInstance(context, params);
  }

  public static NotificationWorker_Factory create() {
    return new NotificationWorker_Factory();
  }

  public static NotificationWorker newInstance(Context context, WorkerParameters params) {
    return new NotificationWorker(context, params);
  }
}
