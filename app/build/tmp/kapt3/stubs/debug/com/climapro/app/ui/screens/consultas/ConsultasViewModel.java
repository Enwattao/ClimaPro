package com.climapro.app.ui.screens.consultas;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u0017\u001a\u00020\u0018H\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R+\u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8F@FX\u0086\u008e\u0002\u00a2\u0006\u0012\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\t0\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016\u00a8\u0006\u0019"}, d2 = {"Lcom/climapro/app/ui/screens/consultas/ConsultasViewModel;", "Landroidx/lifecycle/ViewModel;", "montajeRepo", "Lcom/climapro/app/data/repository/MontajeRepository;", "mantRepo", "Lcom/climapro/app/data/repository/MantenimientoRepository;", "(Lcom/climapro/app/data/repository/MontajeRepository;Lcom/climapro/app/data/repository/MantenimientoRepository;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/climapro/app/ui/screens/consultas/ConsultasState;", "<set-?>", "", "query", "getQuery", "()Ljava/lang/String;", "setQuery", "(Ljava/lang/String;)V", "query$delegate", "Landroidx/compose/runtime/MutableState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "cargar", "Lkotlinx/coroutines/Job;", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class ConsultasViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.repository.MontajeRepository montajeRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.repository.MantenimientoRepository mantRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.climapro.app.ui.screens.consultas.ConsultasState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.climapro.app.ui.screens.consultas.ConsultasState> state = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.compose.runtime.MutableState query$delegate = null;
    
    @javax.inject.Inject()
    public ConsultasViewModel(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.repository.MontajeRepository montajeRepo, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.repository.MantenimientoRepository mantRepo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.climapro.app.ui.screens.consultas.ConsultasState> getState() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getQuery() {
        return null;
    }
    
    public final void setQuery(@org.jetbrains.annotations.NotNull()
    java.lang.String p0) {
    }
    
    private final kotlinx.coroutines.Job cargar() {
        return null;
    }
}