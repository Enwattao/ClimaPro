package com.climapro.app.ui.screens.montajes

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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.climapro.app.data.db.entity.*
import com.climapro.app.data.preferences.AppPreferences
import com.climapro.app.data.repository.MontajeRepository
import com.climapro.app.util.PdfGenerator
import com.climapro.app.ui.navigation.Screen
import com.climapro.app.ui.theme.*
import com.climapro.app.util.*
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.core.content.FileProvider
import androidx.compose.runtime.rememberCoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MontajeDetalleViewModel @Inject constructor(
    private val repo: MontajeRepository,
    private val pdfGenerator: PdfGenerator,
    private val prefs: AppPreferences
) : ViewModel() {
    private val _montaje = MutableStateFlow<Montaje?>(null)
    val montaje: StateFlow<Montaje?> = _montaje

    fun cargar(id: Long) = viewModelScope.launch { _montaje.value = repo.getById(id) }
    fun eliminar(m: Montaje, onDone: () -> Unit) = viewModelScope.launch { repo.delete(m); onDone() }
    fun marcarRealizado(m: Montaje) = viewModelScope.launch {
        repo.update(m.copy(estado = EstadoMontaje.REALIZADO, fechaFinalizacion = System.currentTimeMillis()))
        _montaje.value = repo.getById(m.id)
    }
    fun marcarCobrado(m: Montaje, importe: Double, metodo: MetodoPago) = viewModelScope.launch {
        repo.update(m.copy(estado = EstadoMontaje.COBRADO, estadoCobro = EstadoCobro.COBRADO,
            importeCobrado = importe, metodoPago = metodo, fechaCobro = System.currentTimeMillis()))
        _montaje.value = repo.getById(m.id)
    }
    suspend fun generarAlbaran(m: Montaje) = kotlinx.coroutines.withContext(kotlinx.coroutines.Dispatchers.IO) {
        val nombre = prefs.empresaNombre.first()
        val tel = prefs.empresaTelefono.first()
        val dir = prefs.empresaDireccion.first()
        pdfGenerator.generarAlbaranMontaje(m, "MT-${String.format("%05d", m.id)}", nombre, tel, dir)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MontajeDetalleScreen(navController: NavController, id: Long, vm: MontajeDetalleViewModel = hiltViewModel()) {
    val montaje by vm.montaje.collectAsState()
    val context = LocalContext.current
    var showEliminar by remember { mutableStateOf(false) }
    var showCobro by remember { mutableStateOf(false) }
    var generandoPdf by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    LaunchedEffect(id) { vm.cargar(id) }

    val m = montaje ?: run {
        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) { CircularProgressIndicator() }
        return
    }

    val estadoColor = when (m.estado) {
        EstadoMontaje.EN_CURSO -> AzulPrimario
        EstadoMontaje.COBRADO -> VerdePrimario
        EstadoMontaje.REALIZADO -> GrisRealizado
        EstadoMontaje.LISTA_ESPERA -> NaranjaPrimario
        else -> NaranjaPrimario
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ficha de montaje") },
                navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Default.ArrowBack, null) } },
                actions = {
                    IconButton(onClick = { navController.navigate(Screen.MontajeForm.create(m.id)) }) { Icon(Icons.Default.Edit, null) }
                    IconButton(onClick = { showEliminar = true }) { Icon(Icons.Default.Delete, null, tint = RojoPrimario) }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = AzulOscuro, titleContentColor = Color.White,
                    navigationIconContentColor = Color.White, actionIconContentColor = Color.White)
            )
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Column(
            Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState())
        ) {
            // Estado banner
            Box(Modifier.fillMaxWidth().background(estadoColor).padding(horizontal = 16.dp, vertical = 10.dp)) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("Nº MT-${String.format("%05d", m.id)}", style = MaterialTheme.typography.labelMedium, color = Color.White)
                    Box(Modifier.clip(RoundedCornerShape(20.dp)).background(Color.White.copy(.2f)).padding(horizontal = 10.dp, vertical = 3.dp)) {
                        Text(m.estado.label(), style = MaterialTheme.typography.labelMedium, color = Color.White)
                    }
                }
            }

            Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
                // Cliente
                DetalleCard("Cliente", Icons.Default.Person) {
                    FieldRow("Nombre", m.nombreCliente)
                    Row(Modifier.fillMaxWidth().padding(vertical = 3.dp), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                        Text("Teléfono", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.weight(1f))
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Text(m.telefono, style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurface)
                            if (m.telefono.isNotEmpty()) {
                                OutlinedButton(onClick = { context.startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:${m.telefono}"))) },
                                    contentPadding = PaddingValues(horizontal = 8.dp, vertical = 2.dp),
                                    modifier = Modifier.height(28.dp)) {
                                    Icon(Icons.Default.Phone, null, modifier = Modifier.size(12.dp))
                                    Spacer(Modifier.width(4.dp))
                                    Text("Llamar", style = MaterialTheme.typography.labelSmall)
                                }
                            }
                        }
                    }
                    FieldRow("Dirección", m.direccion, clickable = true) {
                        val uri = Uri.parse("geo:0,0?q=${Uri.encode(m.direccion)}")
                        context.startActivity(Intent(Intent.ACTION_VIEW, uri))
                    }
                }

                // Planificación
                if (m.tieneCita) {
                    DetalleCard("Planificación", Icons.Default.CalendarMonth) {
                        FieldRow("Fecha", m.fecha!!.toFechaCorta())
                        FieldRow("Hora", m.hora)
                        if (m.horasEstimadas > 0) FieldRow("Duración estimada", "${m.horasEstimadas} horas")
                    }
                }

                // Equipo
                DetalleCard("Equipo instalado", Icons.Default.AcUnit) {
                    if (m.marcaMaquina.isNotEmpty()) FieldRow("Marca", m.marcaMaquina)
                    if (m.modeloMaquina.isNotEmpty()) FieldRow("Modelo", m.modeloMaquina)
                    FieldRow("Tipo", m.tipoMaquina.label())
                    FieldRow("Unidades", "${m.numMaquinas}")
                }

                // Económico
                DetalleCard("Control económico", Icons.Default.EuroSymbol) {
                    FieldRow("Presupuesto", m.presupuesto.toEuros())
                    FieldRow("Importe cobrado", m.importeCobrado.toEuros(), valueColor = VerdePrimario)
                    Divider(Modifier.padding(vertical = 4.dp))
                    FieldRow("Beneficio", m.beneficio.toEuros(), valueColor = if (m.beneficio >= 0) VerdePrimario else RojoPrimario, bold = true)
                    FieldRow("Método de pago", m.metodoPago.label())
                    if (m.fechaCobro != null) FieldRow("Fecha cobro", m.fechaCobro.toFechaCorta())
                }

                if (m.observaciones.isNotEmpty()) {
                    DetalleCard("Observaciones", Icons.Default.Notes) {
                        Text(m.observaciones, style = MaterialTheme.typography.bodyMedium)
                    }
                }

                // Acciones
                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                        Button(
                            onClick = {
                                scope.launch {
                                    generandoPdf = true
                                    try {
                                        val file = vm.generarAlbaran(m)
                                        val uri = FileProvider.getUriForFile(context, "${context.packageName}.fileprovider", file)
                                        val intent = Intent(Intent.ACTION_VIEW).apply {
                                            setDataAndType(uri, "application/pdf")
                                            addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_ACTIVITY_NEW_TASK)
                                        }
                                        val chooser = Intent.createChooser(intent, "Abrir albarán").apply {
                                            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                                        }
                                        try {
                                            context.startActivity(chooser)
                                        } catch (e: android.content.ActivityNotFoundException) {
                                            val shareIntent = Intent(Intent.ACTION_SEND).apply {
                                                type = "application/pdf"
                                                putExtra(Intent.EXTRA_STREAM, uri)
                                                addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION or Intent.FLAG_ACTIVITY_NEW_TASK)
                                            }
                                            context.startActivity(Intent.createChooser(shareIntent, "Compartir albarán").apply { addFlags(Intent.FLAG_ACTIVITY_NEW_TASK) })
                                        }
                                    } finally { generandoPdf = false }
                                }
                            },
                            modifier = Modifier.weight(1f),
                            enabled = !generandoPdf,
                            colors = ButtonDefaults.buttonColors(containerColor = AzulPrimario)) {
                            if (generandoPdf) CircularProgressIndicator(Modifier.size(14.dp), color = Color.White, strokeWidth = 2.dp)
                            else { Icon(Icons.Default.PictureAsPdf, null, modifier = Modifier.size(16.dp)); Spacer(Modifier.width(4.dp)); Text("Albarán PDF") }
                        }
                        if (m.estado == EstadoMontaje.PENDIENTE || m.estado == EstadoMontaje.EN_CURSO) {
                            Button(onClick = { vm.marcarRealizado(m) }, modifier = Modifier.weight(1f),
                                colors = ButtonDefaults.buttonColors(containerColor = VerdePrimario)) {
                                Icon(Icons.Default.Check, null, modifier = Modifier.size(16.dp))
                                Spacer(Modifier.width(4.dp))
                                Text("Realizado")
                            }
                        }
                    }
                    if (m.estado == EstadoMontaje.REALIZADO) {
                        Button(onClick = { showCobro = true }, modifier = Modifier.fillMaxWidth(),
                            colors = ButtonDefaults.buttonColors(containerColor = VerdePrimario)) {
                            Icon(Icons.Default.EuroSymbol, null, modifier = Modifier.size(16.dp))
                            Spacer(Modifier.width(4.dp))
                            Text("Registrar cobro")
                        }
                    }
                }
                Spacer(Modifier.height(8.dp))
            }
        }
    }

    if (showEliminar) {
        AlertDialog(
            onDismissRequest = { showEliminar = false },
            title = { Text("Eliminar montaje") },
            text = { Text("¿Seguro que quieres eliminar el montaje de ${m.nombreCliente}? Esta acción no se puede deshacer.") },
            confirmButton = { TextButton(onClick = { vm.eliminar(m) { navController.popBackStack() } }) { Text("Eliminar", color = RojoPrimario) } },
            dismissButton = { TextButton(onClick = { showEliminar = false }) { Text("Cancelar") } }
        )
    }

    if (showCobro) {
        CobroDialog(presupuesto = m.presupuesto, onDismiss = { showCobro = false }) { importe, metodo ->
            vm.marcarCobrado(m, importe, metodo); showCobro = false
        }
    }
}

