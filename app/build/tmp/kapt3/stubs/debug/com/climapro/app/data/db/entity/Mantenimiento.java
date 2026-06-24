package com.climapro.app.data.db.entity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b9\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u00c5\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u000f\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0015\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0017\u0012\b\b\u0002\u0010\u0018\u001a\u00020\u0019\u0012\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u001c\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u001dJ\t\u0010=\u001a\u00020\u0003H\u00c6\u0003J\t\u0010>\u001a\u00020\u000fH\u00c6\u0003J\t\u0010?\u001a\u00020\u000fH\u00c6\u0003J\t\u0010@\u001a\u00020\u000fH\u00c6\u0003J\t\u0010A\u001a\u00020\u0013H\u00c6\u0003J\t\u0010B\u001a\u00020\u0015H\u00c6\u0003J\t\u0010C\u001a\u00020\u0017H\u00c6\u0003J\t\u0010D\u001a\u00020\u0019H\u00c6\u0003J\u0010\u0010E\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\u000b\u0010F\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010G\u001a\u00020\u0003H\u00c6\u0003J\u0010\u0010H\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\t\u0010I\u001a\u00020\u0006H\u00c6\u0003J\t\u0010J\u001a\u00020\u0006H\u00c6\u0003J\t\u0010K\u001a\u00020\u0006H\u00c6\u0003J\u0010\u0010L\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010\"J\t\u0010M\u001a\u00020\u0006H\u00c6\u0003J\t\u0010N\u001a\u00020\fH\u00c6\u0003J\t\u0010O\u001a\u00020\u0006H\u00c6\u0003J\u00d4\u0001\u0010P\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\n\b\u0002\u0010\u001a\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u001c\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010QJ\u0013\u0010R\u001a\u00020S2\b\u0010T\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010U\u001a\u00020VH\u00d6\u0001J\t\u0010W\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010\u001e\u001a\u00020\u000f8F\u00a2\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b!\u0010\"R\u0011\u0010\u0010\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010 R\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010(R\u0011\u0010\u0016\u001a\u00020\u0017\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b+\u0010\"R\u0015\u0010\u001a\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010#\u001a\u0004\b,\u0010\"R\u0011\u0010\u001c\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b-\u0010.R\u0013\u0010\u001b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b/\u0010&R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u0010&R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b1\u0010.R\u0011\u0010\u0011\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b2\u0010 R\u0011\u0010\u0018\u001a\u00020\u0019\u00a2\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b5\u0010&R\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b6\u0010&R\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u00108R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010 R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b:\u0010&R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u0010<\u00a8\u0006X"}, d2 = {"Lcom/climapro/app/data/db/entity/Mantenimiento;", "", "id", "", "clienteId", "nombreCliente", "", "telefono", "direccion", "fecha", "hora", "tipoMantenimiento", "Lcom/climapro/app/data/db/entity/TipoMantenimiento;", "observaciones", "precio", "", "costeMateriales", "importeCobrado", "periodicidad", "Lcom/climapro/app/data/db/entity/Periodicidad;", "estado", "Lcom/climapro/app/data/db/entity/EstadoMantenimiento;", "estadoCobro", "Lcom/climapro/app/data/db/entity/EstadoCobro;", "metodoPago", "Lcom/climapro/app/data/db/entity/MetodoPago;", "fechaCobro", "firmaPath", "fechaCreacion", "(JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/climapro/app/data/db/entity/TipoMantenimiento;Ljava/lang/String;DDDLcom/climapro/app/data/db/entity/Periodicidad;Lcom/climapro/app/data/db/entity/EstadoMantenimiento;Lcom/climapro/app/data/db/entity/EstadoCobro;Lcom/climapro/app/data/db/entity/MetodoPago;Ljava/lang/Long;Ljava/lang/String;J)V", "beneficio", "getBeneficio", "()D", "getClienteId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCosteMateriales", "getDireccion", "()Ljava/lang/String;", "getEstado", "()Lcom/climapro/app/data/db/entity/EstadoMantenimiento;", "getEstadoCobro", "()Lcom/climapro/app/data/db/entity/EstadoCobro;", "getFecha", "getFechaCobro", "getFechaCreacion", "()J", "getFirmaPath", "getHora", "getId", "getImporteCobrado", "getMetodoPago", "()Lcom/climapro/app/data/db/entity/MetodoPago;", "getNombreCliente", "getObservaciones", "getPeriodicidad", "()Lcom/climapro/app/data/db/entity/Periodicidad;", "getPrecio", "getTelefono", "getTipoMantenimiento", "()Lcom/climapro/app/data/db/entity/TipoMantenimiento;", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Lcom/climapro/app/data/db/entity/TipoMantenimiento;Ljava/lang/String;DDDLcom/climapro/app/data/db/entity/Periodicidad;Lcom/climapro/app/data/db/entity/EstadoMantenimiento;Lcom/climapro/app/data/db/entity/EstadoCobro;Lcom/climapro/app/data/db/entity/MetodoPago;Ljava/lang/Long;Ljava/lang/String;J)Lcom/climapro/app/data/db/entity/Mantenimiento;", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
@androidx.room.Entity(tableName = "mantenimientos", foreignKeys = {@androidx.room.ForeignKey(entity = com.climapro.app.data.db.entity.Cliente.class, parentColumns = {"id"}, childColumns = {"clienteId"}, onDelete = 3)}, indices = {@androidx.room.Index(value = {"clienteId"})})
public final class Mantenimiento {
    @androidx.room.PrimaryKey(autoGenerate = true)
    private final long id = 0L;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long clienteId = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String nombreCliente = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String telefono = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String direccion = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long fecha = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String hora = null;
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.db.entity.TipoMantenimiento tipoMantenimiento = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String observaciones = null;
    private final double precio = 0.0;
    private final double costeMateriales = 0.0;
    private final double importeCobrado = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.db.entity.Periodicidad periodicidad = null;
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.db.entity.EstadoMantenimiento estado = null;
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.db.entity.EstadoCobro estadoCobro = null;
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.db.entity.MetodoPago metodoPago = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long fechaCobro = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String firmaPath = null;
    private final long fechaCreacion = 0L;
    
