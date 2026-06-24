package com.climapro.app.data.db.entity

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.Index
import androidx.room.PrimaryKey

enum class EstadoMontaje { LISTA_ESPERA, PENDIENTE, EN_CURSO, REALIZADO, COBRADO }
enum class EstadoCobro { PENDIENTE, PARCIAL, COBRADO }
enum class MetodoPago { EFECTIVO, BIZUM, TRANSFERENCIA, TARJETA }
enum class TipoMaquina { SPLIT_PARED, SPLIT_CASSETTE, SPLIT_SUELO_TECHO, MULTI_SPLIT, CONDUCTOS, VRF, OTRO }

@Entity(
    tableName = "montajes",
    foreignKeys = [ForeignKey(
        entity = Cliente::class,
        parentColumns = ["id"],
        childColumns = ["clienteId"],
        onDelete = ForeignKey.SET_NULL
    )],
    indices = [Index("clienteId")]
)
data class Montaje(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val clienteId: Long? = null,
    val nombreCliente: String,
    val telefono: String,
    val direccion: String,
    val fecha: Long? = null,
    val hora: String = "",
    val horasEstimadas: Float = 0f,
    val marcaMaquina: String = "",
    val modeloMaquina: String = "",
    val tipoMaquina: TipoMaquina = TipoMaquina.SPLIT_PARED,
    val numMaquinas: Int = 1,
    val presupuesto: Double = 0.0,
    val costeMateriales: Double = 0.0,
    val importeCobrado: Double = 0.0,
    val estado: EstadoMontaje = EstadoMontaje.LISTA_ESPERA,
    val estadoCobro: EstadoCobro = EstadoCobro.PENDIENTE,
    val metodoPago: MetodoPago = MetodoPago.EFECTIVO,
    val fechaCobro: Long? = null,
    val fechaFinalizacion: Long? = null,
    val observaciones: String = "",
    val firmaPath: String? = null,
    val urgente: Boolean = false,
    val fechaCreacion: Long = System.currentTimeMillis()
) {
    val beneficio: Double get() = importeCobrado - costeMateriales
    val tieneCita: Boolean get() = fecha != null
}
