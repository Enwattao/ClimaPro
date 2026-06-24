package com.climapro.app.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J.\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u001a\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u00102\u0006\u0010\u0012\u001a\u00020\u000bJ\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0010J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0018J\u0012\u0010\u0019\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u0010J\u001a\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u00102\u0006\u0010\u001b\u001a\u00020\tJ\u001a\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u00102\u0006\u0010\u001d\u001a\u00020\u001eJ\u0018\u0010\u001f\u001a\u0004\u0018\u00010\u00062\u0006\u0010 \u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010!J\"\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u00102\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tJ\u0012\u0010%\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u0010J\u0012\u0010&\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u0010J\u0012\u0010\'\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00110\u0010J\u0016\u0010(\u001a\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0018J\u001e\u0010)\u001a\u00020*2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010+J\u001e\u0010,\u001a\u00020*2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010+J\u0016\u0010-\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0006H\u0086@\u00a2\u0006\u0002\u0010\u0018R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006."}, d2 = {"Lcom/climapro/app/data/repository/MontajeRepository;", "", "dao", "Lcom/climapro/app/data/db/dao/MontajeDao;", "(Lcom/climapro/app/data/db/dao/MontajeDao;)V", "asignarCita", "Lcom/climapro/app/data/db/entity/Montaje;", "montaje", "fecha", "", "hora", "", "horasEstimadas", "", "(Lcom/climapro/app/data/db/entity/Montaje;JLjava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "buscar", "Lkotlinx/coroutines/flow/Flow;", "", "q", "countListaEspera", "", "delete", "", "m", "(Lcom/climapro/app/data/db/entity/Montaje;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "getByCliente", "clienteId", "getByEstado", "estado", "Lcom/climapro/app/data/db/entity/EstadoMontaje;", "getById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEnRango", "inicio", "fin", "getListaEspera", "getProgramados", "getRealizados", "insert", "sumCobrado", "", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sumPresupuesto", "update", "app_debug"})
public final class MontajeRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.db.dao.MontajeDao dao = null;
    
    @javax.inject.Inject()
    public MontajeRepository(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.dao.MontajeDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Montaje>> getAll() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Montaje>> getListaEspera() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Montaje>> getProgramados() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Montaje>> getRealizados() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Montaje>> getByEstado(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.EstadoMontaje estado) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Montaje>> getEnRango(long inicio, long fin) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Montaje>> getByCliente(long clienteId) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Montaje>> buscar(@org.jetbrains.annotations.NotNull()
    java.lang.String q) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.lang.Integer> countListaEspera() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.climapro.app.data.db.entity.Montaje> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Montaje m, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Montaje m, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Montaje m, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sumPresupuesto(long inicio, long fin, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sumCobrado(long inicio, long fin, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object asignarCita(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Montaje montaje, long fecha, @org.jetbrains.annotations.NotNull()
    java.lang.String hora, float horasEstimadas, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.climapro.app.data.db.entity.Montaje> $completion) {
        return null;
    }
}