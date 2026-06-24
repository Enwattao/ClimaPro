package com.climapro.app.data.db.dao

import androidx.room.*
import com.climapro.app.data.db.entity.Cliente
import kotlinx.coroutines.flow.Flow

@Dao
interface ClienteDao {
    @Query("SELECT * FROM clientes ORDER BY nombre ASC")
    fun getAll(): Flow<List<Cliente>>

    @Query("SELECT * FROM clientes WHERE id = :id")
    suspend fun getById(id: Long): Cliente?

    @Query("SELECT * FROM clientes WHERE nombre LIKE '%' || :query || '%' OR telefono LIKE '%' || :query || '%' OR direccion LIKE '%' || :query || '%'")
    fun buscar(query: String): Flow<List<Cliente>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cliente: Cliente): Long

    @Update
    suspend fun update(cliente: Cliente)

    @Delete
    suspend fun delete(cliente: Cliente)
}
