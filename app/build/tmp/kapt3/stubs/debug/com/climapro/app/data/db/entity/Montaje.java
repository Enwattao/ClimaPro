package com.climapro.app.data.db.entity;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\bI\b\u0087\b\u0018\u00002\u00020\u0001B\u00f9\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0012\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0016\u001a\u00020\u0014\u0012\b\b\u0002\u0010\u0017\u001a\u00020\u0018\u0012\b\b\u0002\u0010\u0019\u001a\u00020\u001a\u0012\b\b\u0002\u0010\u001b\u001a\u00020\u001c\u0012\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u001f\u001a\u00020\u0006\u0012\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010!\u001a\u00020\"\u0012\b\b\u0002\u0010#\u001a\u00020\u0003\u00a2\u0006\u0002\u0010$J\t\u0010M\u001a\u00020\u0003H\u00c6\u0003J\t\u0010N\u001a\u00020\u0006H\u00c6\u0003J\t\u0010O\u001a\u00020\u0010H\u00c6\u0003J\t\u0010P\u001a\u00020\u0012H\u00c6\u0003J\t\u0010Q\u001a\u00020\u0014H\u00c6\u0003J\t\u0010R\u001a\u00020\u0014H\u00c6\u0003J\t\u0010S\u001a\u00020\u0014H\u00c6\u0003J\t\u0010T\u001a\u00020\u0018H\u00c6\u0003J\t\u0010U\u001a\u00020\u001aH\u00c6\u0003J\t\u0010V\u001a\u00020\u001cH\u00c6\u0003J\u0010\u0010W\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010X\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\u0010\u0010Y\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\t\u0010Z\u001a\u00020\u0006H\u00c6\u0003J\u000b\u0010[\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003J\t\u0010\\\u001a\u00020\"H\u00c6\u0003J\t\u0010]\u001a\u00020\u0003H\u00c6\u0003J\t\u0010^\u001a\u00020\u0006H\u00c6\u0003J\t\u0010_\u001a\u00020\u0006H\u00c6\u0003J\t\u0010`\u001a\u00020\u0006H\u00c6\u0003J\u0010\u0010a\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003\u00a2\u0006\u0002\u0010)J\t\u0010b\u001a\u00020\u0006H\u00c6\u0003J\t\u0010c\u001a\u00020\fH\u00c6\u0003J\t\u0010d\u001a\u00020\u0006H\u00c6\u0003J\u0088\u0002\u0010e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00062\b\b\u0002\u0010\u000e\u001a\u00020\u00062\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00142\b\b\u0002\u0010\u0016\u001a\u00020\u00142\b\b\u0002\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u001f\u001a\u00020\u00062\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u0003H\u00c6\u0001\u00a2\u0006\u0002\u0010fJ\u0013\u0010g\u001a\u00020\"2\b\u0010h\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010i\u001a\u00020\u0012H\u00d6\u0001J\t\u0010j\u001a\u00020\u0006H\u00d6\u0001R\u0011\u0010%\u001a\u00020\u00148F\u00a2\u0006\u0006\u001a\u0004\b&\u0010\'R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b(\u0010)R\u0011\u0010\u0015\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\'R\u0011\u0010\b\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0011\u0010\u0017\u001a\u00020\u0018\u00a2\u0006\b\n\u0000\u001a\u0004\b.\u0010/R\u0011\u0010\u0019\u001a\u00020\u001a\u00a2\u0006\b\n\u0000\u001a\u0004\b0\u00101R\u0015\u0010\t\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b2\u0010)R\u0015\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b3\u0010)R\u0011\u0010#\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b4\u00105R\u0015\u0010\u001e\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\n\n\u0002\u0010*\u001a\u0004\b6\u0010)R\u0013\u0010 \u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b7\u0010-R\u0011\u0010\n\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b8\u0010-R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b9\u0010:R\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b;\u00105R\u0011\u0010\u0016\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b<\u0010\'R\u0011\u0010\r\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b=\u0010-R\u0011\u0010\u001b\u001a\u00020\u001c\u00a2\u0006\b\n\u0000\u001a\u0004\b>\u0010?R\u0011\u0010\u000e\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b@\u0010-R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\bA\u0010-R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\bB\u0010CR\u0011\u0010\u001f\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\bD\u0010-R\u0011\u0010\u0013\u001a\u00020\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\bE\u0010\'R\u0011\u0010\u0007\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\bF\u0010-R\u0011\u0010G\u001a\u00020\"8F\u00a2\u0006\u0006\u001a\u0004\bH\u0010IR\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\bJ\u0010KR\u0011\u0010!\u001a\u00020\"\u00a2\u0006\b\n\u0000\u001a\u0004\bL\u0010I\u00a8\u0006k"}, d2 = {"Lcom/climapro/app/data/db/entity/Montaje;", "", "id", "", "clienteId", "nombreCliente", "", "telefono", "direccion", "fecha", "hora", "horasEstimadas", "", "marcaMaquina", "modeloMaquina", "tipoMaquina", "Lcom/climapro/app/data/db/entity/TipoMaquina;", "numMaquinas", "", "presupuesto", "", "costeMateriales", "importeCobrado", "estado", "Lcom/climapro/app/data/db/entity/EstadoMontaje;", "estadoCobro", "Lcom/climapro/app/data/db/entity/EstadoCobro;", "metodoPago", "Lcom/climapro/app/data/db/entity/MetodoPago;", "fechaCobro", "fechaFinalizacion", "observaciones", "firmaPath", "urgente", "", "fechaCreacion", "(JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;Lcom/climapro/app/data/db/entity/TipoMaquina;IDDDLcom/climapro/app/data/db/entity/EstadoMontaje;Lcom/climapro/app/data/db/entity/EstadoCobro;Lcom/climapro/app/data/db/entity/MetodoPago;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZJ)V", "beneficio", "getBeneficio", "()D", "getClienteId", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCosteMateriales", "getDireccion", "()Ljava/lang/String;", "getEstado", "()Lcom/climapro/app/data/db/entity/EstadoMontaje;", "getEstadoCobro", "()Lcom/climapro/app/data/db/entity/EstadoCobro;", "getFecha", "getFechaCobro", "getFechaCreacion", "()J", "getFechaFinalizacion", "getFirmaPath", "getHora", "getHorasEstimadas", "()F", "getId", "getImporteCobrado", "getMarcaMaquina", "getMetodoPago", "()Lcom/climapro/app/data/db/entity/MetodoPago;", "getModeloMaquina", "getNombreCliente", "getNumMaquinas", "()I", "getObservaciones", "getPresupuesto", "getTelefono", "tieneCita", "getTieneCita", "()Z", "getTipoMaquina", "()Lcom/climapro/app/data/db/entity/TipoMaquina;", "getUrgente", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(JLjava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;FLjava/lang/String;Ljava/lang/String;Lcom/climapro/app/data/db/entity/TipoMaquina;IDDDLcom/climapro/app/data/db/entity/EstadoMontaje;Lcom/climapro/app/data/db/entity/EstadoCobro;Lcom/climapro/app/data/db/entity/MetodoPago;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;ZJ)Lcom/climapro/app/data/db/entity/Montaje;", "equals", "other", "hashCode", "toString", "app_debug"})
@androidx.room.Entity(tableName = "montajes", foreignKeys = {@androidx.room.ForeignKey(entity = com.climapro.app.data.db.entity.Cliente.class, parentColumns = {"id"}, childColumns = {"clienteId"}, onDelete = 3)}, indices = {@androidx.room.Index(value = {"clienteId"})})
public final class Montaje {
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
    private final float horasEstimadas = 0.0F;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String marcaMaquina = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String modeloMaquina = null;
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.db.entity.TipoMaquina tipoMaquina = null;
    private final int numMaquinas = 0;
    private final double presupuesto = 0.0;
    private final double costeMateriales = 0.0;
    private final double importeCobrado = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.db.entity.EstadoMontaje estado = null;
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.db.entity.EstadoCobro estadoCobro = null;
    @org.jetbrains.annotations.NotNull()
    private final com.climapro.app.data.db.entity.MetodoPago metodoPago = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long fechaCobro = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Long fechaFinalizacion = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String observaciones = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String firmaPath = null;
    private final boolean urgente = false;
    private final long fechaCreacion = 0L;
    
