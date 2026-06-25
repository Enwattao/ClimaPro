package com.climapro.app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.climapro.app.data.db.dao.*
import com.climapro.app.data.db.entity.*

@Database(
    entities = [Cliente::class, Montaje::class, Mantenimiento::class, Foto::class, Albaran::class, Averia::class, Gasto::class, Nota::class],
    version = 4,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun clienteDao(): ClienteDao
    abstract fun montajeDao(): MontajeDao
    abstract fun mantenimientoDao(): MantenimientoDao
    abstract fun fotoDao(): FotoDao
    abstract fun albaranDao(): AlbaranDao
    abstract fun averiaDao(): AveriaDao
    abstract fun gastoDao(): GastoDao
    abstract fun notaDao(): NotaDao

    companion object {
        val MIGRATION_1_2 = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("""CREATE TABLE IF NOT EXISTS averias (
                    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                    nombreCliente TEXT NOT NULL,
                    telefono TEXT NOT NULL DEFAULT '',
                    direccion TEXT NOT NULL DEFAULT '',
                    descripcion TEXT NOT NULL DEFAULT '',
                    marcaMaquina TEXT NOT NULL DEFAULT '',
                    modeloMaquina TEXT NOT NULL DEFAULT '',
                    tipoMaquina TEXT NOT NULL DEFAULT 'SPLIT_PARED',
                    fecha INTEGER,
                    hora TEXT NOT NULL DEFAULT '',
                    presupuesto REAL NOT NULL DEFAULT 0.0,
                    importeCobrado REAL NOT NULL DEFAULT 0.0,
                    estado TEXT NOT NULL DEFAULT 'PENDIENTE',
                    estadoCobro TEXT NOT NULL DEFAULT 'PENDIENTE',
                    metodoPago TEXT NOT NULL DEFAULT 'EFECTIVO',
                    observaciones TEXT NOT NULL DEFAULT '',
                    urgente INTEGER NOT NULL DEFAULT 0,
                    fechaCreacion INTEGER NOT NULL DEFAULT 0
                )""")
                db.execSQL("""CREATE TABLE IF NOT EXISTS gastos (
                    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                    concepto TEXT NOT NULL,
                    importe REAL NOT NULL,
                    categoria TEXT NOT NULL DEFAULT 'OTROS',
                    fecha INTEGER NOT NULL,
                    montajeId INTEGER,
                    averiaId INTEGER,
                    notas TEXT NOT NULL DEFAULT ''
                )""")
            }
        }

        val MIGRATION_2_3 = object : Migration(2, 3) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("""CREATE TABLE IF NOT EXISTS notas (
                    id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,
                    titulo TEXT NOT NULL,
                    contenido TEXT NOT NULL DEFAULT '',
                    recordatorioFecha INTEGER,
                    recordatorioHora TEXT NOT NULL DEFAULT '',
                    recordatorioNotificado INTEGER NOT NULL DEFAULT 0,
                    fechaCreacion INTEGER NOT NULL DEFAULT 0
                )""")
            }
        }

        val MIGRATION_3_4 = object : Migration(3, 4) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("ALTER TABLE montajes ADD COLUMN sueldoAyudante REAL NOT NULL DEFAULT 0.0")
            }
        }
    }
}
