package com.climapro.app.ui.screens.averias

import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.climapro.app.data.db.entity.*
import com.climapro.app.data.repository.AveriaRepository
import com.climapro.app.ui.components.BottomNavBar
import com.climapro.app.ui.theme.*
import com.climapro.app.util.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AveriasViewModel @Inject constructor(private val repo: AveriaRepository) : ViewModel() {
    val averias = repo.getAll().stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    var nombre by mutableStateOf("")
    var telefono by mutableStateOf("")
    var direccion by mutableStateOf("")
    var descripcion by mutableStateOf("")
    var marca by mutableStateOf("")
    var modelo by mutableStateOf("")
    var tipoMaquina by mutableStateOf(TipoMaquina.SPLIT_PARED)
    var presupuesto by mutableStateOf("")
    var observaciones by mutableStateOf("")
    var urgente by mutableStateOf(false)
    var isLoading by mutableStateOf(false)

    fun cargar(averia: Averia) {
        nombre = averia.nombreCliente; telefono = averia.telefono; direccion = averia.direccion
        descripcion = averia.descripcion; marca = averia.marcaMaquina; modelo = averia.modeloMaquina
        tipoMaquina = averia.tipoMaquina; presupuesto = if (averia.presupuesto > 0) averia.presupuesto.toString() else ""
        observaciones = averia.observaciones; urgente = averia.urgente
    }

    fun resetForm() {
        nombre = ""; telefono = ""; direccion = ""; descripcion = ""; marca = ""; modelo = ""
        tipoMaquina = TipoMaquina.SPLIT_PARED; presupuesto = ""; observaciones = ""; urgente = false
    }

    fun guardar(editId: Long? = null, onDone: () -> Unit) = viewModelScope.launch {
        isLoading = true
        val averia = Averia(
            id = editId ?: 0, nombreCliente = nombre, telefono = telefono, direccion = direccion,
            descripcion = descripcion, marcaMaquina = marca, modeloMaquina = modelo, tipoMaquina = tipoMaquina,
            presupuesto = presupuesto.toDoubleOrNull() ?: 0.0, observaciones = observaciones, urgente = urgente
        )
        if (editId != null) repo.update(averia) else repo.insert(averia)
        isLoading = false; onDone()
    }

    fun marcarResuelta(a: Averia) = viewModelScope.launch { repo.update(a.copy(estado = EstadoAveria.RESUELTA)) }
    fun marcarCobrada(a: Averia, importe: Double, metodo: MetodoPago) = viewModelScope.launch {
        repo.update(a.copy(estado = EstadoAveria.COBRADA, importeCobrado = importe, estadoCobro = EstadoCobro.COBRADO, metodoPago = metodo))
    }
    fun eliminar(a: Averia, onDone: () -> Unit) = viewModelScope.launch { repo.delete(a); onDone() }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AveriasScreen(navController: NavController, vm: AveriasViewModel = hiltViewModel()) {
    val averias by vm.averias.collectAsState()
    var mostrarForm by remember { mutableStateOf(false) }
    var averiaEditar by remember { mutableStateOf<Averia?>(null) }
    var averiaDetalle by remember { mutableStateOf<Averia?>(null) }

    val activas = averias.filter { it.estado == EstadoAveria.PENDIENTE || it.estado == EstadoAveria.EN_CURSO }
    val resueltas = averias.filter { it.estado == EstadoAveria.RESUELTA || it.estado == EstadoAveria.COBRADA }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Averías") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = AzulOscuro, titleContentColor = Color.White),
                actions = {
                    IconButton(onClick = { vm.resetForm(); mostrarForm = true }) {
                        Icon(Icons.Default.Add, null, tint = Color.White)
                    }
                }
            )
        },
        bottomBar = { BottomNavBar(navController) },
        floatingActionButton = {
            FloatingActionButton(onClick = { vm.resetForm(); mostrarForm = true }, containerColor = Color(0xFFFF6B6B)) {
                Icon(Icons.Default.Add, null, tint = Color.White)
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        if (averias.isEmpty()) {
            Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(Icons.Default.CheckCircle, null, modifier = Modifier.size(56.dp), tint = VerdePrimario)
                    Text("Sin averías activas", style = MaterialTheme.typography.titleMedium)
                    Text("Pulsa + para registrar una avería", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        } else {
            LazyColumn(Modifier.fillMaxSize().padding(padding).padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                if (activas.isNotEmpty()) {
                    item { SectionLabel("Activas (${activas.size})", Color(0xFFFF6B6B)) }
                    items(activas) { averia ->
                        AveriaCard(averia, onClick = { averiaDetalle = averia })
                    }
                }
                if (resueltas.isNotEmpty()) {
                    item { SectionLabel("Resueltas (${resueltas.size})", VerdePrimario) }
                    items(resueltas) { averia ->
                        AveriaCard(averia, onClick = { averiaDetalle = averia })
                    }
                }
            }
        }
    }

    if (mostrarForm) {
        AveriaFormSheet(vm = vm, editId = averiaEditar?.id, onDismiss = { mostrarForm = false; averiaEditar = null })
    }

    averiaDetalle?.let { a ->
        AveriaDetalleSheet(averia = a, onDismiss = { averiaDetalle = null },
            onEditar = { averiaEditar = a; vm.cargar(a); mostrarForm = true; averiaDetalle = null },
            onResuelta = { vm.marcarResuelta(a); averiaDetalle = null },
            onCobrada = { imp, met -> vm.marcarCobrada(a, imp, met); averiaDetalle = null },
            onEliminar = { vm.eliminar(a) { averiaDetalle = null } }
        )
    }
}

@Composable
private fun SectionLabel(text: String, color: Color) {
    Text(text, style = MaterialTheme.typography.labelMedium, color = color, modifier = Modifier.padding(vertical = 4.dp))
}

@Composable
private fun AveriaCard(averia: Averia, onClick: () -> Unit) {
    val estadoColor = when (averia.estado) {
        EstadoAveria.PENDIENTE -> Color(0xFFFF6B6B)
        EstadoAveria.EN_CURSO -> NaranjaPrimario
        EstadoAveria.RESUELTA -> VerdePrimario
        EstadoAveria.COBRADA -> AzulPrimario
    }
    Card(modifier = Modifier.fillMaxWidth().clickable(onClick = onClick), shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(0.dp)) {
        Row(Modifier.fillMaxWidth().padding(12.dp), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
            Box(Modifier.width(4.dp).height(54.dp).clip(RoundedCornerShape(4.dp)).background(estadoColor))
            Column(Modifier.weight(1f), verticalArrangement = Arrangement.spacedBy(2.dp)) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text(averia.nombreCliente, style = MaterialTheme.typography.labelLarge)
                    if (averia.urgente) {
                        Box(Modifier.clip(RoundedCornerShape(6.dp)).background(Color(0xFFFFEEEE)).padding(horizontal = 6.dp, vertical = 2.dp)) {
                            Text("URGENTE", style = MaterialTheme.typography.labelSmall, color = Color(0xFFFF6B6B))
                        }
                    }
                }
                Text(averia.descripcion.ifEmpty { "Sin descripción" }, style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 1)
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(averia.tipoMaquina.label(), style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    if (averia.presupuesto > 0) Text("· ${averia.presupuesto.toEuros()}", style = MaterialTheme.typography.labelSmall, color = VerdePrimario)
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AveriaFormSheet(vm: AveriasViewModel, editId: Long?, onDismiss: () -> Unit) {
    ModalBottomSheet(onDismissRequest = onDismiss, containerColor = MaterialTheme.colorScheme.surface) {
        Column(Modifier.fillMaxWidth().verticalScroll(rememberScrollState()).padding(16.dp).padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(if (editId != null) "Editar avería" else "Nueva avería", style = MaterialTheme.typography.titleMedium)
            OutlinedTextField(vm.nombre, { vm.nombre = it }, label = { Text("Cliente *") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(vm.telefono, { vm.telefono = it }, label = { Text("Teléfono") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(vm.direccion, { vm.direccion = it }, label = { Text("Dirección") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(vm.descripcion, { vm.descripcion = it }, label = { Text("Descripción de la avería *") }, modifier = Modifier.fillMaxWidth(), maxLines = 3, singleLine = false)
            OutlinedTextField(vm.marca, { vm.marca = it }, label = { Text("Marca") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(vm.modelo, { vm.modelo = it }, label = { Text("Modelo") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(vm.presupuesto, { vm.presupuesto = it }, label = { Text("Presupuesto (€)") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(vm.observaciones, { vm.observaciones = it }, label = { Text("Observaciones") }, modifier = Modifier.fillMaxWidth(), maxLines = 2, singleLine = false)
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Text("Urgente", style = MaterialTheme.typography.bodyMedium)
                Switch(vm.urgente, { vm.urgente = it })
            }
            Button(onClick = { vm.guardar(editId) { onDismiss() } }, modifier = Modifier.fillMaxWidth().height(52.dp),
                enabled = vm.nombre.isNotBlank() && vm.descripcion.isNotBlank() && !vm.isLoading,
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFFF6B6B))) {
                Text("Guardar avería")
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun AveriaDetalleSheet(averia: Averia, onDismiss: () -> Unit, onEditar: () -> Unit,
                                onResuelta: () -> Unit, onCobrada: (Double, MetodoPago) -> Unit, onEliminar: () -> Unit) {
    val context = LocalContext.current
    var showCobro by remember { mutableStateOf(false) }
    var showEliminar by remember { mutableStateOf(false) }

    ModalBottomSheet(onDismissRequest = onDismiss, containerColor = MaterialTheme.colorScheme.surface) {
        Column(Modifier.fillMaxWidth().verticalScroll(rememberScrollState()).padding(16.dp).padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                Text("Avería MT-AV-${String.format("%04d", averia.id)}", style = MaterialTheme.typography.titleMedium)
                Row {
                    IconButton(onClick = onEditar) { Icon(Icons.Default.Edit, null, tint = AzulPrimario) }
                    IconButton(onClick = { showEliminar = true }) { Icon(Icons.Default.Delete, null, tint = RojoPrimario) }
                }
            }
            if (averia.urgente) {
                Box(Modifier.clip(RoundedCornerShape(8.dp)).background(Color(0xFFFFEEEE)).padding(8.dp)) {
                    Text("⚠ Urgente", style = MaterialTheme.typography.labelMedium, color = Color(0xFFFF6B6B))
                }
            }
            DetalleRow("Cliente", averia.nombreCliente)
            if (averia.telefono.isNotEmpty()) {
                Row(Modifier.fillMaxWidth().clickable {
                    context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:${averia.telefono}")))
                }, horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                    Text("Teléfono", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                        Icon(Icons.Default.Phone, null, tint = AzulPrimario, modifier = Modifier.size(14.dp))
                        Text(averia.telefono, style = MaterialTheme.typography.bodySmall, color = AzulPrimario)
                    }
                }
            }
            if (averia.descripcion.isNotEmpty()) DetalleRow("Avería", averia.descripcion)
            if (averia.marcaMaquina.isNotEmpty()) DetalleRow("Equipo", "${averia.marcaMaquina} ${averia.modeloMaquina}".trim())
            DetalleRow("Tipo", averia.tipoMaquina.label())
            DetalleRow("Estado", averia.estado.label())
            if (averia.presupuesto > 0) DetalleRow("Presupuesto", averia.presupuesto.toEuros())
            if (averia.importeCobrado > 0) DetalleRow("Cobrado", averia.importeCobrado.toEuros())
            if (averia.observaciones.isNotEmpty()) DetalleRow("Notas", averia.observaciones)
            HorizontalDivider()
            if (averia.estado == EstadoAveria.PENDIENTE || averia.estado == EstadoAveria.EN_CURSO) {
                Button(onClick = onResuelta, modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = VerdePrimario)) {
                    Icon(Icons.Default.Check, null, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("Marcar como resuelta")
                }
            }
            if (averia.estado == EstadoAveria.RESUELTA) {
                Button(onClick = { showCobro = true }, modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(containerColor = AzulPrimario)) {
                    Icon(Icons.Default.EuroSymbol, null, modifier = Modifier.size(16.dp))
                    Spacer(Modifier.width(6.dp))
                    Text("Registrar cobro")
                }
            }
        }
    }

    if (showEliminar) {
        AlertDialog(onDismissRequest = { showEliminar = false },
            title = { Text("Eliminar avería") },
            text = { Text("¿Eliminar la avería de ${averia.nombreCliente}?") },
            confirmButton = { TextButton(onClick = { onEliminar(); showEliminar = false }) { Text("Eliminar", color = RojoPrimario) } },
            dismissButton = { TextButton(onClick = { showEliminar = false }) { Text("Cancelar") } })
    }

    if (showCobro) {
        var importe by remember { mutableStateOf(averia.presupuesto.toString()) }
        var metodo by remember { mutableStateOf(MetodoPago.EFECTIVO) }
        AlertDialog(onDismissRequest = { showCobro = false },
            title = { Text("Registrar cobro") },
            text = {
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    OutlinedTextField(importe, { importe = it }, label = { Text("Importe (€)") }, modifier = Modifier.fillMaxWidth())
                    MetodoPago.values().forEach { mp ->
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            RadioButton(mp == metodo, { metodo = mp })
                            Text(mp.label())
                        }
                    }
                }
            },
            confirmButton = { TextButton(onClick = { onCobrada(importe.toDoubleOrNull() ?: averia.presupuesto, metodo); showCobro = false }) { Text("Confirmar") } },
            dismissButton = { TextButton(onClick = { showCobro = false }) { Text("Cancelar") } })
    }
}

@Composable
private fun DetalleRow(label: String, value: String) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
        Text(label, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.weight(1f))
        Text(value, style = MaterialTheme.typography.bodySmall, modifier = Modifier.weight(1.5f), textAlign = androidx.compose.ui.text.style.TextAlign.End)
    }
}
