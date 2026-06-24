package com.climapro.app.ui.screens.mantenimientos

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.climapro.app.data.db.entity.*
import com.climapro.app.data.repository.MantenimientoRepository
import com.climapro.app.ui.navigation.Screen
import com.climapro.app.ui.theme.*
import com.climapro.app.util.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MantenimientoDetalleViewModel @Inject constructor(private val repo: MantenimientoRepository) : ViewModel() {
    private val _m = MutableStateFlow<Mantenimiento?>(null)
    val mantenimiento: StateFlow<Mantenimiento?> = _m

    fun cargar(id: Long) = viewModelScope.launch { _m.value = repo.getById(id) }
    fun eliminar(m: Mantenimiento, onDone: () -> Unit) = viewModelScope.launch { repo.delete(m); onDone() }
    fun marcarRealizado(m: Mantenimiento) = viewModelScope.launch {
        repo.update(m.copy(estado = EstadoMantenimiento.REALIZADO))
        _m.value = repo.getById(m.id)
    }
    fun marcarCobrado(m: Mantenimiento, importe: Double, metodo: MetodoPago) = viewModelScope.launch {
        repo.update(m.copy(estado = EstadoMantenimiento.COBRADO, estadoCobro = EstadoCobro.COBRADO,
            importeCobrado = importe, metodoPago = metodo, fechaCobro = System.currentTimeMillis()))
        _m.value = repo.getById(m.id)
    }
    fun generarSiguiente(m: Mantenimiento) = viewModelScope.launch { repo.generarSiguiente(m) }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MantenimientoDetalleScreen(navController: NavController, id: Long, vm: MantenimientoDetalleViewModel = hiltViewModel()) {
    val m by vm.mantenimiento.collectAsState()
    val context = LocalContext.current
    var showEliminar by remember { mutableStateOf(false) }
    var showCobro by remember { mutableStateOf(false) }
    var showSiguiente by remember { mutableStateOf(false) }

    LaunchedEffect(id) { vm.cargar(id) }

    val mantenimiento = m ?: run {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
        return
    }

    val barColor = when (mantenimiento.estado) {
        EstadoMantenimiento.COBRADO -> VerdePrimario
        EstadoMantenimiento.REALIZADO -> GrisRealizado
        else -> VerdePrimario
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Mantenimiento") },
                navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Default.ArrowBack, null) } },
                actions = {
                    IconButton(onClick = { navController.navigate(Screen.MantenimientoForm.create(mantenimiento.id)) }) { Icon(Icons.Default.Edit, null) }
                    IconButton(onClick = { showEliminar = true }) { Icon(Icons.Default.Delete, null, tint = RojoPrimario) }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = AzulOscuro, titleContentColor = Color.White,
                    navigationIconContentColor = Color.White, actionIconContentColor = Color.White)
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState())) {
            Box(Modifier.fillMaxWidth().background(barColor).padding(horizontal = 16.dp, vertical = 10.dp)) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Nº MN-${String.format("%05d", mantenimiento.id)}", style = MaterialTheme.typography.labelMedium, color = Color.White)
                    Box(Modifier.clip(RoundedCornerShape(20.dp)).background(Color.White.copy(.2f)).padding(horizontal = 10.dp, vertical = 3.dp)) {
                        Text(mantenimiento.estado.label(), style = MaterialTheme.typography.labelMedium, color = Color.White)
                    }
                }
            }
            Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                DetalleCard("Cliente", Icons.Default.Person) {
                    FieldRow("Nombre", mantenimiento.nombreCliente)
                    FieldRow("Teléfono", mantenimiento.telefono, clickable = true) {
                        context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:${mantenimiento.telefono}")))
                    }
                    FieldRow("Dirección", mantenimiento.direccion, clickable = true) {
                        context.startActivity(Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=${Uri.encode(mantenimiento.direccion)}")))
                    }
                }
                DetalleCard("Trabajo", Icons.Default.Build) {
                    FieldRow("Tipo", mantenimiento.tipoMantenimiento.label())
                    mantenimiento.fecha?.let { FieldRow("Fecha", it.toFechaCorta()) }
                    if (mantenimiento.hora.isNotEmpty()) FieldRow("Hora", mantenimiento.hora)
                    FieldRow("Periodicidad", mantenimiento.periodicidad.label())
                    if (mantenimiento.observaciones.isNotEmpty()) FieldRow("Observaciones", mantenimiento.observaciones)
                }
                DetalleCard("Económico", Icons.Default.EuroSymbol) {
                    FieldRow("Precio", mantenimiento.precio.toEuros())
                    FieldRow("Coste materiales", "- ${mantenimiento.costeMateriales.toEuros()}", valueColor = RojoPrimario)
                    FieldRow("Cobrado", mantenimiento.importeCobrado.toEuros(), valueColor = VerdePrimario)
                    Divider(Modifier.padding(vertical = 4.dp))
                    FieldRow("Beneficio", mantenimiento.beneficio.toEuros(), valueColor = if (mantenimiento.beneficio >= 0) VerdePrimario else RojoPrimario, bold = true)
                    FieldRow("Método", mantenimiento.metodoPago.label())
                }
                // Acciones
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(onClick = {}, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = AzulPrimario)) {
                            Icon(Icons.Default.PictureAsPdf, null, modifier = Modifier.size(16.dp))
                            Spacer(Modifier.width(4.dp)); Text("Albarán")
                        }
                        if (mantenimiento.estado == EstadoMantenimiento.PENDIENTE) {
                            Button(onClick = { vm.marcarRealizado(mantenimiento) }, modifier = Modifier.weight(1f), colors = ButtonDefaults.buttonColors(containerColor = VerdePrimario)) {
                                Icon(Icons.Default.Check, null, modifier = Modifier.size(16.dp))
                                Spacer(Modifier.width(4.dp)); Text("Realizado")
                            }
                        }
                    }
                    if (mantenimiento.estado == EstadoMantenimiento.REALIZADO) {
                        Button(onClick = { showCobro = true }, modifier = Modifier.fillMaxWidth(), colors = ButtonDefaults.buttonColors(containerColor = VerdePrimario)) {
                            Icon(Icons.Default.EuroSymbol, null, modifier = Modifier.size(16.dp))
                            Spacer(Modifier.width(4.dp)); Text("Registrar cobro")
                        }
                    }
                    if (mantenimiento.periodicidad != Periodicidad.SIN_REPETIR && mantenimiento.estado == EstadoMantenimiento.COBRADO) {
                        OutlinedButton(onClick = { showSiguiente = true }, modifier = Modifier.fillMaxWidth()) {
                            Icon(Icons.Default.Refresh, null, modifier = Modifier.size(16.dp))
                            Spacer(Modifier.width(4.dp)); Text("Generar siguiente (${mantenimiento.periodicidad.label()})")
                        }
                    }
                }
                Spacer(Modifier.height(8.dp))
            }
        }
    }

    if (showEliminar) {
        AlertDialog(onDismissRequest = { showEliminar = false },
            title = { Text("Eliminar mantenimiento") },
            text = { Text("¿Seguro que quieres eliminar este mantenimiento?") },
            confirmButton = { TextButton(onClick = { vm.eliminar(mantenimiento) { navController.popBackStack() } }) { Text("Eliminar", color = RojoPrimario) } },
            dismissButton = { TextButton(onClick = { showEliminar = false }) { Text("Cancelar") } })
    }
    if (showCobro) {
        CobroDialogMant(precio = mantenimiento.precio, onDismiss = { showCobro = false }) { importe, metodo ->
            vm.marcarCobrado(mantenimiento, importe, metodo); showCobro = false
        }
    }
    if (showSiguiente) {
        AlertDialog(onDismissRequest = { showSiguiente = false },
            title = { Text("Generar siguiente mantenimiento") },
            text = { Text("Se creará un nuevo mantenimiento ${mantenimiento.periodicidad.label().lowercase()} para ${mantenimiento.nombreCliente}.") },
            confirmButton = { TextButton(onClick = { vm.generarSiguiente(mantenimiento); showSiguiente = false }) { Text("Generar") } },
            dismissButton = { TextButton(onClick = { showSiguiente = false }) { Text("Cancelar") } })
    }
}

