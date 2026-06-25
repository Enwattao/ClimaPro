package com.climapro.app.data.repository

import com.climapro.app.data.db.dao.NotaDao
import com.climapro.app.data.db.entity.Nota
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class NotaRepository @Inject constructor(private val dao: NotaDao) {
    fun getAll() = dao.getAll()
    suspend fun getPendientesNotificar() = dao.getPendientesNotificar()
    suspend fun getById(id: Long) = dao.getById(id)
    suspend fun insert(nota: Nota) = dao.insert(nota)
    suspend fun update(nota: Nota) = dao.update(nota)
    suspend fun delete(nota: Nota) = dao.delete(nota)
}
