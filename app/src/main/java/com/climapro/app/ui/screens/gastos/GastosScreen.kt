package com.climapro.app.ui.screens.gastos

import androidx.compose.foundation.background
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.climapro.app.data.db.entity.CategoriaGasto
import com.climapro.app.data.db.entity.Gasto
import com.climapro.app.data.repository.GastoRepository
import com.climapro.app.ui.components.BottomNavBar
import com.climapro.app.ui.theme.*
import com.climapro.app.util.label
import com.climapro.app.util.toEuros
import com.climapro.app.util.toFechaCorta
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.util.Calendar
import javax.inject.Inject

@HiltViewModel
class GastosViewModel @Inject constructor(private val repo: GastoRepository) : ViewModel() {
    val gastos = repo.getAll().stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    var concepto by mutableStateOf("")
    var importe by mutableStateOf("")
    var categoria by mutableStateOf(CategoriaGasto.MATERIALES)
    var notas by mutableStateOf("")
    var isLoading by mutableStateOf(false)

    fun resetForm() { concepto = ""; importe = ""; categoria = CategoriaGasto.MATERIALES; notas = "" }

    fun cargar(g: Gasto) {
        concepto = g.concepto; importe = g.importe.toString()
        categoria = g.categoria; notas = g.notas
    }

    fun guardar(editId: Long? = null, onDone: () -> Unit) = viewModelScope.launch {
        isLoading = true
        val gasto = Gasto(id = editId ?: 0, concepto = concepto, importe = importe.toDoubleOrNull() ?: 0.0,
            categoria = categoria, notas = notas)
        if (editId != null) repo.update(gasto) else repo.insert(gasto)
        isLoading = false; onDone()
    }

