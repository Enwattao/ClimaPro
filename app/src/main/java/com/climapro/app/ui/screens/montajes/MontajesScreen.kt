package com.climapro.app.ui.screens.montajes

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
import androidx.navigation.NavController
import com.climapro.app.data.db.entity.Montaje
import com.climapro.app.ui.components.BottomNavBar
import com.climapro.app.ui.navigation.Screen
import com.climapro.app.ui.theme.*
import com.climapro.app.util.*
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MontajesScreen(navController: NavController, vm: MontajesViewModel = hiltViewModel()) {
    val state by vm.state.collectAsState()
    var montajeParaAsignar by remember { mutableStateOf<Montaje?>(null) }

    Scaffold(
        bottomBar = { BottomNavBar(navController, state.listaEsperaBadge) },
        floatingActionButton = {
            ExtendedFloatingActionButton(
                onClick = { navController.navigate(Screen.MontajeForm.create()) },
                icon = { Icon(Icons.Default.Add, null) },
                text = { Text("Nuevo montaje") },
                containerColor = AzulPrimario,
                contentColor = Color.White
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Column(Modifier.fillMaxSize().padding(padding)) {
            // Header
            Box(Modifier.fillMaxWidth().background(AzulOscuro).padding(horizontal = 16.dp, vertical = 20.dp)) {
                Column {
                    Text("Montajes", style = MaterialTheme.typography.headlineSmall, color = Color.White)
                    Spacer(Modifier.height(12.dp))
                    TabRow(state.tab, onSelect = { vm.setTab(it) }, badge = state.listaEsperaBadge)
                }
            }

            val lista = when (state.tab) {
                MontajesTab.PROGRAMADOS -> state.programados
                MontajesTab.LISTA_ESPERA -> state.listaEspera
                MontajesTab.REALIZADOS -> state.realizados
            }

            if (lista.isEmpty()) {
                Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Icon(Icons.Default.Build, null, tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(48.dp))
                        Text("Sin montajes", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    }
                }
            } else {
                LazyColumn(
                    contentPadding = PaddingValues(12.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    if (state.tab == MontajesTab.LISTA_ESPERA) {
                        item {
                            InfoBanner("Pulsa \"Asignar cita\" para programar el trabajo en el calendario.")
                        }
                    }
                    items(lista, key = { it.id }) { montaje ->
                        if (state.tab == MontajesTab.LISTA_ESPERA) {
                            EsperaCard(
                                montaje = montaje,
                                onClick = { navController.navigate(Screen.MontajeDetalle.create(montaje.id)) },
                                onAsignarCita = { montajeParaAsignar = montaje },
                                onEliminar = { vm.eliminar(montaje) }
                            )
                        } else {
                            MontajeCard(
                                montaje = montaje,
                                onClick = { navController.navigate(Screen.MontajeDetalle.create(montaje.id)) }
                            )
                        }
                    }
                    item { Spacer(Modifier.height(72.dp)) }
                }
            }
        }
    }

    montajeParaAsignar?.let { montaje ->
        AsignarCitaSheet(
            montaje = montaje,
            onDismiss = { montajeParaAsignar = null },
            onConfirm = { fecha, hora, horas ->
                vm.asignarCita(montaje, fecha, hora, horas)
                montajeParaAsignar = null
            }
        )
    }
}

@Composable
private fun TabRow(tab: MontajesTab, onSelect: (MontajesTab) -> Unit, badge: Int) {
    Row(
        Modifier.fillMaxWidth().clip(RoundedCornerShape(12.dp)).background(Color.White.copy(.08f)).padding(3.dp),
        horizontalArrangement = Arrangement.spacedBy(0.dp)
    ) {
        MontajesTab.values().forEach { t ->
            val isActive = t == tab
            Box(
                modifier = Modifier.weight(1f).clip(RoundedCornerShape(10.dp))
                    .background(if (isActive) AzulPrimario else Color.Transparent)
                    .clickable { onSelect(t) }.padding(vertical = 7.dp),
                contentAlignment = Alignment.Center
            ) {
                val label = when (t) {
                    MontajesTab.PROGRAMADOS -> "Programados"
                    MontajesTab.LISTA_ESPERA -> "En espera"
                    MontajesTab.REALIZADOS -> "Realizados"
                }
                if (t == MontajesTab.LISTA_ESPERA && badge > 0 && !isActive) {
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text(label, style = MaterialTheme.typography.labelMedium, color = Color.White.copy(.5f))
                        Box(Modifier.size(16.dp).clip(androidx.compose.foundation.shape.CircleShape).background(RojoPrimario), contentAlignment = Alignment.Center) {
                            Text("$badge", style = MaterialTheme.typography.labelSmall.copy(fontSize = androidx.compose.ui.unit.TextUnit(9f, androidx.compose.ui.unit.TextUnitType.Sp)), color = Color.White)
                        }
                    }
                } else {
                    Text(label, style = MaterialTheme.typography.labelMedium, color = if (isActive) Color.White else Color.White.copy(.5f))
                }
            }
        }
    }
}

@Composable
private fun InfoBanner(text: String) {
    Card(
        Modifier.fillMaxWidth(), shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = NaranjaLight)
    ) {
        Row(Modifier.padding(12.dp), horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Icon(Icons.Default.Info, null, tint = NaranjaPrimario, modifier = Modifier.size(18.dp))
            Text(text, style = MaterialTheme.typography.bodySmall, color = Color(0xFFCC6600))
        }
    }
}

