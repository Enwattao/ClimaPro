package com.climapro.app.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "clientes")
data class Cliente(
    @PrimaryKey(autoGenerate = true) val id: Long = 0,
    val nombre: String,
    val telefono: String,
    val direccion: String,
    val email: String = "",
    val notas: String = "",
    val fechaCreacion: Long = System.currentTimeMillis()
)