@Composable
private fun DetalleCard(title: String, icon: androidx.compose.ui.graphics.vector.ImageVector, content: @Composable ColumnScope.() -> Unit) {
    Card(shape = RoundedCornerShape(14.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(0.dp)) {
        Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(bottom = 6.dp)) {
                Icon(icon, null, tint = VerdePrimario, modifier = Modifier.size(14.dp))
                Text(title.uppercase(), style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            content()
        }
    }
}

@Composable
private fun FieldRow(label: String, value: String, valueColor: Color = MaterialTheme.colorScheme.onSurface, bold: Boolean = false, clickable: Boolean = false, onClick: () -> Unit = {}) {
    Row(Modifier.fillMaxWidth().padding(vertical = 3.dp).let { if (clickable) it.then(Modifier.clickable(onClick = onClick)) else it }, horizontalArrangement = Arrangement.SpaceBetween) {
        Text(label, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.weight(1f))
        Text(value, style = if (bold) MaterialTheme.typography.labelLarge else MaterialTheme.typography.bodySmall,
            color = if (clickable) AzulPrimario else valueColor, modifier = Modifier.weight(1.2f), textAlign = TextAlign.End)
    }
}

@Composable
private fun CobroDialogMant(precio: Double, onDismiss: () -> Unit, onConfirm: (Double, MetodoPago) -> Unit) {
    var importe by remember { mutableStateOf(precio.toString()) }
    var metodo by remember { mutableStateOf(MetodoPago.EFECTIVO) }
    AlertDialog(onDismissRequest = onDismiss,
        title = { Text("Registrar cobro") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                OutlinedTextField(value = importe, onValueChange = { importe = it }, label = { Text("Importe cobrado (€)") }, modifier = Modifier.fillMaxWidth())
                MetodoPago.values().forEach { mp ->
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(selected = metodo == mp, onClick = { metodo = mp })
                        Text(mp.label(), style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        },
        confirmButton = { TextButton(onClick = { onConfirm(importe.toDoubleOrNull() ?: precio, metodo) }) { Text("Confirmar") } },
        dismissButton = { TextButton(onClick = onDismiss) { Text("Cancelar") } })
}