    public Montaje(long id, @org.jetbrains.annotations.Nullable()
    java.lang.Long clienteId, @org.jetbrains.annotations.NotNull()
    java.lang.String nombreCliente, @org.jetbrains.annotations.NotNull()
    java.lang.String telefono, @org.jetbrains.annotations.NotNull()
    java.lang.String direccion, @org.jetbrains.annotations.Nullable()
    java.lang.Long fecha, @org.jetbrains.annotations.NotNull()
    java.lang.String hora, float horasEstimadas, @org.jetbrains.annotations.NotNull()
    java.lang.String marcaMaquina, @org.jetbrains.annotations.NotNull()
    java.lang.String modeloMaquina, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.TipoMaquina tipoMaquina, int numMaquinas, double presupuesto, double costeMateriales, double importeCobrado, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.EstadoMontaje estado, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.EstadoCobro estadoCobro, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.MetodoPago metodoPago, @org.jetbrains.annotations.Nullable()
    java.lang.Long fechaCobro, @org.jetbrains.annotations.Nullable()
    java.lang.Long fechaFinalizacion, @org.jetbrains.annotations.NotNull()
    java.lang.String observaciones, @org.jetbrains.annotations.Nullable()
    java.lang.String firmaPath, boolean urgente, long fechaCreacion) {
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
    
    public final float getHorasEstimadas() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getMarcaMaquina() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getModeloMaquina() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.TipoMaquina getTipoMaquina() {
        return null;
    }
    
    public final int getNumMaquinas() {
        return 0;
    }
    
    public final double getPresupuesto() {
        return 0.0;
    }
    
    public final double getCosteMateriales() {
        return 0.0;
    }
    
    public final double getImporteCobrado() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.EstadoMontaje getEstado() {
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
    public final java.lang.Long getFechaFinalizacion() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getObservaciones() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getFirmaPath() {
        return null;
    }
    
    public final boolean getUrgente() {
        return false;
    }
    
    public final long getFechaCreacion() {
        return 0L;
    }
    
    public final double getBeneficio() {
        return 0.0;
    }
    
    public final boolean getTieneCita() {
        return false;
    }
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component10() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.TipoMaquina component11() {
        return null;
    }
    
    public final int component12() {
        return 0;
    }
    
    public final double component13() {
        return 0.0;
    }
    
    public final double component14() {
        return 0.0;
    }
    
    public final double component15() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.EstadoMontaje component16() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.EstadoCobro component17() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.MetodoPago component18() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component19() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Long component20() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component21() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component22() {
        return null;
    }
    
    public final boolean component23() {
        return false;
    }
    
    public final long component24() {
        return 0L;
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
    
    public final float component8() {
        return 0.0F;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.climapro.app.data.db.entity.Montaje copy(long id, @org.jetbrains.annotations.Nullable()
    java.lang.Long clienteId, @org.jetbrains.annotations.NotNull()
    java.lang.String nombreCliente, @org.jetbrains.annotations.NotNull()
    java.lang.String telefono, @org.jetbrains.annotations.NotNull()
    java.lang.String direccion, @org.jetbrains.annotations.Nullable()
    java.lang.Long fecha, @org.jetbrains.annotations.NotNull()
    java.lang.String hora, float horasEstimadas, @org.jetbrains.annotations.NotNull()
    java.lang.String marcaMaquina, @org.jetbrains.annotations.NotNull()
    java.lang.String modeloMaquina, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.TipoMaquina tipoMaquina, int numMaquinas, double presupuesto, double costeMateriales, double importeCobrado, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.EstadoMontaje estado, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.EstadoCobro estadoCobro, @org.jetbrains.annotations.NotNull()
    com.climapro.app.data.db.entity.MetodoPago metodoPago, @org.jetbrains.annotations.Nullable()
    java.lang.Long fechaCobro, @org.jetbrains.annotations.Nullable()
    java.lang.Long fechaFinalizacion, @org.jetbrains.annotations.NotNull()
    java.lang.String observaciones, @org.jetbrains.annotations.Nullable()
    java.lang.String firmaPath, boolean urgente, long fechaCreacion) {
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