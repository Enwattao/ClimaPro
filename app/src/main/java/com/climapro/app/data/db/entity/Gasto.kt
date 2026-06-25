package com.climapro.app.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class CategoriaGasto { MATERIALES, SUELDO_AYUDANTE, HERRAMIENTAS, COMBUSTIBLE, SEGUROS, OTROS }

@Entity(tableName = "gastos")
data class Gasto(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val concepto: String,
    val importe: Double,
    val categoria: CategoriaGasto = CategoriaGasto.OTROS,
    val fecha: Long = System.currentTimeMillis(),
    val montajeId: Long? = null,
    val averiaId: Long? = null,
    val notas: String = ""
)
