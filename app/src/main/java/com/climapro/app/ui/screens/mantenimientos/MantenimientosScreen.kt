package com.climapro.app.ui.screens.mantenimientos

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.climapro.app.data.db.entity.*
import com.climapro.app.data.repository.MantenimientoRepository
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
class MantenimientosViewModel @Inject constructor(private val repo: MantenimientoRepository) : ViewModel() {
    val pendientes = repo.getByEstado(EstadoMantenimiento.PENDIENTE).stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
    val realizados = repo.getByEstado(EstadoMantenimiento.REALIZADO).stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())
    val cobrados = repo.getByEstado(EstadoMantenimiento.COBRADO).stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    fun eliminar(m: Mantenimiento) = viewModelScope.launch { repo.delete(m) }
    fun generarSiguiente(m: Mantenimiento) = viewModelScope.launch { repo.generarSiguiente(m) }
}

@Composable
fun MantenimientosScreen(navController: NavController, vm: MantenimientosViewModel = hiltViewModel()) {
    val pendientes by vm.pendientes.collectAsState()
    val realizados by vm.realizados.collectAsState()
    val cobrados by vm.cobrados.collectAsState()
    var tab by remember { mutableIntStateOf(0) }
    val tabs = listOf("Pendientes" to pendientes.size, "Realizados" to realizados.size, "Cobrados" to cobrados.size)
    val lista = when (tab) { 0 -> pendientes; 1 -> realizados; else -> cobrados }

    Scaffold(
        bottomBar = { BottomNavBar(navController) },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { navController.navigate(Screen.MantenimientoForm.create()) },
                icon = { Icon(Icons.Default.Add, null) },
                text = { Text("Nuevo mantenimiento") },
                containerColor = VerdePrimario, contentColor = Color.White
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Column(Modifier.fillMaxSize().padding(padding)) {
            Box(Modifier.fillMaxWidth().background(AzulOscuro).padding(16.dp)) {
                Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    Text("Mantenimientos", style = MaterialTheme.typography.headlineSmall, color = Color.White)
                    TabRow(selectedTabIndex = tab, containerColor = Color.Transparent, contentColor = Color.White, divider = {}) {
                        tabs.forEachIndexed { i, (label, count) ->
                            Tab(selected = tab == i, onClick = { tab = i },
                                text = { Text(if (count > 0) "$label ($count)" else label, style = MaterialTheme.typography.labelMedium) })
                        }
                    }
                }
            }
            if (lista.isEmpty()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Text("Sin mantenimientos", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            } else {
                LazyColumn(contentPadding = PaddingValues(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    items(lista, key = { it.id }) { m ->
                        MantenimientoCard(m, onClick = { navController.navigate(Screen.MantenimientoDetalle.create(m.id)) })
                    }
                    item { Spacer(Modifier.height(72.dp)) }
                }
            }
        }
    }
}

@Composable
fun MantenimientoCard(m: Mantenimiento, onClick: () -> Unit) {
    val barColor = when (m.estado) { EstadoMantenimiento.COBRADO -> VerdePrimario; EstadoMantenimiento.REALIZADO -> GrisRealizado; else -> VerdePrimario }
    val sdf = SimpleDateFormat("dd MMM", Locale("es"))
    Card(
        Modifier.fillMaxWidth().clickable(onClick = onClick),
        shape = RoundedCornerShape(14.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Row(Modifier.fillMaxWidth()) {
            Box(Modifier.width(4.dp).height(70.dp).background(barColor))
            Column(Modifier.weight(1f).padding(horizontal = 12.dp, vertical = 10.dp)) {
                Text(m.tipoMantenimiento.label(), style = MaterialTheme.typography.labelLarge)
                Text(m.nombreCliente, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(Modifier.height(4.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Chip(m.estado.label())
                    Chip(m.periodicidad.label())
                    if (m.precio > 0) Chip(m.precio.toEuros(), VerdeLight, VerdePrimario)
                }
            }
            Column(Modifier.padding(10.dp), horizontalAlignment = Alignment.End) {
                m.fecha?.let { Text(sdf.format(Date(it)), style = MaterialTheme.typography.labelLarge, color = barColor) }
                if (m.hora.isNotEmpty()) Text(m.hora, style = MaterialTheme.typography.labelMedium, color = barColor)
            }
        }
    }
}

@Composable
private fun Chip(text: String, bg: Color = GrisClaro, textColor: Color = MaterialTheme.colorScheme.onSurfaceVariant) {
    Box(Modifier.clip(RoundedCornerShape(8.dp)).background(bg).padding(horizontal = 8.dp, vertical = 3.dp)) {
        Text(text, style = MaterialTheme.typography.labelSmall, color = textColor)
    }
}
