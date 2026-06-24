package com.climapro.app.data.repository

import com.climapro.app.data.db.dao.MantenimientoDao
import com.climapro.app.data.db.entity.EstadoMantenimiento
import com.climapro.app.data.db.entity.Mantenimiento
import com.climapro.app.data.db.entity.Periodicidad
import java.util.Calendar
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MantenimientoRepository @Inject constructor(private val dao: MantenimientoDao) {

    fun getAll() = dao.getAll()
    fun getByEstado(estado: EstadoMantenimiento) = dao.getByEstado(estado)
    fun getEnRango(inicio: Long, fin: Long) = dao.getEnRango(inicio, fin)
    fun getByCliente(clienteId: Long) = dao.getByCliente(clienteId)
    fun buscar(q: String) = dao.buscar(q)

    suspend fun getById(id: Long) = dao.getById(id)
    suspend fun insert(m: Mantenimiento) = dao.insert(m)
    suspend fun update(m: Mantenimiento) = dao.update(m)
    suspend fun delete(m: Mantenimiento) = dao.delete(m)
    suspend fun sumPresupuesto(inicio: Long, fin: Long) = dao.sumPresupuesto(inicio, fin) ?: 0.0
    suspend fun sumCobrado(inicio: Long, fin: Long) = dao.sumCobrado(inicio, fin) ?: 0.0

    suspend fun generarSiguiente(m: Mantenimiento): Long? {
        if (m.periodicidad == Periodicidad.SIN_REPETIR || m.fecha == null) return null
        val cal = Calendar.getInstance().apply { timeInMillis = m.fecha }
        when (m.periodicidad) {
            Periodicidad.MENSUAL -> cal.add(Calendar.MONTH, 1)
            Periodicidad.TRIMESTRAL -> cal.add(Calendar.MONTH, 3)
            Periodicidad.SEMESTRAL -> cal.add(Calendar.MONTH, 6)
            Periodicidad.ANUAL -> cal.add(Calendar.YEAR, 1)
            else -> return null
        }
        val siguiente = m.copy(id = 0, fecha = cal.timeInMillis, estado = EstadoMantenimiento.PENDIENTE, importeCobrado = 0.0, firmaPath = null)
        return dao.insert(siguiente)
    }
}