    fun eliminar(g: Gasto, onDone: () -> Unit) = viewModelScope.launch { repo.delete(g); onDone() }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GastosScreen(navController: NavController, vm: GastosViewModel = hiltViewModel()) {
    val gastos by vm.gastos.collectAsState()
    var mostrarForm by remember { mutableStateOf(false) }
    var gastoEditar by remember { mutableStateOf<Gasto?>(null) }

    val cal = Calendar.getInstance()
    cal.set(Calendar.DAY_OF_MONTH, 1); cal.set(Calendar.HOUR_OF_DAY, 0)
    val inicioMes = cal.timeInMillis
    val gastosMes = gastos.filter { it.fecha >= inicioMes }
    val totalMes = gastosMes.sumOf { it.importe }

    val categoriaColor = { cat: CategoriaGasto ->
        when (cat) {
            CategoriaGasto.MATERIALES -> AzulPrimario
            CategoriaGasto.SUELDO_AYUDANTE -> VerdePrimario
            CategoriaGasto.HERRAMIENTAS -> NaranjaPrimario
            CategoriaGasto.COMBUSTIBLE -> Color(0xFFFF6B6B)
            CategoriaGasto.SEGUROS -> Color(0xFF9C6ADE)
            CategoriaGasto.OTROS -> GrisRealizado
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Gastos") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = AzulOscuro, titleContentColor = Color.White)
            )
        },
        bottomBar = { BottomNavBar(navController) },
        floatingActionButton = {
            FloatingActionButton(onClick = { vm.resetForm(); gastoEditar = null; mostrarForm = true }, containerColor = RojoPrimario) {
                Icon(Icons.Default.Add, null, tint = Color.White)
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        LazyColumn(Modifier.fillMaxSize().padding(padding).padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            item {
                Card(shape = RoundedCornerShape(14.dp),
                    colors = CardDefaults.cardColors(containerColor = RojoPrimario), elevation = CardDefaults.cardElevation(0.dp)) {
                    Column(Modifier.fillMaxWidth().padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                        Text("Total gastos este mes", style = MaterialTheme.typography.labelMedium, color = Color.White.copy(.7f))
                        Text(totalMes.toEuros(), style = MaterialTheme.typography.headlineMedium, color = Color.White)
                        Text("${gastosMes.size} registros", style = MaterialTheme.typography.labelSmall, color = Color.White.copy(.6f))
                    }
                }
            }
            item {
                val porCategoria = CategoriaGasto.values().mapNotNull { cat ->
                    val total = gastos.sumOf { if (it.categoria == cat) it.importe else 0.0 }
                    if (total > 0) Pair(cat, total) else null
                }.sortedByDescending { it.second }

                if (porCategoria.isNotEmpty()) {
                    Card(shape = RoundedCornerShape(14.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(0.dp)) {
                        Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Text("Por categoría", style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.onSurfaceVariant)
                            porCategoria.forEach { (cat, total) ->
                                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                                    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                                        Box(Modifier.size(10.dp).clip(RoundedCornerShape(2.dp)).background(categoriaColor(cat)))
                                        Text(cat.label(), style = MaterialTheme.typography.bodySmall)
                                    }
                                    Text(total.toEuros(), style = MaterialTheme.typography.labelMedium, color = RojoPrimario)
                                }
                            }
                        }
                    }
                }
            }
            if (gastos.isEmpty()) {
                item {
                    Box(Modifier.fillMaxWidth().padding(40.dp), contentAlignment = Alignment.Center) {
                        Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)) {
                            Icon(Icons.Default.Receipt, null, modifier = Modifier.size(48.dp), tint = MaterialTheme.colorScheme.onSurfaceVariant)
                            Text("Sin gastos registrados", style = MaterialTheme.typography.bodyMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                }
            } else {
                item { Text("Todos los gastos", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.padding(top = 4.dp)) }
                items(gastos) { g ->
                    GastoCard(g, categoriaColor(g.categoria),
                        onEditar = { vm.cargar(g); gastoEditar = g; mostrarForm = true },
                        onEliminar = { vm.eliminar(g) {} })
                }
            }
        }
    }

    if (mostrarForm) {
        GastoFormSheet(vm = vm, editId = gastoEditar?.id, onDismiss = { mostrarForm = false; gastoEditar = null })
    }
}

@Composable
private fun GastoCard(gasto: Gasto, color: Color, onEditar: () -> Unit, onEliminar: () -> Unit) {
    Card(shape = RoundedCornerShape(12.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(0.dp)) {
        Row(Modifier.fillMaxWidth().padding(12.dp), horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(Modifier.size(40.dp).clip(RoundedCornerShape(10.dp)).background(color.copy(.12f)), contentAlignment = Alignment.Center) {
                Icon(Icons.Default.Receipt, null, tint = color, modifier = Modifier.size(18.dp))
            }
            Column(Modifier.weight(1f)) {
                Text(gasto.concepto, style = MaterialTheme.typography.labelLarge)
                Text(gasto.categoria.label() + " · " + gasto.fecha.toFechaCorta(), style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            Text(gasto.importe.toEuros(), style = MaterialTheme.typography.titleSmall, color = RojoPrimario)
            IconButton(onClick = onEditar, modifier = Modifier.size(32.dp)) { Icon(Icons.Default.Edit, null, modifier = Modifier.size(16.dp)) }
            IconButton(onClick = onEliminar, modifier = Modifier.size(32.dp)) { Icon(Icons.Default.Delete, null, tint = RojoPrimario, modifier = Modifier.size(16.dp)) }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun GastoFormSheet(vm: GastosViewModel, editId: Long?, onDismiss: () -> Unit) {
    ModalBottomSheet(onDismissRequest = onDismiss, containerColor = MaterialTheme.colorScheme.surface) {
        Column(Modifier.fillMaxWidth().verticalScroll(rememberScrollState()).padding(16.dp).padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Text(if (editId != null) "Editar gasto" else "Nuevo gasto", style = MaterialTheme.typography.titleMedium)
            OutlinedTextField(vm.concepto, { vm.concepto = it }, label = { Text("Concepto *") }, modifier = Modifier.fillMaxWidth())
            OutlinedTextField(vm.importe, { vm.importe = it }, label = { Text("Importe (€) *") }, modifier = Modifier.fillMaxWidth())

            Text("Categoría", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
            val cats = CategoriaGasto.values()
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                cats.take(3).forEach { cat ->
                    FilterChip(selected = vm.categoria == cat, onClick = { vm.categoria = cat },
                        label = { Text(cat.label(), style = MaterialTheme.typography.labelSmall) },
                        modifier = Modifier.weight(1f))
                }
            }
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                cats.drop(3).forEach { cat ->
                    FilterChip(selected = vm.categoria == cat, onClick = { vm.categoria = cat },
                        label = { Text(cat.label(), style = MaterialTheme.typography.labelSmall) },
                        modifier = Modifier.weight(1f))
                }
            }
            OutlinedTextField(vm.notas, { vm.notas = it }, label = { Text("Notas") }, modifier = Modifier.fillMaxWidth(), maxLines = 2, singleLine = false)
            Button(onClick = { vm.guardar(editId) { onDismiss() } }, modifier = Modifier.fillMaxWidth().height(52.dp),
                enabled = vm.concepto.isNotBlank() && vm.importe.isNotBlank() && !vm.isLoading) {
                Text("Guardar gasto")
            }
        }
    }
}
