package com.climapro.app.data.db.dao

import androidx.room.*
import com.climapro.app.data.db.entity.Gasto
import kotlinx.coroutines.flow.Flow

@Dao
interface GastoDao {
    @Query("SELECT * FROM gastos ORDER BY fecha DESC")
    fun getAll(): Flow<List<Gasto>>

    @Query("SELECT * FROM gastos WHERE fecha BETWEEN :inicio AND :fin ORDER BY fecha DESC")
    fun getEnRango(inicio: Long, fin: Long): Flow<List<Gasto>>

    @Query("SELECT COALESCE(SUM(importe), 0.0) FROM gastos WHERE fecha BETWEEN :inicio AND :fin")
    fun getTotalEnRango(inicio: Long, fin: Long): Flow<Double>

    @Query("SELECT * FROM gastos WHERE montajeId = :id")
    fun getPorMontaje(id: Long): Flow<List<Gasto>>

    @Query("SELECT * FROM gastos WHERE averiaId = :id")
    fun getPorAveria(id: Long): Flow<List<Gasto>>

    @Insert suspend fun insert(gasto: Gasto): Long
    @Update suspend fun update(gasto: Gasto)
    @Delete suspend fun delete(gasto: Gasto)
}
