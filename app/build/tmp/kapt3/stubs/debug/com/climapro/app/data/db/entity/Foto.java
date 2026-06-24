package com.climapro.app.data.db.entity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0014\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B9\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0006H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\bH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\u0003H\u00c6\u0003JE\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\u0003H\u00c6\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\nH\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0007\u001a\u00020\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e\u00a8\u0006$"}, d2 = {"Lcom/climapro/app/data/db/entity/Foto;", "", "id", "", "trabajoId", "tipoTrabajo", "Lcom/climapro/app/data/db/entity/TipoTrabajo;", "tipoFoto", "Lcom/climapro/app/data/db/entity/TipoFoto;", "rutaArchivo", "", "fechaCaptura", "(JJLcom/climapro/app/data/db/entity/TipoTrabajo;Lcom/climapro/app/data/db/entity/TipoFoto;Ljava/lang/String;J)V", "getFechaCaptura", "()J", "getId", "getRutaArchivo", "()Ljava/lang/String;", "getTipoFoto", "()Lcom/climapro/app/data/db/entity/TipoFoto;", "getTipoTrabajo", "()Lcom/climapro/app/data/db/entity/TipoTrabajo;", "getTrabajoId", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
@androidx.room.Entity(tableName = "fotos")
public final class Foto {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    private final long trabajoId = 0L;
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.db.entity.TipoTrabajo tipoTrabajo = null;
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.db.entity.TipoFoto tipoFoto = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String rutaArchivo = null;
    private final long fechaCaptura = 0L;
    
    public Foto(long id, long trabajoId, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.TipoTrabajo tipoTrabajo, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.TipoFoto tipoFoto, @org.jetbrains.annotations.NotNull()
    java.lang.String rutaArchivo, long fechaCaptura) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    public final long getTrabajoId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.TipoTrabajo getTipoTrabajo() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.TipoFoto getTipoFoto() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getRutaArchivo() {
        return null;
    }
    
    public final long getFechaCaptura() {
        return 0L;
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final long component2() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.TipoTrabajo component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.TipoFoto component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    public final long component6() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.Foto copy(long id, long trabajoId, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.TipoTrabajo tipoTrabajo, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.TipoFoto tipoFoto, @org.jetbrains.annotations.NotNull()
    java.lang.String rutaArchivo, long fechaCaptura) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
}