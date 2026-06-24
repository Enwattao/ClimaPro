package com.climapro.app.ui.screens.montajes;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J&\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0012\u001a\u00020\u0013J\u000e\u0010\u001c\u001a\u00020\u00112\u0006\u0010\u001d\u001a\u00020\u000bR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f\u00a8\u0006\u001e"}, d2 = {"Lcom/climapro/app/ui/screens/montajes/MontajesViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/climapro/app/data/repository/MontajeRepository;", "scheduler", "Lcom/climapro/app/worker/NotificationScheduler;", "(Lcom/climapro/app/data/repository/MontajeRepository;Lcom/climapro/app/worker/NotificationScheduler;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/climapro/app/ui/screens/montajes/MontajesUiState;", "_tab", "Lcom/climapro/app/ui/screens/montajes/MontajesTab;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "asignarCita", "", "montaje", "Lcom/climapro/app/data/db/entity/Montaje;", "fecha", "", "hora", "", "horasEstimadas", "", "eliminar", "Lkotlinx/coroutines/Job;", "setTab", "tab", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MontajesViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.repository.MontajeRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.worker.NotificationScheduler scheduler = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.climapro.app.ui.screens.montajes.MontajesTab> _tab = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.climapro.app.ui.screens.montajes.MontajesUiState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.climapro.app.ui.screens.montajes.MontajesUiState> state = null;
    
    @javax.inject.Inject()
    public MontajesViewModel(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.repository.MontajeRepository repo, @org.jetbrains.annotations.NotNull()
    com.climapro.app.worker.NotificationScheduler scheduler) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.climapro.app.ui.screens.montajes.MontajesUiState> getState() {
        return null;
    }
    
    public final void setTab(@org.jetbrains.annotations.NotNull()
    com.climapro.app.ui.screens.montajes.MontajesTab tab) {
    }
    
    public final void asignarCita(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Montaje montaje, long fecha, @org.jetbrains.annotations.NotNull()
    java.lang.String hora, float horasEstimadas) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job eliminar(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Montaje montaje) {
        return null;
    }
}