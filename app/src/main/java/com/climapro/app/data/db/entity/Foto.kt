package com.climapro.app.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

enum class TipoFoto { ANTES, DURANTE, DESPUES }
enum class TipoTrabajo { MONTAJE, MANTENIMIENTO }

@Entity(tableName = "fotos")
data class Foto(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val trabajoId: Long,
    val tipoTrabajo: TipoTrabajo,
    val tipoFoto: TipoFoto,
    val rutaArchivo: String,
    val fechaCaptura: Long = System.currentTimeMillis()
)