@Composable
private fun EsperaCard(montaje: Montaje, onClick: () -> Unit, onAsignarCita: () -> Unit, onEliminar: () -> Unit) {
    Card(
        Modifier.fillMaxWidth().clickable(onClick = onClick),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Column(Modifier.padding(12.dp)) {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                Box(Modifier.size(8.dp).clip(androidx.compose.foundation.shape.CircleShape).background(NaranjaPrimario))
                Spacer(Modifier.width(8.dp))
                Text(montaje.nombreCliente, style = MaterialTheme.typography.labelLarge, modifier = Modifier.weight(1f))
                if (montaje.urgente) {
                    Box(Modifier.clip(RoundedCornerShape(8.dp)).background(RojoLight).padding(horizontal = 8.dp, vertical = 3.dp)) {
                        Text("Urgente", style = MaterialTheme.typography.labelSmall, color = RojoPrimario)
                    }
                } else {
                    Box(Modifier.clip(RoundedCornerShape(8.dp)).background(NaranjaLight).padding(horizontal = 8.dp, vertical = 3.dp)) {
                        Text("Sin fecha", style = MaterialTheme.typography.labelSmall, color = NaranjaPrimario)
                    }
                }
            }
            Spacer(Modifier.height(6.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp), modifier = Modifier.fillMaxWidth()) {
                if (montaje.marcaMaquina.isNotEmpty()) {
                    Chip(montaje.marcaMaquina + " " + montaje.tipoMaquina.label())
                }
                Chip("x${montaje.numMaquinas}")
                if (montaje.presupuesto > 0) Chip(montaje.presupuesto.toEuros(), AzulLight, AzulPrimario)
            }
            if (montaje.direccion.isNotEmpty()) {
                Spacer(Modifier.height(4.dp))
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Icon(Icons.Default.LocationOn, null, tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(12.dp))
                    Text(montaje.direccion, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 1)
                }
            }
            Spacer(Modifier.height(10.dp))
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                Button(onClick = onAsignarCita, modifier = Modifier.weight(1f), contentPadding = PaddingValues(8.dp),
                    colors = ButtonDefaults.buttonColors(containerColor = AzulPrimario)) {
                    Icon(Icons.Default.CalendarMonth, null, modifier = Modifier.size(14.dp))
                    Spacer(Modifier.width(4.dp))
                    Text("Asignar cita", style = MaterialTheme.typography.labelMedium)
                }
                OutlinedButton(onClick = {}, modifier = Modifier.weight(1f), contentPadding = PaddingValues(8.dp)) {
                    Icon(Icons.Default.Phone, null, modifier = Modifier.size(14.dp))
                    Spacer(Modifier.width(4.dp))
                    Text("Llamar", style = MaterialTheme.typography.labelMedium)
                }
                IconButton(onClick = onEliminar, modifier = Modifier.size(36.dp)) {
                    Icon(Icons.Default.Delete, null, tint = RojoPrimario, modifier = Modifier.size(18.dp))
                }
            }
        }
    }
}

@Composable
private fun MontajeCard(montaje: Montaje, onClick: () -> Unit) {
    val barColor = when {
        montaje.estado == com.climapro.app.data.db.entity.EstadoMontaje.EN_CURSO -> AzulPrimario
        montaje.estado == com.climapro.app.data.db.entity.EstadoMontaje.COBRADO -> VerdePrimario
        montaje.estado == com.climapro.app.data.db.entity.EstadoMontaje.REALIZADO -> GrisRealizado
        else -> NaranjaPrimario
    }
    val sdf = SimpleDateFormat("dd MMM", Locale("es"))

    Card(
        Modifier.fillMaxWidth().clickable(onClick = onClick),
        shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(0.dp)
    ) {
        Row(Modifier.fillMaxWidth()) {
            Box(Modifier.width(4.dp).height(76.dp).background(barColor))
            Column(Modifier.weight(1f).padding(horizontal = 12.dp, vertical = 10.dp)) {
                Text(montaje.marcaMaquina.ifEmpty { "Montaje" } + " " + montaje.modeloMaquina,
                    style = MaterialTheme.typography.labelLarge)
                Text(montaje.nombreCliente, style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
                Spacer(Modifier.height(4.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                    Chip(montaje.estado.label())
                    if (montaje.horasEstimadas > 0) Chip("${montaje.horasEstimadas}h")
                    if (montaje.presupuesto > 0) Chip(montaje.presupuesto.toEuros(), AzulLight, AzulPrimario)
                }
            }
            Column(horizontalAlignment = Alignment.End, modifier = Modifier.padding(10.dp)) {
                montaje.fecha?.let {
                    Text(sdf.format(Date(it)), style = MaterialTheme.typography.labelLarge, color = barColor)
                }
                if (montaje.hora.isNotEmpty()) {
                    Text(montaje.hora, style = MaterialTheme.typography.labelMedium, color = barColor)
                }
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