    public Mantenimiento(long id, @org.jetbrains.annotations.Nullable()
    java.lang.Long clienteId, @org.jetbrains.annotations.NotNull()
    java.lang.String nombreCliente, @org.jetbrains.annotations.NotNull()
    java.lang.String telefono, @org.jetbrains.annotations.NotNull()
    java.lang.String direccion, @org.jetbrains.annotations.Nullable()
    java.lang.Long fecha, @org.jetbrains.annotations.NotNull()
    java.lang.String hora, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.TipoMantenimiento tipoMantenimiento, @org.jetbrains.annotations.NotNull()
    java.lang.String observaciones, double precio, double costeMateriales, double importeCobrado, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Periodicidad periodicidad, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.EstadoMantenimiento estado, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.EstadoCobro estadoCobro, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.MetodoPago metodoPago, @org.jetbrains.annotations.Nullable()
    java.lang.Long fechaCobro, @org.jetbrains.annotations.Nullable()
    java.lang.String firmaPath, long fechaCreacion) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getClienteId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNombreCliente() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTelefono() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDireccion() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getFecha() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getHora() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.TipoMantenimiento getTipoMantenimiento() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getObservaciones() {
        return null;
    }
    
    public final double getPrecio() {
        return 0.0;
    }
    
    public final double getCosteMateriales() {
        return 0.0;
    }
    
    public final double getImporteCobrado() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.Periodicidad getPeriodicidad() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.EstadoMantenimiento getEstado() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.EstadoCobro getEstadoCobro() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.MetodoPago getMetodoPago() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long getFechaCobro() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFirmaPath() {
        return null;
    }
    
    public final long getFechaCreacion() {
        return 0L;
    }
    
    public final double getBeneficio() {
        return 0.0;
    }
    
    public final long component1() {
        return 0L;
    }
    
    public final double component10() {
        return 0.0;
    }
    
    public final double component11() {
        return 0.0;
    }
    
    public final double component12() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.Periodicidad component13() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.EstadoMantenimiento component14() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.EstadoCobro component15() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.MetodoPago component16() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component17() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component18() {
        return null;
    }
    
    public final long component19() {
        return 0L;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.TipoMantenimiento component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.Mantenimiento copy(long id, @org.jetbrains.annotations.Nullable()
    java.lang.Long clienteId, @org.jetbrains.annotations.NotNull()
    java.lang.String nombreCliente, @org.jetbrains.annotations.NotNull()
    java.lang.String telefono, @org.jetbrains.annotations.NotNull()
    java.lang.String direccion, @org.jetbrains.annotations.Nullable()
    java.lang.Long fecha, @org.jetbrains.annotations.NotNull()
    java.lang.String hora, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.TipoMantenimiento tipoMantenimiento, @org.jetbrains.annotations.NotNull()
    java.lang.String observaciones, double precio, double costeMateriales, double importeCobrado, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.Periodicidad periodicidad, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.EstadoMantenimiento estado, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.EstadoCobro estadoCobro, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.MetodoPago metodoPago, @org.jetbrains.annotations.Nullable()
    java.lang.Long fechaCobro, @org.jetbrains.annotations.Nullable()
    java.lang.String firmaPath, long fechaCreacion) {
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