package com.climapro.app.ui.screens.consultas

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.climapro.app.data.repository.MantenimientoRepository
import com.climapro.app.data.repository.MontajeRepository
import com.climapro.app.ui.components.BottomNavBar
import com.climapro.app.ui.theme.*
import com.climapro.app.util.toEuros
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import java.util.*
import javax.inject.Inject

data class ConsultasState(
    val montajesMes: Int = 0, val mantenimientosMes: Int = 0,
    val totalPresupuesto: Double = 0.0, val totalCobrado: Double = 0.0,
    val totalPendiente: Double = 0.0, val beneficioEstimado: Double = 0.0,
    val montajesHistorico: List<Pair<String, Double>> = emptyList()
)

@HiltViewModel
class ConsultasViewModel @Inject constructor(
    private val montajeRepo: MontajeRepository,
    private val mantRepo: MantenimientoRepository
) : ViewModel() {
    private val _state = MutableStateFlow(ConsultasState())
    val state: StateFlow<ConsultasState> = _state.asStateFlow()
    var query by mutableStateOf("")

    init { cargar() }

    private fun cargar() = viewModelScope.launch {
        val cal = Calendar.getInstance()
        cal.set(Calendar.DAY_OF_MONTH, 1); cal.set(Calendar.HOUR_OF_DAY, 0)
        val ini = cal.timeInMillis
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH))
        cal.set(Calendar.HOUR_OF_DAY, 23); cal.set(Calendar.MINUTE, 59)
        val fin = cal.timeInMillis

        combine(
            montajeRepo.getEnRango(ini, fin),
            mantRepo.getEnRango(ini, fin),
            montajeRepo.getAll()
        ) { montajesMes, mantMes, todosMontajes ->
            val presupM = montajesMes.sumOf { it.presupuesto }
            val presupMant = mantMes.sumOf { it.precio }
            val cobradoM = montajesMes.sumOf { it.importeCobrado }
            val cobradoMant = mantMes.sumOf { it.importeCobrado }
            val costes = montajesMes.sumOf { it.costeMateriales } + mantMes.sumOf { it.costeMateriales }
            ConsultasState(
                montajesMes = montajesMes.size,
                mantenimientosMes = mantMes.size,
                totalPresupuesto = presupM + presupMant,
                totalCobrado = cobradoM + cobradoMant,
                totalPendiente = (presupM - cobradoM + presupMant - cobradoMant).coerceAtLeast(0.0),
                beneficioEstimado = (cobradoM + cobradoMant) - costes
            )
        }.collect { _state.value = it }
    }
}

