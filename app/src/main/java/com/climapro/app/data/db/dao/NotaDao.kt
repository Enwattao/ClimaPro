package com.climapro.app.data.db.dao

import androidx.room.*
import com.climapro.app.data.db.entity.Nota
import kotlinx.coroutines.flow.Flow

@Dao
interface NotaDao {
    @Query("SELECT * FROM notas ORDER BY CASE WHEN recordatorioFecha IS NOT NULL THEN recordatorioFecha ELSE fechaCreacion END ASC")
    fun getAll(): Flow<List<Nota>>

    @Query("SELECT * FROM notas WHERE recordatorioFecha IS NOT NULL AND recordatorioNotificado = 0")
    suspend fun getPendientesNotificar(): List<Nota>

    @Query("SELECT * FROM notas WHERE id = :id")
    suspend fun getById(id: Long): Nota?

    @Insert suspend fun insert(nota: Nota): Long
    @Update suspend fun update(nota: Nota)
    @Delete suspend fun delete(nota: Nota)
}
