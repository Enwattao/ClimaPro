package com.climapro.app.ui.screens.calendario

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.climapro.app.data.db.entity.Mantenimiento
import com.climapro.app.data.db.entity.Montaje
import com.climapro.app.data.repository.MantenimientoRepository
import com.climapro.app.data.repository.MontajeRepository
import com.climapro.app.ui.components.BottomNavBar
import com.climapro.app.ui.navigation.Screen
import com.climapro.app.ui.theme.*
import com.climapro.app.util.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@HiltViewModel
class CalendarioViewModel @Inject constructor(
    private val montajeRepo: MontajeRepository,
    private val mantRepo: MantenimientoRepository
) : ViewModel() {
    private val _anio = MutableStateFlow(Calendar.getInstance().get(Calendar.YEAR))
    private val _mes = MutableStateFlow(Calendar.getInstance().get(Calendar.MONTH))
    val anio: StateFlow<Int> = _anio
    val mes: StateFlow<Int> = _mes

    val montajes = montajeRepo.getProgramados().stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
    val mantenimientos = mantRepo.getAll().stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun anterior() {
        viewModelScope.launch {
            val cal = Calendar.getInstance().apply { set(_anio.value, _mes.value, 1); add(Calendar.MONTH, -1) }
            _anio.value = cal.get(Calendar.YEAR); _mes.value = cal.get(Calendar.MONTH)
        }
    }
    fun siguiente() {
        viewModelScope.launch {
            val cal = Calendar.getInstance().apply { set(_anio.value, _mes.value, 1); add(Calendar.MONTH, 1) }
            _anio.value = cal.get(Calendar.YEAR); _mes.value = cal.get(Calendar.MONTH)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CalendarioScreen(navController: NavController, vm: CalendarioViewModel = hiltViewModel()) {
    val anio by vm.anio.collectAsState()
    val mes by vm.mes.collectAsState()
    val montajes by vm.montajes.collectAsState()
    val mantenimientos by vm.mantenimientos.collectAsState()
    var diaSeleccionado by remember { mutableIntStateOf(Calendar.getInstance().get(Calendar.DAY_OF_MONTH)) }

    val monthNames = listOf("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre")
    val cal = Calendar.getInstance().apply { set(anio, mes, 1) }
    val primerDia = (cal.get(Calendar.DAY_OF_WEEK) - 2).let { if (it < 0) 6 else it }
    val diasEnMes = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
    val hoy = Calendar.getInstance()

    fun fechaTimestamp(day: Int): Pair<Long, Long> {
        val c = Calendar.getInstance().apply { set(anio, mes, day, 0, 0, 0); set(Calendar.MILLISECOND, 0) }
        val inicio = c.timeInMillis
        c.set(Calendar.HOUR_OF_DAY, 23); c.set(Calendar.MINUTE, 59)
        return inicio to c.timeInMillis
    }

    fun montajesDelDia(day: Int): List<Montaje> {
        val (ini, fin) = fechaTimestamp(day)
        return montajes.filter { it.fecha != null && it.fecha in ini..fin }
    }
    fun mantDelDia(day: Int): List<Mantenimiento> {
        val (ini, fin) = fechaTimestamp(day)
        return mantenimientos.filter { it.fecha != null && it.fecha in ini..fin }
    }

    val montajesHoy = montajesDelDia(diaSeleccionado)
    val mantHoy = mantDelDia(diaSeleccionado)
    val fechaLabel = Calendar.getInstance().apply { set(anio, mes, diaSeleccionado) }.timeInMillis.toFechaLarga().replaceFirstChar { it.uppercase() }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Agenda") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface))
        },
        bottomBar = { BottomNavBar(navController) },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        LazyColumn(Modifier.fillMaxSize().padding(padding)) {
            item {
                Card(modifier = Modifier.fillMaxWidth().padding(12.dp), shape = RoundedCornerShape(16.dp),
                    colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(0.dp)) {
                    Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                        // Nav mes
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                            IconButton(onClick = { vm.anterior() }) { Icon(Icons.Default.ChevronLeft, null, tint = AzulPrimario) }
                            Text("${monthNames[mes]} $anio", style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onSurface)
                            IconButton(onClick = { vm.siguiente() }) { Icon(Icons.Default.ChevronRight, null, tint = AzulPrimario) }
                        }
                        // Leyenda
                        Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                            LegendItem(AzulPrimario, "Montajes")
                            LegendItem(VerdePrimario, "Mantenimientos")
                        }
                        // Nombres días
                        Row(Modifier.fillMaxWidth()) {
                            listOf("L","M","X","J","V","S","D").forEach { d ->
                                Text(d, Modifier.weight(1f), textAlign = TextAlign.Center,
                                    style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            }
                        }
                        // Días
                        val celdas = primerDia + diasEnMes
                        val filas = (celdas + 6) / 7
                        var dia = 1
                        repeat(filas) {
                            Row(Modifier.fillMaxWidth()) {
                                repeat(7) { col ->
                                    val idx = it * 7 + col
                                    val esValido = idx >= primerDia && dia <= diasEnMes
                                    val d = if (esValido) dia++ else 0
                                    val esHoy = esValido && d == hoy.get(Calendar.DAY_OF_MONTH) && mes == hoy.get(Calendar.MONTH) && anio == hoy.get(Calendar.YEAR)
                                    val esSeleccionado = esValido && d == diaSeleccionado
                                    val mtsDelDia = if (esValido) montajesDelDia(d) else emptyList()
                                    val mantDelDia = if (esValido) mantDelDia(d) else emptyList()
                                    val bgColor = when {
                                        esSeleccionado -> AzulPrimario
                                        esHoy -> AzulLight
                                        else -> Color.Transparent
                                    }
                                    val textColor = when {
                                        esSeleccionado -> Color.White
                                        esHoy -> AzulPrimario
                                        else -> MaterialTheme.colorScheme.onSurface
                                    }
                                    Box(
                                        Modifier.weight(1f).aspectRatio(1f).padding(2.dp)
                                            .clip(RoundedCornerShape(8.dp))
                                            .background(bgColor)
                                            .clickable(enabled = esValido) { diaSeleccionado = d },
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                                            if (esValido) {
                                                Text("$d", style = MaterialTheme.typography.labelMedium, color = textColor)
                                                Row(horizontalArrangement = Arrangement.Center, modifier = Modifier.height(6.dp)) {
                                                    if (mtsDelDia.isNotEmpty()) Box(Modifier.size(4.dp).clip(CircleShape).background(if (esSeleccionado) Color.White else AzulPrimario))
                                                    if (mantDelDia.isNotEmpty()) { Spacer(Modifier.width(2.dp)); Box(Modifier.size(4.dp).clip(CircleShape).background(VerdePrimario)) }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }

            item {
                Column(Modifier.padding(12.dp)) {
                    Text(fechaLabel, style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.padding(bottom = 8.dp))
                }
            }

            if (montajesHoy.isEmpty() && mantHoy.isEmpty()) {
                item {
                    Box(Modifier.fillMaxWidth().padding(24.dp), contentAlignment = Alignment.Center) {
                        Text("Sin trabajos este día", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            }

            items(montajesHoy) { m ->
                AgendaItem(
                    barColor = AzulPrimario, title = "${m.marcaMaquina} ${m.modeloMaquina}".trim().ifEmpty { "Montaje" },
                    subtitle = m.nombreCliente, hora = m.hora, tag = "Montaje",
                    onClick = { navController.navigate(Screen.MontajeDetalle.create(m.id)) }
                )
            }

            items(mantHoy) { m ->
                AgendaItem(
                    barColor = VerdePrimario, title = m.tipoMantenimiento.label(),
                    subtitle = m.nombreCliente, hora = m.hora, tag = "Mantenimiento",
                    onClick = { navController.navigate(Screen.MantenimientoDetalle.create(m.id)) }
                )
            }
        }
    }
}

@Composable
private fun LegendItem(color: Color, text: String) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
        Box(Modifier.size(8.dp).clip(CircleShape).background(color))
        Text(text, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
    }
}

@Composable
private fun AgendaItem(barColor: Color, title: String, subtitle: String, hora: String, tag: String, onClick: () -> Unit) {
    Card(
        Modifier.fillMaxWidth().padding(horizontal = 12.dp, vertical = 4.dp).clickable(onClick = onClick),
        shape = RoundedCornerShape(14.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Row(Modifier.fillMaxWidth()) {
            Box(Modifier.width(4.dp).height(64.dp).background(barColor))
            Column(Modifier.weight(1f).padding(horizontal = 12.dp, vertical = 10.dp)) {
                Text(title, style = MaterialTheme.typography.labelLarge)
                Text(subtitle, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(Modifier.height(4.dp))
                Box(Modifier.clip(RoundedCornerShape(8.dp)).background(if (barColor == AzulPrimario) AzulLight else VerdeLight).padding(horizontal = 8.dp, vertical = 2.dp)) {
                    Text(tag, style = MaterialTheme.typography.labelSmall, color = barColor)
                }
            }
            if (hora.isNotEmpty()) {
                Text(hora, Modifier.padding(10.dp), style = MaterialTheme.typography.labelLarge, color = barColor)
            }
        }
    }
}
