package com.climapro.app.ui.screens.mantenimientos;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bJ\u000e\u0010\u0012\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\bR\u001d\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u001d\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u001d\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0013"}, d2 = {"Lcom/climapro/app/ui/screens/mantenimientos/MantenimientosViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/climapro/app/data/repository/MantenimientoRepository;", "(Lcom/climapro/app/data/repository/MantenimientoRepository;)V", "cobrados", "Lkotlinx/coroutines/flow/StateFlow;", "", "Lcom/climapro/app/data/db/entity/Mantenimiento;", "getCobrados", "()Lkotlinx/coroutines/flow/StateFlow;", "pendientes", "getPendientes", "realizados", "getRealizados", "eliminar", "Lkotlinx/coroutines/Job;", "m", "generarSiguiente", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MantenimientosViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.repository.MantenimientoRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.climapro.app.data.db.entity.Mantenimiento>> pendientes = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.climapro.app.data.db.entity.Mantenimiento>> realizados = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.climapro.app.data.db.entity.Mantenimiento>> cobrados = null;
    
    @javax.inject.Inject()
    public MantenimientosViewModel(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.repository.MantenimientoRepository repo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.climapro.app.data.db.entity.Mantenimiento>> getPendientes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.climapro.app.data.db.entity.Mantenimiento>> getRealizados() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.climapro.app.data.db.entity.Mantenimiento>> getCobrados() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job eliminar(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Mantenimiento m) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job generarSiguiente(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Mantenimiento m) {
        return null;
    }
}