package com.climapro.app.ui.screens.montajes

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.climapro.app.data.db.entity.*
import com.climapro.app.data.repository.MontajeRepository
import com.climapro.app.util.label
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MontajeFormViewModel @Inject constructor(private val repo: MontajeRepository) : ViewModel() {
    var nombre by mutableStateOf("")
    var telefono by mutableStateOf("")
    var direccion by mutableStateOf("")
    var marca by mutableStateOf("")
    var modelo by mutableStateOf("")
    var tipoMaquina by mutableStateOf(TipoMaquina.SPLIT_PARED)
    var numMaquinas by mutableStateOf("1")
    var presupuesto by mutableStateOf("")
    var costeMateriales by mutableStateOf("")
    var observaciones by mutableStateOf("")
    var urgente by mutableStateOf(false)
    var conCita by mutableStateOf(false)
    var hora by mutableStateOf("09:00")
    var horasEstimadas by mutableStateOf("3")
    var fechaSeleccionada by mutableStateOf<Long?>(null)
    var isLoading by mutableStateOf(false)

    fun cargar(id: Long) = viewModelScope.launch {
        val m = repo.getById(id) ?: return@launch
        nombre = m.nombreCliente; telefono = m.telefono; direccion = m.direccion
        marca = m.marcaMaquina; modelo = m.modeloMaquina; tipoMaquina = m.tipoMaquina
        numMaquinas = m.numMaquinas.toString(); presupuesto = if (m.presupuesto > 0) m.presupuesto.toString() else ""
        costeMateriales = if (m.costeMateriales > 0) m.costeMateriales.toString() else ""
        observaciones = m.observaciones; urgente = m.urgente
        conCita = m.fecha != null; hora = m.hora
        horasEstimadas = if (m.horasEstimadas > 0) m.horasEstimadas.toString() else "3"
        fechaSeleccionada = m.fecha
    }

    fun guardar(editId: Long?, onDone: () -> Unit) = viewModelScope.launch {
        isLoading = true
        val fecha = if (conCita) fechaSeleccionada else null
        val estado = if (conCita && fecha != null) EstadoMontaje.PENDIENTE else EstadoMontaje.LISTA_ESPERA
        val montaje = Montaje(
            id = editId ?: 0,
            nombreCliente = nombre, telefono = telefono, direccion = direccion,
            fecha = fecha, hora = hora, horasEstimadas = horasEstimadas.toFloatOrNull() ?: 0f,
            marcaMaquina = marca, modeloMaquina = modelo, tipoMaquina = tipoMaquina,
            numMaquinas = numMaquinas.toIntOrNull() ?: 1,
            presupuesto = presupuesto.toDoubleOrNull() ?: 0.0,
            costeMateriales = costeMateriales.toDoubleOrNull() ?: 0.0,
            observaciones = observaciones, estado = estado, urgente = urgente
        )
        if (editId != null) repo.update(montaje) else repo.insert(montaje)
        isLoading = false
        onDone()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MontajeFormScreen(navController: NavController, editId: Long?, vm: MontajeFormViewModel = hiltViewModel()) {
    var mostrarCalendario by remember { mutableStateOf(false) }

    LaunchedEffect(editId) { editId?.let { vm.cargar(it) } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (editId != null) "Editar montaje" else "Nuevo montaje") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface)
            )
        }
    ) { padding ->
        Column(
            Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState()).padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            SectionCard("Datos del cliente", Icons.Default.Person) {
                FormField("Nombre del cliente *", vm.nombre, { vm.nombre = it })
                FormField("Teléfono", vm.telefono, { vm.telefono = it })
                FormField("Dirección", vm.direccion, { vm.direccion = it })
            }

            SectionCard("Equipo", Icons.Default.AcUnit) {
                FormField("Marca", vm.marca, { vm.marca = it })
                FormField("Modelo", vm.modelo, { vm.modelo = it })
                DropdownField("Tipo de máquina", TipoMaquina.values().map { it.label() }, TipoMaquina.values().indexOf(vm.tipoMaquina)) { vm.tipoMaquina = TipoMaquina.values()[it] }
                FormField("Número de unidades", vm.numMaquinas, { vm.numMaquinas = it })
            }

            SectionCard("Planificación", Icons.Default.CalendarMonth) {
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                    Text("¿Tiene fecha asignada?", style = MaterialTheme.typography.bodyMedium)
                    Switch(checked = vm.conCita, onCheckedChange = { vm.conCita = it })
                }
                if (vm.conCita) {
                    OutlinedButton(onClick = { mostrarCalendario = true }, modifier = Modifier.fillMaxWidth()) {
                        Icon(Icons.Default.CalendarMonth, null)
                        Spacer(Modifier.width(8.dp))
                        Text(vm.fechaSeleccionada?.let { java.text.SimpleDateFormat("dd/MM/yyyy", java.util.Locale("es")).format(java.util.Date(it)) } ?: "Seleccionar fecha")
                    }
                    FormField("Hora (ej: 09:00)", vm.hora, { vm.hora = it })
                    FormField("Horas estimadas", vm.horasEstimadas, { vm.horasEstimadas = it })
                } else {
                    Row(verticalAlignment = androidx.compose.ui.Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween, modifier = Modifier.fillMaxWidth()) {
                        Text("Marcar como urgente", style = MaterialTheme.typography.bodyMedium)
                        Switch(checked = vm.urgente, onCheckedChange = { vm.urgente = it })
                    }
                }
            }

            SectionCard("Económico", Icons.Default.EuroSymbol) {
                FormField("Presupuesto (€)", vm.presupuesto, { vm.presupuesto = it })
                FormField("Observaciones", vm.observaciones, { vm.observaciones = it }, maxLines = 3)
                Text("Los gastos (materiales, sueldo ayudante, etc.) se registran en la sección Gastos.",
                    style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }

            Button(
                onClick = { vm.guardar(editId) { navController.popBackStack() } },
                modifier = Modifier.fillMaxWidth().height(52.dp),
                enabled = vm.nombre.isNotBlank() && !vm.isLoading
            ) {
                if (vm.isLoading) CircularProgressIndicator(Modifier.size(18.dp), color = MaterialTheme.colorScheme.onPrimary)
                else { Icon(Icons.Default.Save, null); Spacer(Modifier.width(8.dp)); Text("Guardar montaje") }
            }
        }
    }

    if (mostrarCalendario) {
        AsignarCitaSheet(
            montaje = com.climapro.app.data.db.entity.Montaje(nombreCliente = vm.nombre, telefono = vm.telefono, direccion = vm.direccion),
            onDismiss = { mostrarCalendario = false },
            onConfirm = { fecha, hora, horas ->
                vm.fechaSeleccionada = fecha
                vm.hora = hora
                vm.horasEstimadas = horas.toString()
                mostrarCalendario = false
            }
        )
    }
}

