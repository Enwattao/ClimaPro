package com.climapro.app.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

enum class Periodicidad { SIN_REPETIR, MENSUAL, TRIMESTRAL, SEMESTRAL, ANUAL }
enum class TipoMantenimiento { LIMPIEZA, REVISION, RECARGA_GAS, REPARACION, PREVENTIVO, COMPLETO }
enum class EstadoMantenimiento { PENDIENTE, REALIZADO, COBRADO }

@Entity(
    tableName = "mantenimientos",
    foreignKeys = [ForeignKey(
        entity = Cliente::class,
        parentColumns = ["id"],
        childColumns = ["clienteId"],
        onDelete = ForeignKey.SET_NULL
    )],
    indices = [Index("clienteId")]
)
data class Mantenimiento(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val clienteId: Long? = null,
    val nombreCliente: String,
    val telefono: String,
    val direccion: String,
    val fecha: Long? = null,
    val hora: String = "",
    val tipoMantenimiento: TipoMantenimiento = TipoMantenimiento.REVISION,
    val observaciones: String = "",
    val precio: Double = 0.0,
    val costeMateriales: Double = 0.0,
    val importeCobrado: Double = 0.0,
    val periodicidad: Periodicidad = Periodicidad.ANUAL,
    val estado: EstadoMantenimiento = EstadoMantenimiento.PENDIENTE,
    val estadoCobro: EstadoCobro = EstadoCobro.PENDIENTE,
    val metodoPago: MetodoPago = MetodoPago.EFECTIVO,
    val fechaCobro: Long? = null,
    val firmaPath: String? = null,
    val fechaCreacion: Long = System.currentTimeMillis()
) {
    val beneficio: Double get() = importeCobrado - costeMateriales
}
