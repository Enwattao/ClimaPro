package com.climapro.app.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "notas")
data class Nota(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val titulo: String,
    val contenido: String = "",
    val recordatorioFecha: Long? = null,
    val recordatorioHora: String = "",
    val recordatorioNotificado: Boolean = false,
    val fechaCreacion: Long = System.currentTimeMillis()
)