@Composable
private fun SectionCard(title: String, icon: androidx.compose.ui.graphics.vector.ImageVector, content: @Composable ColumnScope.() -> Unit) {
    Card(shape = RoundedCornerShape(16.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(0.dp)) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Icon(icon, null, tint = com.climapro.app.ui.theme.AzulPrimario, modifier = Modifier.size(16.dp))
                Text(title, style = MaterialTheme.typography.labelLarge, color = com.climapro.app.ui.theme.AzulPrimario)
            }
            content()
        }
    }
}

@Composable
private fun FormField(label: String, value: String, onChange: (String) -> Unit, maxLines: Int = 1) {
    OutlinedTextField(value = value, onValueChange = onChange, label = { Text(label) },
        modifier = Modifier.fillMaxWidth(), maxLines = maxLines, singleLine = maxLines == 1)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DropdownField(label: String, options: List<String>, selectedIndex: Int, onSelect: (Int) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = it }) {
        OutlinedTextField(value = options.getOrNull(selectedIndex) ?: "", onValueChange = {},
            readOnly = true, label = { Text(label) }, trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
            modifier = Modifier.fillMaxWidth().menuAnchor())
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEachIndexed { i, opt ->
                DropdownMenuItem(text = { Text(opt) }, onClick = { onSelect(i); expanded = false })
            }
        }
    }
}
