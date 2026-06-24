package com.climapro.app.data.db.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0006\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0006\u001a\u00020\u0007H\'J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u0003H\'J\u001c\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u000e\u001a\u00020\u000fH\'J\u001c\u0010\u0010\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0011\u001a\u00020\u0012H\'J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0014\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0015J$\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u00040\u00032\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\'J\u0016\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000bJ \u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u001cJ \u0010\u001d\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u001cJ\u0016\u0010\u001e\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u000b\u00a8\u0006\u001f"}, d2 = {"Lcom/climapro/app/data/db/dao/MantenimientoDao;", "", "buscar", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/climapro/app/data/db/entity/Mantenimiento;", "q", "", "delete", "", "m", "(Lcom/climapro/app/data/db/entity/Mantenimiento;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAll", "getByCliente", "clienteId", "", "getByEstado", "estado", "Lcom/climapro/app/data/db/entity/EstadoMantenimiento;", "getById", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getEnRango", "inicio", "fin", "insert", "sumCobrado", "", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sumPresupuesto", "update", "app_debug"})
@androidx.room.Dao()
public abstract interface MantenimientoDao {
    
    @androidx.room.Query(value = "SELECT * FROM mantenimientos ORDER BY fecha ASC, fechaCreacion DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Mantenimiento>> getAll();
    
    @androidx.room.Query(value = "SELECT * FROM mantenimientos WHERE estado = :estado ORDER BY fecha ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Mantenimiento>> getByEstado(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.EstadoMantenimiento estado);
    
    @androidx.room.Query(value = "SELECT * FROM mantenimientos WHERE fecha BETWEEN :inicio AND :fin ORDER BY fecha ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Mantenimiento>> getEnRango(long inicio, long fin);
    
    @androidx.room.Query(value = "SELECT * FROM mantenimientos WHERE id = :id")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.climapro.app.data.db.entity.Mantenimiento> $completion);
    
    @androidx.room.Query(value = "SELECT * FROM mantenimientos WHERE clienteId = :clienteId ORDER BY fechaCreacion DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Mantenimiento>> getByCliente(long clienteId);
    
    @androidx.room.Query(value = "\n        SELECT * FROM mantenimientos WHERE\n        nombreCliente LIKE \'%\' || :q || \'%\' OR\n        direccion LIKE \'%\' || :q || \'%\'\n        ORDER BY fecha DESC\n    ")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Mantenimiento>> buscar(@org.jetbrains.annotations.NotNull()
    java.lang.String q);
    
    @androidx.room.Query(value = "SELECT SUM(precio) FROM mantenimientos WHERE fecha BETWEEN :inicio AND :fin")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sumPresupuesto(long inicio, long fin, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion);
    
    @androidx.room.Query(value = "SELECT SUM(importeCobrado) FROM mantenimientos WHERE fecha BETWEEN :inicio AND :fin")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object sumCobrado(long inicio, long fin, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Mantenimiento m, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Update()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object update(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Mantenimiento m, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Mantenimiento m, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}