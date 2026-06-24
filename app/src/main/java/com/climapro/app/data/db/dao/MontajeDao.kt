package com.climapro.app.data.db.dao

import androidx.room.*
import com.climapro.app.data.db.entity.EstadoMontaje
import com.climapro.app.data.db.entity.Montaje
import kotlinx.coroutines.flow.Flow

@Dao
interface MontajeDao {
    @Query("SELECT * FROM montajes ORDER BY fecha ASC, fechaCreacion DESC")
    fun getAll(): Flow<List<Montaje>>

    @Query("SELECT * FROM montajes WHERE estado = :estado ORDER BY fechaCreacion DESC")
    fun getByEstado(estado: EstadoMontaje): Flow<List<Montaje>>

    @Query("SELECT * FROM montajes WHERE fecha IS NULL ORDER BY fechaCreacion DESC")
    fun getListaEspera(): Flow<List<Montaje>>

    @Query("SELECT * FROM montajes WHERE fecha IS NOT NULL ORDER BY fecha ASC")
    fun getProgramados(): Flow<List<Montaje>>

    @Query("SELECT * FROM montajes WHERE estado IN ('REALIZADO','COBRADO') ORDER BY fechaFinalizacion DESC")
    fun getRealizados(): Flow<List<Montaje>>

    @Query("SELECT * FROM montajes WHERE fecha BETWEEN :inicio AND :fin ORDER BY fecha ASC")
    fun getEnRango(inicio: Long, fin: Long): Flow<List<Montaje>>

    @Query("SELECT * FROM montajes WHERE id = :id")
    suspend fun getById(id: Long): Montaje?

    @Query("SELECT * FROM montajes WHERE clienteId = :clienteId ORDER BY fechaCreacion DESC")
    fun getByCliente(clienteId: Long): Flow<List<Montaje>>

    @Query("""
        SELECT * FROM montajes WHERE
        nombreCliente LIKE '%' || :q || '%' OR
        direccion LIKE '%' || :q || '%' OR
        marcaMaquina LIKE '%' || :q || '%' OR
        modeloMaquina LIKE '%' || :q || '%'
        ORDER BY fechaCreacion DESC
    """)
    fun buscar(q: String): Flow<List<Montaje>>

    @Query("SELECT SUM(presupuesto) FROM montajes WHERE fecha BETWEEN :inicio AND :fin")
    suspend fun sumPresupuesto(inicio: Long, fin: Long): Double?

    @Query("SELECT SUM(importeCobrado) FROM montajes WHERE fecha BETWEEN :inicio AND :fin")
    suspend fun sumCobrado(inicio: Long, fin: Long): Double?

    @Query("SELECT COUNT(*) FROM montajes WHERE fecha IS NULL")
    fun countListaEspera(): Flow<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(montaje: Montaje): Long

    @Update
    suspend fun update(montaje: Montaje)

    @Delete
    suspend fun delete(montaje: Montaje)
}
