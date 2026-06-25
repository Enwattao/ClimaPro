package com.climapro.app.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.climapro.app.data.db.entity.Averia
import com.climapro.app.data.db.entity.Mantenimiento
import com.climapro.app.data.db.entity.Montaje
import com.climapro.app.data.repository.AveriaRepository
import com.climapro.app.data.repository.GastoRepository
import com.climapro.app.data.repository.MantenimientoRepository
import com.climapro.app.data.repository.MontajeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

data class HomeUiState(
    val montajesMes: Int = 0,
    val mantenimientosMes: Int = 0,
    val totalCobradoMes: Double = 0.0,
    val gastosMes: Double = 0.0,
    val averiasActivas: Int = 0,
    val proximosMontajes: List<Montaje> = emptyList(),
    val proximasAverias: List<Averia> = emptyList(),
    val listaEsperaBadge: Int = 0,
    val averiasActivasBadge: Int = 0
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val montajeRepo: MontajeRepository,
    private val mantenimientoRepo: MantenimientoRepository,
    private val averiaRepo: AveriaRepository,
    private val gastoRepo: GastoRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state: StateFlow<HomeUiState> = _state.asStateFlow()

    init { cargarDatos() }

    private fun cargarDatos() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.DAY_OF_MONTH, 1); cal.set(Calendar.HOUR_OF_DAY, 0); cal.set(Calendar.MINUTE, 0)
        val inicioMes = cal.timeInMillis
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH))
        cal.set(Calendar.HOUR_OF_DAY, 23); cal.set(Calendar.MINUTE, 59)
        val finMes = cal.timeInMillis
        val hoy = Calendar.getInstance().apply { set(Calendar.HOUR_OF_DAY, 0); set(Calendar.MINUTE, 0); set(Calendar.SECOND, 0) }.timeInMillis
        val en7dias = hoy + 7 * 24 * 60 * 60 * 1000L

        viewModelScope.launch {
            combine(
                montajeRepo.getEnRango(inicioMes, finMes),
                mantenimientoRepo.getEnRango(inicioMes, finMes),
                montajeRepo.getProgramados(),
                montajeRepo.countListaEspera(),
                averiaRepo.getAll(),
                averiaRepo.countActivas(),
                gastoRepo.getTotalEnRango(inicioMes, finMes)
            ) { args ->
                val montajesMes = args[0] as List<Montaje>
                val mantMes = args[1] as List<Mantenimiento>
                val programados = args[2] as List<Montaje>
                val badge = args[3] as Int
                val todasAverias = args[4] as List<Averia>
                val averiasActivas = args[5] as Int
                val gastosMes = args[6] as Double
                val cobradoMontajes = montajesMes.sumOf { it.importeCobrado }
                val cobradoMant = mantMes.sumOf { it.importeCobrado }
                HomeUiState(
                    montajesMes = montajesMes.size,
                    mantenimientosMes = mantMes.size,
                    totalCobradoMes = cobradoMontajes + cobradoMant,
                    gastosMes = gastosMes,
                    averiasActivas = averiasActivas,
                    proximosMontajes = programados.filter { it.fecha != null && it.fecha >= hoy && it.fecha <= en7dias }.take(4),
                    proximasAverias = todasAverias.filter { it.fecha != null && it.fecha >= hoy && it.fecha <= en7dias }.take(2),
                    listaEsperaBadge = badge,
                    averiasActivasBadge = averiasActivas
                )
            }.collect { _state.value = it }
        }
    }
}
