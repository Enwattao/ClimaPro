package com.climapro.app.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tJ\u000e\u0010\n\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\"\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00112\u0006\u0010\u0007\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/climapro/app/data/repository/AlbaranRepository;", "", "dao", "Lcom/climapro/app/data/db/dao/AlbaranDao;", "(Lcom/climapro/app/data/db/dao/AlbaranDao;)V", "delete", "", "a", "Lcom/climapro/app/data/db/entity/Albaran;", "(Lcom/climapro/app/data/db/entity/Albaran;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generarNumero", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getByTrabajo", "Lkotlinx/coroutines/flow/Flow;", "", "id", "", "tipo", "Lcom/climapro/app/data/db/entity/TipoTrabajo;", "insert", "app_debug"})
public final class AlbaranRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.db.dao.AlbaranDao dao = null;
    
    @javax.inject.Inject()
    public AlbaranRepository(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.dao.AlbaranDao dao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.climapro.app.data.db.entity.Albaran>> getByTrabajo(long id, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.TipoTrabajo tipo) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Albaran a, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Albaran a, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object generarNumero(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
}