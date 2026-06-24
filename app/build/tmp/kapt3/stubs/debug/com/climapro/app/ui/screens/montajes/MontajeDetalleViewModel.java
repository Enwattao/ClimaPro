package com.climapro.app.ui.screens.montajes;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u001c\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00072\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u001e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u000e\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0007R\u0016\u0010\u0005\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0019\u0010\b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/climapro/app/ui/screens/montajes/MontajeDetalleViewModel;", "Landroidx/lifecycle/ViewModel;", "repo", "Lcom/climapro/app/data/repository/MontajeRepository;", "(Lcom/climapro/app/data/repository/MontajeRepository;)V", "_montaje", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/climapro/app/data/db/entity/Montaje;", "montaje", "Lkotlinx/coroutines/flow/StateFlow;", "getMontaje", "()Lkotlinx/coroutines/flow/StateFlow;", "cargar", "Lkotlinx/coroutines/Job;", "id", "", "eliminar", "m", "onDone", "Lkotlin/Function0;", "", "marcarCobrado", "importe", "", "metodo", "Lcom/climapro/app/data/db/entity/MetodoPago;", "marcarRealizado", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class MontajeDetalleViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.repository.MontajeRepository repo = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.climapro.app.data.db.entity.Montaje> _montaje = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.climapro.app.data.db.entity.Montaje> montaje = null;
    
    @javax.inject.Inject()
    public MontajeDetalleViewModel(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.repository.MontajeRepository repo) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.climapro.app.data.db.entity.Montaje> getMontaje() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job cargar(long id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job eliminar(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Montaje m, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onDone) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job marcarRealizado(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Montaje m) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.Job marcarCobrado(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Montaje m, double importe, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.MetodoPago metodo) {
        return null;
    }
}