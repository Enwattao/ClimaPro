package com.climapro.app.data.repository

import com.climapro.app.data.db.dao.GastoDao
import com.climapro.app.data.db.entity.Gasto
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GastoRepository @Inject constructor(private val dao: GastoDao) {
    fun getAll() = dao.getAll()
    fun getEnRango(inicio: Long, fin: Long) = dao.getEnRango(inicio, fin)
    fun getTotalEnRango(inicio: Long, fin: Long) = dao.getTotalEnRango(inicio, fin)
    fun getPorMontaje(id: Long) = dao.getPorMontaje(id)
    fun getPorAveria(id: Long) = dao.getPorAveria(id)
    suspend fun insert(gasto: Gasto) = dao.insert(gasto)
    suspend fun update(gasto: Gasto) = dao.update(gasto)
    suspend fun delete(gasto: Gasto) = dao.delete(gasto)
}
