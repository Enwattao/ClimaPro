package com.climapro.app.data.db.dao

import androidx.room.*
import com.climapro.app.data.db.entity.Foto
import com.climapro.app.data.db.entity.TipoTrabajo
import kotlinx.coroutines.flow.Flow

@Dao
interface FotoDao {
    @Query("SELECT * FROM fotos WHERE trabajoId = :id AND tipoTrabajo = :tipo ORDER BY tipoFoto ASC, fechaCaptura ASC")
    fun getByTrabajo(id: Long, tipo: TipoTrabajo): Flow<List<Foto>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(foto: Foto): Long

    @Delete
    suspend fun delete(foto: Foto)

    @Query("DELETE FROM fotos WHERE trabajoId = :id AND tipoTrabajo = :tipo")
    suspend fun deleteByTrabajo(id: Long, tipo: TipoTrabajo)
}
