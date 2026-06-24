package com.climapro.app.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\"\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\f0\u000b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J\u0016\u0010\u0011\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/climapro/app/data/repository/FotoRepository;", "", "dao", "Lcom/climapro/app/data/db/dao/FotoDao;", "(Lcom/climapro/app/data/db/dao/FotoDao;)V", "delete", "", "foto", "Lcom/climapro/app/data/db/entity/Foto;", "(Lcom/climapro/app/data/db/entity/Foto;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByTrabajo", "Lkotlinx/coroutines/flow/Flow;", "", "id", "", "tipo", "Lcom/climapro/app/data/db/entity/TipoTrabajo;", "insert", "app_debug"})
public final class FotoRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.db.dao.FotoDao dao = null;
    
    @javax.inject.Inject()
    public FotoRepository(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.dao.FotoDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Foto>> getByTrabajo(long id, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.TipoTrabajo tipo) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Foto foto, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Foto foto, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
}