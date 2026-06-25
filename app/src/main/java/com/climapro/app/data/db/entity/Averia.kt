package com.climapro.app.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class EstadoAveria { PENDIENTE, EN_CURSO, RESUELTA, COBRADA }

@Entity(tableName = "averias")
data class Averia(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nombreCliente: String,
    val telefono: String = "",
    val direccion: String = "",
    val descripcion: String = "",
    val marcaMaquina: String = "",
    val modeloMaquina: String = "",
    val tipoMaquina: TipoMaquina = TipoMaquina.SPLIT_PARED,
    val fecha: Long? = null,
    val hora: String = "",
    val presupuesto: Double = 0.0,
    val importeCobrado: Double = 0.0,
    val estado: EstadoAveria = EstadoAveria.PENDIENTE,
    val estadoCobro: EstadoCobro = EstadoCobro.PENDIENTE,
    val metodoPago: MetodoPago = MetodoPago.EFECTIVO,
    val observaciones: String = "",
    val urgente: Boolean = false,
    val fechaCreacion: Long = System.currentTimeMillis()
)
