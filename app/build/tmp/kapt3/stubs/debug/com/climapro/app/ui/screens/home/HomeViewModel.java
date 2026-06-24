package com.climapro.app.ui.screens.home;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\b\u0010\u000e\u001a\u00020\u000fH\u0002R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u0010"}, d2 = {"Lcom/climapro/app/ui/screens/home/HomeViewModel;", "Landroidx/lifecycle/ViewModel;", "montajeRepo", "Lcom/climapro/app/data/repository/MontajeRepository;", "mantenimientoRepo", "Lcom/climapro/app/data/repository/MantenimientoRepository;", "(Lcom/climapro/app/data/repository/MontajeRepository;Lcom/climapro/app/data/repository/MantenimientoRepository;)V", "_state", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/climapro/app/ui/screens/home/HomeUiState;", "state", "Lkotlinx/coroutines/flow/StateFlow;", "getState", "()Lkotlinx/coroutines/flow/StateFlow;", "cargarDatos", "", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class HomeViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.repository.MontajeRepository montajeRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.repository.MantenimientoRepository mantenimientoRepo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.climapro.app.ui.screens.home.HomeUiState> _state = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.climapro.app.ui.screens.home.HomeUiState> state = null;
    
    @javax.inject.Inject()
    public HomeViewModel(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.repository.MontajeRepository montajeRepo, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.repository.MantenimientoRepository mantenimientoRepo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.climapro.app.ui.screens.home.HomeUiState> getState() {
        return null;
    }
    
    private final void cargarDatos() {
    }
}