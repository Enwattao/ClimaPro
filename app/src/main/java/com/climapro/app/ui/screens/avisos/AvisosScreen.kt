package com.climapro.app.ui.screens.avisos

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.climapro.app.data.db.entity.Averia
import com.climapro.app.data.db.entity.Montaje
import com.climapro.app.data.db.entity.Nota
import com.climapro.app.data.repository.AveriaRepository
import com.climapro.app.data.repository.MontajeRepository
import com.climapro.app.data.repository.NotaRepository
import com.climapro.app.ui.theme.*
import com.climapro.app.util.toFechaCorta
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

data class AvisosUiState(
    val montajesProximos: List<Montaje> = emptyList(),
    val averiasUrgentes: List<Averia> = emptyList(),
    val notasPendientes: List<Nota> = emptyList()
) {
    val total get() = montajesProximos.size + averiasUrgentes.size + notasPendientes.size
}

@HiltViewModel
class AvisosViewModel @Inject constructor(
    private val montajeRepo: MontajeRepository,
    private val averiaRepo: AveriaRepository,
    private val notaRepo: NotaRepository
) : ViewModel() {

    private val _state = MutableStateFlow(AvisosUiState())
    val state: StateFlow<AvisosUiState> = _state.asStateFlow()

    init {
        viewModelScope.launch {
            val hoy = Calendar.getInstance().apply { set(Calendar.HOUR_OF_DAY, 0); set(Calendar.MINUTE, 0); set(Calendar.SECOND, 0) }.timeInMillis
            val en7dias = hoy + 7 * 24 * 60 * 60 * 1000L
            combine(
                montajeRepo.getProgramados(),
                averiaRepo.getAll(),
                notaRepo.getAll()
            ) { programados, averias, notas ->
                AvisosUiState(
                    montajesProximos = programados.filter { it.fecha != null && it.fecha >= hoy && it.fecha <= en7dias },
                    averiasUrgentes = averias.filter { it.urgente && (it.estado.name == "PENDIENTE" || it.estado.name == "EN_CURSO") },
                    notasPendientes = notas.filter { it.recordatorioFecha != null && it.recordatorioFecha >= hoy }
                )
            }.collect { _state.value = it }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AvisosScreen(navController: NavController, vm: AvisosViewModel = hiltViewModel()) {
    val state by vm.state.collectAsState()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Text("Avisos")
                        if (state.total > 0) {
                            Box(Modifier.clip(RoundedCornerShape(10.dp)).background(NaranjaPrimario).padding(horizontal = 8.dp, vertical = 2.dp)) {
                                Text("${state.total}", style = MaterialTheme.typography.labelSmall, color = Color.White)
                            }
                        }
                    }
                },
                navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Default.ArrowBack, null) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = AzulOscuro, titleContentColor = Color.White, navigationIconContentColor = Color.White)
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        if (state.total == 0) {
            Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(Icons.Default.NotificationsNone, null, modifier = Modifier.size(56.dp), tint = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text("Sin avisos pendientes", style = MaterialTheme.typography.titleMedium)
                    Text("Todo al día", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        } else {
            LazyColumn(Modifier.fillMaxSize().padding(padding).padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                if (state.montajesProximos.isNotEmpty()) {
                    item { AvisosSectionHeader("Montajes próximos (7 días)", Icons.Default.Build, AzulPrimario) }
                    items(state.montajesProximos) { m ->
                        AvisoCard(
                            icon = Icons.Default.Build,
                            iconBg = AzulLight,
                            iconColor = AzulPrimario,
                            titulo = m.nombreCliente,
                            subtitulo = "${m.tipoMaquina.name.replace("_", " ")} · ${m.direccion.take(30)}",
                            etiqueta = m.fecha?.toFechaCorta() + " " + m.hora,
                            etiquetaColor = AzulPrimario
                        )
                    }
                }
                if (state.averiasUrgentes.isNotEmpty()) {
                    item { AvisosSectionHeader("Averías urgentes", Icons.Default.Warning, Color(0xFFFF6B6B)) }
                    items(state.averiasUrgentes) { a ->
                        AvisoCard(
                            icon = Icons.Default.Warning,
                            iconBg = Color(0xFFFFEEEE),
                            iconColor = Color(0xFFFF6B6B),
                            titulo = a.nombreCliente,
                            subtitulo = a.descripcion.ifEmpty { a.marcaMaquina }.take(40),
                            etiqueta = "URGENTE",
                            etiquetaColor = Color(0xFFFF6B6B)
                        )
                    }
                }
                if (state.notasPendientes.isNotEmpty()) {
                    item { AvisosSectionHeader("Recordatorios", Icons.Default.Alarm, NaranjaPrimario) }
                    items(state.notasPendientes) { n ->
                        AvisoCard(
                            icon = Icons.Default.Note,
                            iconBg = NaranjaLight,
                            iconColor = NaranjaPrimario,
                            titulo = n.titulo,
                            subtitulo = n.contenido.ifEmpty { "Nota sin descripción" }.take(40),
                            etiqueta = n.recordatorioFecha!!.toFechaCorta() + " " + n.recordatorioHora,
                            etiquetaColor = NaranjaPrimario
                        )
                    }
                }
            }
        }
    }
}

@Composable
private fun AvisosSectionHeader(title: String, icon: ImageVector, color: Color) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp), modifier = Modifier.padding(vertical = 4.dp)) {
        Icon(icon, null, tint = color, modifier = Modifier.size(14.dp))
        Text(title, style = MaterialTheme.typography.labelMedium, color = color)
    }
}

@Composable
private fun AvisoCard(icon: ImageVector, iconBg: Color, iconColor: Color, titulo: String, subtitulo: String, etiqueta: String, etiquetaColor: Color) {
    Card(shape = RoundedCornerShape(14.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(0.dp), modifier = Modifier.fillMaxWidth()) {
        Row(Modifier.padding(12.dp), horizontalArrangement = Arrangement.spacedBy(12.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(Modifier.size(40.dp).clip(RoundedCornerShape(10.dp)).background(iconBg), contentAlignment = Alignment.Center) {
                Icon(icon, null, tint = iconColor, modifier = Modifier.size(20.dp))
            }
            Column(Modifier.weight(1f)) {
                Text(titulo, style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.onSurface)
                Text(subtitulo, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 1)
            }
            Box(Modifier.clip(RoundedCornerShape(8.dp)).background(etiquetaColor.copy(alpha = 0.12f)).padding(horizontal = 8.dp, vertical = 4.dp)) {
                Text(etiqueta, style = MaterialTheme.typography.labelSmall, color = etiquetaColor)
            }
        }
    }
}
