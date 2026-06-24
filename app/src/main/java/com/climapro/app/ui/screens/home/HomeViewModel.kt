package com.climapro.app.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.climapro.app.data.db.entity.Montaje
import com.climapro.app.data.db.entity.Mantenimiento
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
    val totalPresupuestoMes: Double = 0.0,
    val pendienteCobro: Double = 0.0,
    val proximosMontajes: List<Montaje> = emptyList(),
    val proximosMantenimientos: List<Mantenimiento> = emptyList(),
    val listaEsperaBadge: Int = 0
)

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val montajeRepo: MontajeRepository,
    private val mantenimientoRepo: MantenimientoRepository
) : ViewModel() {

    private val _state = MutableStateFlow(HomeUiState())
    val state: StateFlow<HomeUiState> = _state.asStateFlow()

    init {
        cargarDatos()
    }

    private fun cargarDatos() {
        val cal = Calendar.getInstance()
        cal.set(Calendar.DAY_OF_MONTH, 1)
        cal.set(Calendar.HOUR_OF_DAY, 0)
        cal.set(Calendar.MINUTE, 0)
        val inicioMes = cal.timeInMillis
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH))
        cal.set(Calendar.HOUR_OF_DAY, 23)
        cal.set(Calendar.MINUTE, 59)
        val finMes = cal.timeInMillis

        viewModelScope.launch {
            combine(
                montajeRepo.getEnRango(inicioMes, finMes),
                mantenimientoRepo.getEnRango(inicioMes, finMes),
                montajeRepo.getProgramados(),
                montajeRepo.countListaEspera()
            ) { montajesMes, mantMes, programados, badge ->
                val cobradoMontajes = montajesMes.sumOf { it.importeCobrado }
                val cobradoMant = mantMes.sumOf { it.importeCobrado }
                val presupMontajes = montajesMes.sumOf { it.presupuesto }
                val presupMant = mantMes.sumOf { it.precio }
                val pendiente = (presupMontajes - cobradoMontajes) + (presupMant - cobradoMant)
                val hoy = Calendar.getInstance().apply { set(Calendar.HOUR_OF_DAY, 0); set(Calendar.MINUTE, 0); set(Calendar.SECOND, 0) }.timeInMillis
                val enSieteDias = hoy + 7 * 24 * 60 * 60 * 1000L
                HomeUiState(
                    montajesMes = montajesMes.size,
                    mantenimientosMes = mantMes.size,
                    totalCobradoMes = cobradoMontajes + cobradoMant,
                    totalPresupuestoMes = presupMontajes + presupMant,
                    pendienteCobro = pendiente.coerceAtLeast(0.0),
                    proximosMontajes = programados.filter { it.fecha != null && it.fecha >= hoy && it.fecha <= enSieteDias }.take(5),
                    listaEsperaBadge = badge
                )
            }.collect { _state.value = it }
        }
    }
}
