package com.climapro.app.ui.screens.mantenimientos

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
import com.climapro.app.data.repository.MantenimientoRepository
import com.climapro.app.util.label
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MantenimientoFormViewModel @Inject constructor(private val repo: MantenimientoRepository) : ViewModel() {
    var nombre by mutableStateOf("")
    var telefono by mutableStateOf("")
    var direccion by mutableStateOf("")
    var tipoMantenimiento by mutableStateOf(TipoMantenimiento.REVISION)
    var periodicidad by mutableStateOf(Periodicidad.ANUAL)
    var precio by mutableStateOf("")
    var costeMateriales by mutableStateOf("")
    var observaciones by mutableStateOf("")
    var hora by mutableStateOf("09:00")
    var fechaSeleccionada by mutableStateOf<Long?>(null)
    var isLoading by mutableStateOf(false)

    fun cargar(id: Long) = viewModelScope.launch {
        val m = repo.getById(id) ?: return@launch
        nombre = m.nombreCliente; telefono = m.telefono; direccion = m.direccion
        tipoMantenimiento = m.tipoMantenimiento; periodicidad = m.periodicidad
        precio = if (m.precio > 0) m.precio.toString() else ""
        costeMateriales = if (m.costeMateriales > 0) m.costeMateriales.toString() else ""
        observaciones = m.observaciones; hora = m.hora; fechaSeleccionada = m.fecha
    }

    fun guardar(editId: Long?, onDone: () -> Unit) = viewModelScope.launch {
        isLoading = true
        val m = Mantenimiento(
            id = editId ?: 0,
            nombreCliente = nombre, telefono = telefono, direccion = direccion,
            fecha = fechaSeleccionada, hora = hora,
            tipoMantenimiento = tipoMantenimiento, periodicidad = periodicidad,
            precio = precio.toDoubleOrNull() ?: 0.0,
            costeMateriales = costeMateriales.toDoubleOrNull() ?: 0.0,
            observaciones = observaciones
        )
        if (editId != null) repo.update(m) else repo.insert(m)
        isLoading = false
        onDone()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MantenimientoFormScreen(navController: NavController, editId: Long?, vm: MantenimientoFormViewModel = hiltViewModel()) {
    LaunchedEffect(editId) { editId?.let { vm.cargar(it) } }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(if (editId != null) "Editar mantenimiento" else "Nuevo mantenimiento") },
                navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Default.ArrowBack, null) } },
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
            SectionCard("Trabajo", Icons.Default.Build) {
                DropdownField("Tipo de mantenimiento", TipoMantenimiento.values().map { it.label() }, TipoMantenimiento.values().indexOf(vm.tipoMantenimiento)) { vm.tipoMantenimiento = TipoMantenimiento.values()[it] }
                DropdownField("Periodicidad", Periodicidad.values().map { it.label() }, Periodicidad.values().indexOf(vm.periodicidad)) { vm.periodicidad = Periodicidad.values()[it] }
                FormField("Hora (ej: 09:00)", vm.hora, { vm.hora = it })
                FormField("Observaciones", vm.observaciones, { vm.observaciones = it }, maxLines = 3)
            }
            SectionCard("Económico", Icons.Default.EuroSymbol) {
                FormField("Precio (€)", vm.precio, { vm.precio = it })
                FormField("Coste materiales (€)", vm.costeMateriales, { vm.costeMateriales = it })
            }
            Button(
                onClick = { vm.guardar(editId) { navController.popBackStack() } },
                modifier = Modifier.fillMaxWidth().height(52.dp),
                enabled = vm.nombre.isNotBlank() && !vm.isLoading,
                colors = ButtonDefaults.buttonColors(containerColor = com.climapro.app.ui.theme.VerdePrimario)
            ) {
                if (vm.isLoading) CircularProgressIndicator(Modifier.size(18.dp), color = MaterialTheme.colorScheme.onPrimary)
                else { Icon(Icons.Default.Save, null); Spacer(Modifier.width(8.dp)); Text("Guardar mantenimiento") }
            }
        }
    }
}

@Composable
private fun SectionCard(title: String, icon: androidx.compose.ui.graphics.vector.ImageVector, content: @Composable ColumnScope.() -> Unit) {
    Card(shape = RoundedCornerShape(16.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(0.dp)) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = androidx.compose.ui.Alignment.CenterVertically) {
                Icon(icon, null, tint = com.climapro.app.ui.theme.VerdePrimario, modifier = Modifier.size(16.dp))
                Text(title, style = MaterialTheme.typography.labelLarge, color = com.climapro.app.ui.theme.VerdePrimario)
            }
            content()
        }
    }
}

@Composable
private fun FormField(label: String, value: String, onChange: (String) -> Unit, maxLines: Int = 1) {
    OutlinedTextField(value = value, onValueChange = onChange, label = { Text(label) }, modifier = Modifier.fillMaxWidth(), maxLines = maxLines, singleLine = maxLines == 1)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DropdownField(label: String, options: List<String>, selectedIndex: Int, onSelect: (Int) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    ExposedDropdownMenuBox(expanded = expanded, onExpandedChange = { expanded = it }) {
        OutlinedTextField(value = options.getOrNull(selectedIndex) ?: "", onValueChange = {}, readOnly = true,
            label = { Text(label) }, trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded) },
            modifier = Modifier.fillMaxWidth().menuAnchor())
        ExposedDropdownMenu(expanded = expanded, onDismissRequest = { expanded = false }) {
            options.forEachIndexed { i, opt -> DropdownMenuItem(text = { Text(opt) }, onClick = { onSelect(i); expanded = false }) }
        }
    }
}
