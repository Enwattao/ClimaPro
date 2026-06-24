package com.climapro.app.data.db.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J$\u0010\u0007\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t0\b2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\'J\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u00a7@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0012"}, d2 = {"Lcom/climapro/app/data/db/dao/AlbaranDao;", "", "delete", "", "a", "Lcom/climapro/app/data/db/entity/Albaran;", "(Lcom/climapro/app/data/db/entity/Albaran;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByTrabajo", "Lkotlinx/coroutines/flow/Flow;", "", "id", "", "tipo", "Lcom/climapro/app/data/db/entity/TipoTrabajo;", "getUltimoNumero", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insert", "app_debug"})
@androidx.room.Dao()
public abstract interface AlbaranDao {
    
    @androidx.room.Query(value = "SELECT * FROM albaranes WHERE trabajoId = :id AND tipoTrabajo = :tipo ORDER BY fechaGeneracion DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Albaran>> getByTrabajo(long id, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.TipoTrabajo tipo);
    
    @androidx.room.Query(value = "SELECT MAX(CAST(SUBSTR(numero, 4) AS INTEGER)) FROM albaranes WHERE numero LIKE \'ALB%\'")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object getUltimoNumero(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Integer> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Albaran a, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Albaran a, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}