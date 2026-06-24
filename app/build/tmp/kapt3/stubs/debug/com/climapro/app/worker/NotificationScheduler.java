package com.climapro.app.worker;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ8\u0010\t\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0002J\u000e\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u0014\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/climapro/app/worker/NotificationScheduler;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cancelMontaje", "", "id", "", "enqueue", "tag", "", "delayMs", "trabajoId", "tipo", "titulo", "cliente", "scheduleMantenimiento", "m", "Lcom/climapro/app/data/db/entity/Mantenimiento;", "scheduleMontaje", "montaje", "Lcom/climapro/app/data/db/entity/Montaje;", "app_debug"})
public final class NotificationScheduler {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    
    @javax.inject.Inject()
    public NotificationScheduler(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final void scheduleMontaje(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Montaje montaje) {
    }
    
    public final void scheduleMantenimiento(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Mantenimiento m) {
    }
    
    public final void cancelMontaje(long id) {
    }
    
    private final void enqueue(java.lang.String tag, long delayMs, long trabajoId, java.lang.String tipo, java.lang.String titulo, java.lang.String cliente) {
    }
}