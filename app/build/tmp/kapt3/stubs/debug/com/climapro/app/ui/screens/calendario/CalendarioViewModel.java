package com.climapro.app.ui.screens.calendario;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u0018\u001a\u00020\u0019J\u0006\u0010\u001a\u001a\u00020\u0019R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00100\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001d\u0010\u0015\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00100\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000e\u00a8\u0006\u001b"}, d2 = {"Lcom/climapro/app/ui/screens/calendario/CalendarioViewModel;", "Landroidx/lifecycle/ViewModel;", "montajeRepo", "Lcom/climapro/app/data/repository/MontajeRepository;", "mantRepo", "Lcom/climapro/app/data/repository/MantenimientoRepository;", "(Lcom/climapro/app/data/repository/MontajeRepository;Lcom/climapro/app/data/repository/MantenimientoRepository;)V", "_anio", "Lkotlinx/coroutines/flow/MutableStateFlow;", "", "_mes", "anio", "Lkotlinx/coroutines/flow/StateFlow;", "getAnio", "()Lkotlinx/coroutines/flow/StateFlow;", "mantenimientos", "", "Lcom/climapro/app/data/db/entity/Mantenimiento;", "getMantenimientos", "mes", "getMes", "montajes", "Lcom/climapro/app/data/db/entity/Montaje;", "getMontajes", "anterior", "", "siguiente", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class CalendarioViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.repository.MontajeRepository montajeRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.repository.MantenimientoRepository mantRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _anio = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<java.lang.Integer> _mes = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> anio = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> mes = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.climapro.app.data.db.entity.Montaje>> montajes = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<java.util.List<com.climapro.app.data.db.entity.Mantenimiento>> mantenimientos = null;
    
    @javax.inject.Inject()
    public CalendarioViewModel(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.repository.MontajeRepository montajeRepo, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.repository.MantenimientoRepository mantRepo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getAnio() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.lang.Integer> getMes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.climapro.app.data.db.entity.Montaje>> getMontajes() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<java.util.List<com.climapro.app.data.db.entity.Mantenimiento>> getMantenimientos() {
        return null;
    }
    
    public final void anterior() {
    }
    
    public final void siguiente() {
    }
}