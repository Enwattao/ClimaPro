package com.climapro.app.ui.screens.ajustes;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010(\u001a\u00020)J\u001e\u0010*\u001a\u00020)2\u0006\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00122\u0006\u0010-\u001a\u00020\u0012J\u000e\u0010.\u001a\u00020)2\u0006\u0010/\u001a\u00020\bJ\u000e\u00100\u001a\u00020)2\u0006\u0010/\u001a\u00020\bJ\u000e\u00101\u001a\u00020)2\u0006\u0010/\u001a\u00020\bJ\u000e\u00102\u001a\u00020)2\u0006\u0010/\u001a\u00020\bR+\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0014R\u0017\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0014R\u0017\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0014R\u0017\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0014R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0014R\u0017\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R/\u0010\"\u001a\u0004\u0018\u00010!2\b\u0010\u0007\u001a\u0004\u0018\u00010!8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\'\u0010\u000f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\u00a8\u00063"}, d2 = {"Lcom/climapro/app/ui/screens/ajustes/AjustesViewModel;", "Landroidx/lifecycle/ViewModel;", "prefs", "Lcom/climapro/app/data/preferences/AppPreferences;", "updateChecker", "Lcom/climapro/app/util/UpdateChecker;", "(Lcom/climapro/app/data/preferences/AppPreferences;Lcom/climapro/app/util/UpdateChecker;)V", "<set-?>", "", "checkingUpdate", "getCheckingUpdate", "()Z", "setCheckingUpdate", "(Z)V", "checkingUpdate$delegate", "Landroidx/compose/runtime/MutableState;", "empresaDireccion", "Lkotlinx/coroutines/flow/StateFlow;", "", "getEmpresaDireccion", "()Lkotlinx/coroutines/flow/StateFlow;", "empresaNombre", "getEmpresaNombre", "empresaTelefono", "getEmpresaTelefono", "notif1h", "getNotif1h", "notif24h", "getNotif24h", "notifCobros", "getNotifCobros", "notifDia", "getNotifDia", "Lcom/climapro/app/util/UpdateInfo;", "updateInfo", "getUpdateInfo", "()Lcom/climapro/app/util/UpdateInfo;", "setUpdateInfo", "(Lcom/climapro/app/util/UpdateInfo;)V", "updateInfo$delegate", "checkUpdate", "Lkotlinx/coroutines/Job;", "save", "nombre", "tel", "dir", "setNotif1h", "v", "setNotif24h", "setNotifCobros", "setNotifDia", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AjustesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.preferences.AppPreferences prefs = null;
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.util.UpdateChecker updateChecker = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> empresaNombre = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> empresaTelefono = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.String> empresaDireccion = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> notif24h = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> notif1h = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> notifDia = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> notifCobros = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState updateInfo$delegate = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState checkingUpdate$delegate = null;
    
    @javax.inject.Inject()
    public AjustesViewModel(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.preferences.AppPreferences prefs, @org.jetbrains.annotations.NotNull()
    com.climapro.app.util.UpdateChecker updateChecker) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getEmpresaNombre() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getEmpresaTelefono() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.String> getEmpresaDireccion() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getNotif24h() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getNotif1h() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getNotifDia() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Boolean> getNotifCobros() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.climapro.app.util.UpdateInfo getUpdateInfo() {
        return null;
    }
    
    public final void setUpdateInfo(@org.jetbrains.annotations.Nullable()
    com.climapro.app.util.UpdateInfo p0) {
    }
    
    public final boolean getCheckingUpdate() {
        return false;
    }
    
    public final void setCheckingUpdate(boolean p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job save(@org.jetbrains.annotations.NotNull()
    java.lang.String nombre, @org.jetbrains.annotations.NotNull()
    java.lang.String tel, @org.jetbrains.annotations.NotNull()
    java.lang.String dir) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job setNotif24h(boolean v) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job setNotif1h(boolean v) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job setNotifDia(boolean v) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job setNotifCobros(boolean v) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job checkUpdate() {
        return null;
    }
}