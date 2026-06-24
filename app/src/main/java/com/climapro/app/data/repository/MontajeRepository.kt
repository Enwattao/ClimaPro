package com.climapro.app.data.repository

import com.climapro.app.data.db.dao.MontajeDao
import com.climapro.app.data.db.entity.EstadoMontaje
import com.climapro.app.data.db.entity.Montaje
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MontajeRepository @Inject constructor(private val dao: MontajeDao) {

    fun getAll() = dao.getAll()
    fun getListaEspera() = dao.getListaEspera()
    fun getProgramados() = dao.getProgramados()
    fun getRealizados() = dao.getRealizados()
    fun getByEstado(estado: EstadoMontaje) = dao.getByEstado(estado)
    fun getEnRango(inicio: Long, fin: Long) = dao.getEnRango(inicio, fin)
    fun getByCliente(clienteId: Long) = dao.getByCliente(clienteId)
    fun buscar(q: String) = dao.buscar(q)
    fun countListaEspera() = dao.countListaEspera()

    suspend fun getById(id: Long) = dao.getById(id)
    suspend fun insert(m: Montaje) = dao.insert(m)
    suspend fun update(m: Montaje) = dao.update(m)
    suspend fun delete(m: Montaje) = dao.delete(m)
    suspend fun sumPresupuesto(inicio: Long, fin: Long) = dao.sumPresupuesto(inicio, fin) ?: 0.0
    suspend fun sumCobrado(inicio: Long, fin: Long) = dao.sumCobrado(inicio, fin) ?: 0.0

    suspend fun asignarCita(montaje: Montaje, fecha: Long, hora: String, horasEstimadas: Float): Montaje {
        val actualizado = montaje.copy(
            fecha = fecha,
            hora = hora,
            horasEstimadas = horasEstimadas,
            estado = EstadoMontaje.PENDIENTE
        )
        dao.update(actualizado)
        return actualizado
    }
}
