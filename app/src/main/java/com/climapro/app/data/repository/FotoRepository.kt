package com.climapro.app.data.repository

import com.climapro.app.data.db.dao.FotoDao
import com.climapro.app.data.db.entity.Foto
import com.climapro.app.data.db.entity.TipoTrabajo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FotoRepository @Inject constructor(private val dao: FotoDao) {
    fun getByTrabajo(id: Long, tipo: TipoTrabajo) = dao.getByTrabajo(id, tipo)
    suspend fun insert(foto: Foto) = dao.insert(foto)
    suspend fun delete(foto: Foto) = dao.delete(foto)
}
