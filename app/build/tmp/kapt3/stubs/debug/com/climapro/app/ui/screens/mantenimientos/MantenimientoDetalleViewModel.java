package com.climapro.app.ui.screens.mantenimientos;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001c\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u000e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0007J\u001e\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001aJ\u000e\u0010\u001b\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0007R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001c"}, d2 = {"Lcom/climapro/app/ui/screens/mantenimientos/MantenimientoDetalleViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/climapro/app/data/repository/MantenimientoRepository;", "(Lcom/climapro/app/data/repository/MantenimientoRepository;)V", "_m", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/climapro/app/data/db/entity/Mantenimiento;", "mantenimiento", "Lkotlinx/coroutines/flow/StateFlow;", "getMantenimiento", "()Lkotlinx/coroutines/flow/StateFlow;", "cargar", "Lkotlinx/coroutines/Job;", "id", "", "eliminar", "m", "onDone", "Lkotlin/Function0;", "", "generarSiguiente", "marcarCobrado", "importe", "", "metodo", "Lcom/climapro/app/data/db/entity/MetodoPago;", "marcarRealizado", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MantenimientoDetalleViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.repository.MantenimientoRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.climapro.app.data.db.entity.Mantenimiento> _m = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.climapro.app.data.db.entity.Mantenimiento> mantenimiento = null;
    
    @javax.inject.Inject()
    public MantenimientoDetalleViewModel(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.repository.MantenimientoRepository repo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.climapro.app.data.db.entity.Mantenimiento> getMantenimiento() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job cargar(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job eliminar(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Mantenimiento m, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job marcarRealizado(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Mantenimiento m) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job marcarCobrado(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Mantenimiento m, double importe, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.MetodoPago metodo) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job generarSiguiente(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Mantenimiento m) {
        return null;
    }
}