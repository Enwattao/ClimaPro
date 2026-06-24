package com.climapro.app.data.db.dao

import androidx.room.*
import com.climapro.app.data.db.entity.Albaran
import com.climapro.app.data.db.entity.TipoTrabajo
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbaranDao {
    @Query("SELECT * FROM albaranes WHERE trabajoId = :id AND tipoTrabajo = :tipo ORDER BY fechaGeneracion DESC")
    fun getByTrabajo(id: Long, tipo: TipoTrabajo): Flow<List<Albaran>>

    @Query("SELECT MAX(CAST(SUBSTR(numero, 4) AS INTEGER)) FROM albaranes WHERE numero LIKE 'ALB%'")
    suspend fun getUltimoNumero(): Int?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(a: Albaran): Long

    @Delete
    suspend fun delete(a: Albaran)
}
