package com.climapro.app.ui.screens.montajes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.climapro.app.data.db.entity.Montaje
import com.climapro.app.data.repository.MontajeRepository
import com.climapro.app.worker.NotificationScheduler
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class MontajesTab { PROGRAMADOS, LISTA_ESPERA, REALIZADOS }

data class MontajesUiState(
    val tab: MontajesTab = MontajesTab.PROGRAMADOS,
    val programados: List<Montaje> = emptyList(),
    val listaEspera: List<Montaje> = emptyList(),
    val realizados: List<Montaje> = emptyList(),
    val listaEsperaBadge: Int = 0
)

@HiltViewModel
class MontajesViewModel @Inject constructor(
    private val repo: MontajeRepository,
    private val scheduler: NotificationScheduler
) : ViewModel() {

    private val _tab = MutableStateFlow(MontajesTab.PROGRAMADOS)
    private val _state = MutableStateFlow(MontajesUiState())
    val state: StateFlow<MontajesUiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            combine(
                repo.getProgramados(),
                repo.getListaEspera(),
                repo.getRealizados(),
                repo.countListaEspera(),
                _tab
            ) { prog, espera, real, badge, tab ->
                MontajesUiState(tab, prog, espera, real, badge)
            }.collect { _state.value = it }
        }
    }

    fun setTab(tab: MontajesTab) { _tab.value = tab }

    fun asignarCita(montaje: Montaje, fecha: Long, hora: String, horasEstimadas: Float) {
        viewModelScope.launch {
            val actualizado = repo.asignarCita(montaje, fecha, hora, horasEstimadas)
            scheduler.scheduleMontaje(actualizado)
        }
    }

    fun eliminar(montaje: Montaje) = viewModelScope.launch { repo.delete(montaje) }
}
