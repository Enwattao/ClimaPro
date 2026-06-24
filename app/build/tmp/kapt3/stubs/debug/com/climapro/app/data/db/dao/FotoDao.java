package com.climapro.app.data.db.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001e\u0010\u0007\u001a\u00020\u00032\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u00a7@\u00a2\u0006\u0002\u0010\fJ$\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000f0\u000e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\'J\u0016\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006\u00a8\u0006\u0011"}, d2 = {"Lcom/climapro/app/data/db/dao/FotoDao;", "", "delete", "", "foto", "Lcom/climapro/app/data/db/entity/Foto;", "(Lcom/climapro/app/data/db/entity/Foto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteByTrabajo", "id", "", "tipo", "Lcom/climapro/app/data/db/entity/TipoTrabajo;", "(JLcom/climapro/app/data/db/entity/TipoTrabajo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByTrabajo", "Lkotlinx/coroutines/flow/Flow;", "", "insert", "app_debug"})
@androidx.room.Dao()
public abstract interface FotoDao {
    
    @androidx.room.Query(value = "SELECT * FROM fotos WHERE trabajoId = :id AND tipoTrabajo = :tipo ORDER BY tipoFoto ASC, fechaCaptura ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Foto>> getByTrabajo(long id, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.TipoTrabajo tipo);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Foto foto, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Foto foto, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM fotos WHERE trabajoId = :id AND tipoTrabajo = :tipo")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteByTrabajo(long id, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.TipoTrabajo tipo, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}