@Composable
private fun DetalleCard(title: String, icon: androidx.compose.ui.graphics.vector.ImageVector, content: @Composable ColumnScope.() -> Unit) {
    Card(shape = RoundedCornerShape(14.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(0.dp)) {
        Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(6.dp), verticalAlignment = Alignment.CenterVertically, modifier = Modifier.padding(bottom = 6.dp)) {
                Icon(icon, null, tint = AzulPrimario, modifier = Modifier.size(14.dp))
                Text(title.uppercase(), style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant, letterSpacing = androidx.compose.ui.unit.TextUnit(0.5f, androidx.compose.ui.unit.TextUnitType.Sp))
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
            color = if (clickable) AzulPrimario else valueColor, modifier = Modifier.weight(1.2f), textAlign = androidx.compose.ui.text.style.TextAlign.End)
    }
}

@Composable
private fun CobroDialog(presupuesto: Double, onDismiss: () -> Unit, onConfirm: (Double, MetodoPago) -> Unit) {
    var importe by remember { mutableStateOf(presupuesto.toString()) }
    var metodo by remember { mutableStateOf(MetodoPago.EFECTIVO) }
    AlertDialog(
        onDismissRequest = onDismiss,
        title = { Text("Registrar cobro") },
        text = {
            Column(verticalArrangement = Arrangement.spacedBy(10.dp)) {
                OutlinedTextField(value = importe, onValueChange = { importe = it }, label = { Text("Importe cobrado (€)") }, modifier = Modifier.fillMaxWidth())
                Text("Método de pago", style = MaterialTheme.typography.labelMedium)
                MetodoPago.values().forEach { mp ->
                    Row(verticalAlignment = Alignment.CenterVertically, modifier = Modifier.fillMaxWidth()) {
                        RadioButton(selected = metodo == mp, onClick = { metodo = mp })
                        Text(mp.label(), style = MaterialTheme.typography.bodyMedium)
                    }
                }
            }
        },
        confirmButton = { TextButton(onClick = { onConfirm(importe.toDoubleOrNull() ?: presupuesto, metodo) }) { Text("Confirmar") } },
        dismissButton = { TextButton(onClick = onDismiss) { Text("Cancelar") } }
    )
}
