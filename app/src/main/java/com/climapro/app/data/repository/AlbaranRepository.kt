package com.climapro.app.data.repository

import com.climapro.app.data.db.dao.AlbaranDao
import com.climapro.app.data.db.entity.Albaran
import com.climapro.app.data.db.entity.TipoTrabajo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AlbaranRepository @Inject constructor(private val dao: AlbaranDao) {
    fun getByTrabajo(id: Long, tipo: TipoTrabajo) = dao.getByTrabajo(id, tipo)

    suspend fun insert(a: Albaran) = dao.insert(a)
    suspend fun delete(a: Albaran) = dao.delete(a)

    suspend fun generarNumero(): String {
        val ultimo = dao.getUltimoNumero() ?: 0
        return "ALB${String.format("%04d", ultimo + 1)}"
    }
}
