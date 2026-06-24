package com.climapro.app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.climapro.app.data.db.dao.*
import com.climapro.app.data.db.entity.*

@Database(
    entities = [Cliente::class, Montaje::class, Mantenimiento::class, Foto::class, Albaran::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clienteDao(): ClienteDao
    abstract fun montajeDao(): MontajeDao
    abstract fun mantenimientoDao(): MantenimientoDao
    abstract fun fotoDao(): FotoDao
    abstract fun albaranDao(): AlbaranDao
}
