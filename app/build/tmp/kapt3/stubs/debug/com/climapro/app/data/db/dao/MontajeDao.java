package com.climapro.app.data.db.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u000e\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0003H\'J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u001c\u0010\u000f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0010\u001a\u00020\u0011H\'J\u001c\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0013\u001a\u00020\u0014H\'J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010\u0017J$\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\'J\u0014\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0014\u0010\u001c\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0014\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u0016\u0010\u001e\u001a\u00020\u00112\u0006\u0010\f\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\rJ \u0010\u001f\u001a\u0004\u0018\u00010 2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010!J \u0010\"\u001a\u0004\u0018\u00010 2\u0006\u0010\u0019\u001a\u00020\u00112\u0006\u0010\u001a\u001a\u00020\u0011H\u00a7@\u00a2\u0006\u0002\u0010!J\u0016\u0010#\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\r\u00a8\u0006$"}, d2 = {"Lcom/climapro/app/data/db/dao/MontajeDao;", "", "buscar", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/climapro/app/data/db/entity/Montaje;", "q", "", "countListaEspera", "", "delete", "", "montaje", "(Lcom/climapro/app/data/db/entity/Montaje;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "getByCliente", "clienteId", "", "getByEstado", "estado", "Lcom/climapro/app/data/db/entity/EstadoMontaje;", "getById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEnRango", "inicio", "fin", "getListaEspera", "getProgramados", "getRealizados", "insert", "sumCobrado", "", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sumPresupuesto", "update", "app_debug"})
@androidx.room.Dao()
public abstract interface MontajeDao {
    
    @androidx.room.Query(value = "SELECT * FROM montajes ORDER BY fecha ASC, fechaCreacion DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Montaje>> getAll();
    
    @androidx.room.Query(value = "SELECT * FROM montajes WHERE estado = :estado ORDER BY fechaCreacion DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Montaje>> getByEstado(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.EstadoMontaje estado);
    
    @androidx.room.Query(value = "SELECT * FROM montajes WHERE fecha IS NULL ORDER BY fechaCreacion DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Montaje>> getListaEspera();
    
    @androidx.room.Query(value = "SELECT * FROM montajes WHERE fecha IS NOT NULL ORDER BY fecha ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Montaje>> getProgramados();
    
    @androidx.room.Query(value = "SELECT * FROM montajes WHERE estado IN (\'REALIZADO\',\'COBRADO\') ORDER BY fechaFinalizacion DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Montaje>> getRealizados();
    
    @androidx.room.Query(value = "SELECT * FROM montajes WHERE fecha BETWEEN :inicio AND :fin ORDER BY fecha ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Montaje>> getEnRango(long inicio, long fin);
    
    @androidx.room.Query(value = "SELECT * FROM montajes WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.climapro.app.data.db.entity.Montaje> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM montajes WHERE clienteId = :clienteId ORDER BY fechaCreacion DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Montaje>> getByCliente(long clienteId);
    
    @androidx.room.Query(value = "\n        SELECT * FROM montajes WHERE\n        nombreCliente LIKE \'%\' || :q || \'%\' OR\n        direccion LIKE \'%\' || :q || \'%\' OR\n        marcaMaquina LIKE \'%\' || :q || \'%\' OR\n        modeloMaquina LIKE \'%\' || :q || \'%\'\n        ORDER BY fechaCreacion DESC\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Montaje>> buscar(@org.jetbrains.annotations.NotNull()
    java.lang.String q);
    
    @androidx.room.Query(value = "SELECT SUM(presupuesto) FROM montajes WHERE fecha BETWEEN :inicio AND :fin")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sumPresupuesto(long inicio, long fin, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion);
    
    @androidx.room.Query(value = "SELECT SUM(importeCobrado) FROM montajes WHERE fecha BETWEEN :inicio AND :fin")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sumCobrado(long inicio, long fin, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion);
    
    @androidx.room.Query(value = "SELECT COUNT(*) FROM montajes WHERE fecha IS NULL")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Integer> countListaEspera();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Montaje montaje, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Montaje montaje, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Montaje montaje, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}