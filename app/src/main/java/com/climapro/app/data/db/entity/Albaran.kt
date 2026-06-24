package com.climapro.app.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "albaranes")
data class Albaran(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val numero: String,
    val trabajoId: Long,
    val tipoTrabajo: TipoTrabajo,
    val rutaPdf: String,
    val fechaGeneracion: Long = System.currentTimeMillis()
)