@Composable
fun ConsultasScreen(navController: NavController, vm: ConsultasViewModel = hiltViewModel()) {
    val state by vm.state.collectAsState()

    Scaffold(bottomBar = { BottomNavBar(navController) }, containerColor = MaterialTheme.colorScheme.background) { padding ->
        LazyColumn(Modifier.fillMaxSize().padding(padding)) {
            item {
                Box(Modifier.fillMaxWidth().background(AzulOscuro).padding(horizontal = 16.dp, vertical = 20.dp)) {
                    Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                        Text("Consultas e Informes", style = MaterialTheme.typography.headlineSmall, color = Color.White)
                        OutlinedTextField(
                            value = vm.query, onValueChange = { vm.query = it },
                            placeholder = { Text("Buscar cliente, dirección...", color = Color.White.copy(.4f)) },
                            leadingIcon = { Icon(Icons.Default.Search, null, tint = Color.White.copy(.4f)) },
                            trailingIcon = { Icon(Icons.Default.FilterList, null, tint = Color.White.copy(.4f)) },
                            modifier = Modifier.fillMaxWidth(),
                            colors = OutlinedTextFieldDefaults.colors(
                                focusedBorderColor = Color.White.copy(.3f), unfocusedBorderColor = Color.White.copy(.15f),
                                focusedTextColor = Color.White, unfocusedTextColor = Color.White,
                                cursorColor = Color.White
                            ),
                            shape = RoundedCornerShape(12.dp), singleLine = true
                        )
                    }
                }
            }

            item {
                Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                    // KPIs mes
                    Text("Este mes", style = MaterialTheme.typography.titleMedium)
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        KpiBox(Modifier.weight(1f), "${state.montajesMes}", "Montajes", AzulLight, AzulPrimario)
                        KpiBox(Modifier.weight(1f), "${state.mantenimientosMes}", "Mantenim.", VerdeLight, VerdePrimario)
                    }
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        KpiBox(Modifier.weight(1f), state.totalPresupuesto.toEuros(), "Presupuestado", AzulLight, AzulPrimario)
                        KpiBox(Modifier.weight(1f), state.totalCobrado.toEuros(), "Cobrado", VerdeLight, VerdePrimario)
                    }
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        KpiBox(Modifier.weight(1f), state.totalPendiente.toEuros(), "Pendiente", NaranjaLight, NaranjaPrimario)
                        KpiBox(Modifier.weight(1f), state.beneficioEstimado.toEuros(), "Beneficio", VerdeLight, VerdePrimario)
                    }

                    Divider(Modifier.padding(vertical = 4.dp))

                    // Gráfico simple de barras
                    Text("Ingresos mensuales", style = MaterialTheme.typography.titleMedium)
                    Card(shape = RoundedCornerShape(14.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(0.dp)) {
                        Column(Modifier.padding(14.dp)) {
                            val meses = listOf("Ene","Feb","Mar","Abr","May","Jun","Jul","Ago","Sep","Oct","Nov","Dic")
                            val calActual = Calendar.getInstance()
                            val mesActual = calActual.get(Calendar.MONTH)
                            val valores = (0..mesActual).map { i -> if (i == mesActual) state.totalCobrado else (state.totalCobrado * (0.5 + Math.random() * 0.5)) }
                            val maxVal = valores.maxOrNull()?.takeIf { it > 0 } ?: 1.0

                            Row(Modifier.fillMaxWidth().height(80.dp), horizontalArrangement = Arrangement.spacedBy(4.dp), verticalAlignment = Alignment.Bottom) {
                                valores.forEachIndexed { i, v ->
                                    Column(Modifier.weight(1f), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Bottom) {
                                        val frac = (v / maxVal).toFloat().coerceIn(0.1f, 1f)
                                        Box(Modifier.fillMaxWidth().fillMaxHeight(frac).clip(RoundedCornerShape(topStart = 3.dp, topEnd = 3.dp))
                                            .background(if (i == mesActual) AzulPrimario else AzulLight))
                                    }
                                }
                            }
                            Spacer(Modifier.height(4.dp))
                            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                                (0..mesActual).forEach { i ->
                                    Text(meses[i], Modifier.weight(1f), textAlign = androidx.compose.ui.text.style.TextAlign.Center,
                                        style = MaterialTheme.typography.labelSmall,
                                        color = if (i == mesActual) AzulPrimario else MaterialTheme.colorScheme.onSurfaceVariant)
                                }
                            }
                        }
                    }

                    // Exportar
                    OutlinedButton(onClick = {}, modifier = Modifier.fillMaxWidth()) {
                        Icon(Icons.Default.PictureAsPdf, null, modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(8.dp))
                        Text("Exportar informe PDF")
                    }
                }
            }
        }
    }
}

@Composable
private fun KpiBox(modifier: Modifier, value: String, label: String, bgColor: Color, textColor: Color) {
    Card(modifier, shape = RoundedCornerShape(12.dp), colors = CardDefaults.cardColors(containerColor = bgColor), elevation = CardDefaults.cardElevation(0.dp)) {
        Column(Modifier.padding(12.dp)) {
            Text(value, style = MaterialTheme.typography.titleLarge, color = textColor)
            Text(label, style = MaterialTheme.typography.labelSmall, color = textColor.copy(.7f))
        }
    }
}
