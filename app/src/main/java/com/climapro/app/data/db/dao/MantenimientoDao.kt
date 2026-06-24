package com.climapro.app.data.db.dao

import androidx.room.*
import com.climapro.app.data.db.entity.EstadoMantenimiento
import com.climapro.app.data.db.entity.Mantenimiento
import kotlinx.coroutines.flow.Flow

@Dao
interface MantenimientoDao {
    @Query("SELECT * FROM mantenimientos ORDER BY fecha ASC, fechaCreacion DESC")
    fun getAll(): Flow<List<Mantenimiento>>

    @Query("SELECT * FROM mantenimientos WHERE estado = :estado ORDER BY fecha ASC")
    fun getByEstado(estado: EstadoMantenimiento): Flow<List<Mantenimiento>>

    @Query("SELECT * FROM mantenimientos WHERE fecha BETWEEN :inicio AND :fin ORDER BY fecha ASC")
    fun getEnRango(inicio: Long, fin: Long): Flow<List<Mantenimiento>>

    @Query("SELECT * FROM mantenimientos WHERE id = :id")
    suspend fun getById(id: Long): Mantenimiento?

    @Query("SELECT * FROM mantenimientos WHERE clienteId = :clienteId ORDER BY fechaCreacion DESC")
    fun getByCliente(clienteId: Long): Flow<List<Mantenimiento>>

    @Query("""
        SELECT * FROM mantenimientos WHERE
        nombreCliente LIKE '%' || :q || '%' OR
        direccion LIKE '%' || :q || '%'
        ORDER BY fecha DESC
    """)
    fun buscar(q: String): Flow<List<Mantenimiento>>

    @Query("SELECT SUM(precio) FROM mantenimientos WHERE fecha BETWEEN :inicio AND :fin")
    suspend fun sumPresupuesto(inicio: Long, fin: Long): Double?

    @Query("SELECT SUM(importeCobrado) FROM mantenimientos WHERE fecha BETWEEN :inicio AND :fin")
    suspend fun sumCobrado(inicio: Long, fin: Long): Double?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(m: Mantenimiento): Long

    @Update
    suspend fun update(m: Mantenimiento)

    @Delete
    suspend fun delete(m: Mantenimiento)
}
