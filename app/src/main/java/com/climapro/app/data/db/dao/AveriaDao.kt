package com.climapro.app.data.db.dao

import androidx.room.*
import com.climapro.app.data.db.entity.Averia
import kotlinx.coroutines.flow.Flow

@Dao
interface AveriaDao {
    @Query("SELECT * FROM averias ORDER BY CASE WHEN fecha IS NULL THEN 0 ELSE 1 END DESC, fecha DESC")
    fun getAll(): Flow<List<Averia>>

    @Query("SELECT * FROM averias WHERE fecha BETWEEN :inicio AND :fin")
    fun getEnRango(inicio: Long, fin: Long): Flow<List<Averia>>

    @Query("SELECT * FROM averias WHERE id = :id")
    suspend fun getById(id: Long): Averia?

    @Query("SELECT COUNT(*) FROM averias WHERE estado NOT IN ('RESUELTA', 'COBRADA')")
    fun countActivas(): Flow<Int>

    @Insert suspend fun insert(averia: Averia): Long
    @Update suspend fun update(averia: Averia)
    @Delete suspend fun delete(averia: Averia)
}
