package com.climapro.app.data.repository

import com.climapro.app.data.db.dao.AveriaDao
import com.climapro.app.data.db.entity.Averia
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AveriaRepository @Inject constructor(private val dao: AveriaDao) {
    fun getAll() = dao.getAll()
    fun getEnRango(inicio: Long, fin: Long) = dao.getEnRango(inicio, fin)
    fun countActivas() = dao.countActivas()
    suspend fun getById(id: Long) = dao.getById(id)
    suspend fun insert(averia: Averia) = dao.insert(averia)
    suspend fun update(averia: Averia) = dao.update(averia)
    suspend fun delete(averia: Averia) = dao.delete(averia)
}
