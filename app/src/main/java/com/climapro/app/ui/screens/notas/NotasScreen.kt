package com.climapro.app.ui.screens.notas

import android.app.AlarmManager
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
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
import androidx.core.app.NotificationCompat
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.climapro.app.data.db.entity.Nota
import com.climapro.app.data.repository.NotaRepository
import com.climapro.app.ui.components.BottomNavBar
import com.climapro.app.ui.theme.*
import com.climapro.app.util.toFechaCorta
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

class NotaRecordatorioReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val titulo = intent.getStringExtra("titulo") ?: "Recordatorio"
        val contenido = intent.getStringExtra("contenido") ?: ""
        val nm = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        val notif = NotificationCompat.Builder(context, "climapro_recordatorios")
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle("📝 $titulo")
            .setContentText(contenido.ifEmpty { "Tienes un recordatorio pendiente" })
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)
            .build()
        nm.notify(intent.getIntExtra("notaId", 0), notif)
    }
}

@HiltViewModel
class NotasViewModel @Inject constructor(private val repo: NotaRepository) : ViewModel() {
    val notas = repo.getAll().stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), emptyList())

    var titulo by mutableStateOf("")
    var contenido by mutableStateOf("")
    var conRecordatorio by mutableStateOf(false)
    var recordatorioFecha by mutableStateOf<Long?>(null)
    var recordatorioHora by mutableStateOf("09:00")

    fun resetForm() { titulo = ""; contenido = ""; conRecordatorio = false; recordatorioFecha = null; recordatorioHora = "09:00" }

    fun cargar(nota: Nota) {
        titulo = nota.titulo; contenido = nota.contenido
        conRecordatorio = nota.recordatorioFecha != null
        recordatorioFecha = nota.recordatorioFecha; recordatorioHora = nota.recordatorioHora
    }

    fun guardar(context: Context, editId: Long? = null, onDone: () -> Unit) = viewModelScope.launch {
        val fecha = if (conRecordatorio) recordatorioFecha else null
        val hora = if (conRecordatorio) recordatorioHora else ""
        val nota = Nota(id = editId ?: 0, titulo = titulo, contenido = contenido,
            recordatorioFecha = fecha, recordatorioHora = hora, recordatorioNotificado = false)
        val id = if (editId != null) { repo.update(nota); editId } else repo.insert(nota)
        if (fecha != null) programarAlarma(context, id, titulo, contenido, fecha, hora)
        onDone()
    }

    fun eliminar(context: Context, nota: Nota, onDone: () -> Unit) = viewModelScope.launch {
        cancelarAlarma(context, nota.id)
        repo.delete(nota); onDone()
    }

    private fun programarAlarma(context: Context, id: Long, titulo: String, contenido: String, fecha: Long, hora: String) {
        val partes = hora.split(":").map { it.toIntOrNull() ?: 0 }
        val cal = Calendar.getInstance().apply {
            timeInMillis = fecha
            set(Calendar.HOUR_OF_DAY, partes.getOrElse(0) { 9 })
            set(Calendar.MINUTE, partes.getOrElse(1) { 0 })
            set(Calendar.SECOND, 0)
        }
        val intent = Intent(context, NotaRecordatorioReceiver::class.java).apply {
            putExtra("notaId", id.toInt()); putExtra("titulo", titulo); putExtra("contenido", contenido)
        }
        val pi = PendingIntent.getBroadcast(context, id.toInt(), intent, PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE)
        val am = context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
        am.setExactAndAllowWhileIdle(AlarmManager.RTC_WAKEUP, cal.timeInMillis, pi)
    }

    private fun cancelarAlarma(context: Context, id: Long) {
        val intent = Intent(context, NotaRecordatorioReceiver::class.java)
        val pi = PendingIntent.getBroadcast(context, id.toInt(), intent, PendingIntent.FLAG_NO_CREATE or PendingIntent.FLAG_IMMUTABLE)
        pi?.let { (context.getSystemService(Context.ALARM_SERVICE) as AlarmManager).cancel(it) }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NotasScreen(navController: NavController, vm: NotasViewModel = hiltViewModel()) {
    val notas by vm.notas.collectAsState()
    val context = LocalContext.current
    var mostrarForm by remember { mutableStateOf(false) }
    var notaEditar by remember { mutableStateOf<Nota?>(null) }

    val conRecordatorio = notas.filter { it.recordatorioFecha != null }
    val sinRecordatorio = notas.filter { it.recordatorioFecha == null }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Notas y recordatorios") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = AzulOscuro, titleContentColor = Color.White))
        },
        bottomBar = { BottomNavBar(navController) },
        floatingActionButton = {
            FloatingActionButton(onClick = { vm.resetForm(); notaEditar = null; mostrarForm = true }, containerColor = AzulPrimario) {
                Icon(Icons.Default.Add, null, tint = Color.White)
            }
        },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        if (notas.isEmpty()) {
            Box(Modifier.fillMaxSize().padding(padding), contentAlignment = Alignment.Center) {
                Column(horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(Icons.Default.Note, null, modifier = Modifier.size(56.dp), tint = MaterialTheme.colorScheme.onSurfaceVariant)
                    Text("Sin notas todavía", style = MaterialTheme.typography.titleMedium)
                    Text("Pulsa + para crear una nota", style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
                }
            }
        } else {
            LazyColumn(Modifier.fillMaxSize().padding(padding).padding(12.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                if (conRecordatorio.isNotEmpty()) {
                    item {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp), modifier = Modifier.padding(vertical = 4.dp)) {
                            Icon(Icons.Default.Alarm, null, tint = NaranjaPrimario, modifier = Modifier.size(14.dp))
                            Text("Con recordatorio", style = MaterialTheme.typography.labelMedium, color = NaranjaPrimario)
                        }
                    }
                    items(conRecordatorio) { nota ->
                        NotaCard(nota,
                            onEditar = { vm.cargar(nota); notaEditar = nota; mostrarForm = true },
                            onEliminar = { vm.eliminar(context, nota) {} })
                    }
                }
                if (sinRecordatorio.isNotEmpty()) {
                    item {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp), modifier = Modifier.padding(vertical = 4.dp)) {
                            Icon(Icons.Default.Note, null, tint = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(14.dp))
                            Text("Notas", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                        }
                    }
                    items(sinRecordatorio) { nota ->
                        NotaCard(nota,
                            onEditar = { vm.cargar(nota); notaEditar = nota; mostrarForm = true },
                            onEliminar = { vm.eliminar(context, nota) {} })
                    }
                }
            }
        }
    }

    if (mostrarForm) {
        NotaFormSheet(vm = vm, context = context, editId = notaEditar?.id, onDismiss = { mostrarForm = false; notaEditar = null })
    }
}

@Composable
private fun NotaCard(nota: Nota, onEditar: () -> Unit, onEliminar: () -> Unit) {
    val tieneRecordatorio = nota.recordatorioFecha != null
    Card(shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface),
        elevation = CardDefaults.cardElevation(0.dp),
        modifier = Modifier.fillMaxWidth().clickable(onClick = onEditar)) {
        Column(Modifier.padding(14.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.Top) {
                Text(nota.titulo, style = MaterialTheme.typography.labelLarge, modifier = Modifier.weight(1f))
                Row {
                    IconButton(onClick = onEliminar, modifier = Modifier.size(28.dp)) {
                        Icon(Icons.Default.Delete, null, tint = RojoPrimario, modifier = Modifier.size(16.dp))
                    }
                }
            }
            if (nota.contenido.isNotEmpty()) {
                Text(nota.contenido, style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 3)
            }
            if (tieneRecordatorio) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                    Box(Modifier.clip(RoundedCornerShape(6.dp)).background(NaranjaLight).padding(horizontal = 8.dp, vertical = 3.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(4.dp)) {
                            Icon(Icons.Default.Alarm, null, tint = NaranjaPrimario, modifier = Modifier.size(11.dp))
                            Text("${nota.recordatorioFecha!!.toFechaCorta()} ${nota.recordatorioHora}",
                                style = MaterialTheme.typography.labelSmall, color = NaranjaPrimario)
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NotaFormSheet(vm: NotasViewModel, context: Context, editId: Long?, onDismiss: () -> Unit) {
    var mostrarCalendario by remember { mutableStateOf(false) }
    val sdf = SimpleDateFormat("dd/MM/yyyy", Locale("es"))

    ModalBottomSheet(onDismissRequest = onDismiss, containerColor = MaterialTheme.colorScheme.surface) {
        Column(Modifier.fillMaxWidth().verticalScroll(rememberScrollState()).padding(16.dp).padding(bottom = 32.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)) {

            Text(if (editId != null) "Editar nota" else "Nueva nota", style = MaterialTheme.typography.titleMedium)

            OutlinedTextField(vm.titulo, { vm.titulo = it }, label = { Text("Título *") }, modifier = Modifier.fillMaxWidth())

            OutlinedTextField(vm.contenido, { vm.contenido = it }, label = { Text("Contenido") },
                modifier = Modifier.fillMaxWidth(), maxLines = 5, singleLine = false,
                minLines = 3)

            HorizontalDivider()

            Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    Icon(Icons.Default.Alarm, null, tint = if (vm.conRecordatorio) NaranjaPrimario else MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.size(18.dp))
                    Text("Recordatorio", style = MaterialTheme.typography.bodyMedium)
                }
                Switch(vm.conRecordatorio, { vm.conRecordatorio = it },
                    colors = SwitchDefaults.colors(checkedThumbColor = NaranjaPrimario, checkedTrackColor = NaranjaLight))
            }

            if (vm.conRecordatorio) {
                OutlinedButton(onClick = { mostrarCalendario = true }, modifier = Modifier.fillMaxWidth()) {
                    Icon(Icons.Default.CalendarMonth, null)
                    Spacer(Modifier.width(8.dp))
                    Text(vm.recordatorioFecha?.let { sdf.format(Date(it)) } ?: "Seleccionar fecha")
                }
                OutlinedTextField(vm.recordatorioHora, { vm.recordatorioHora = it },
                    label = { Text("Hora (ej: 09:00)") }, modifier = Modifier.fillMaxWidth(),
                    leadingIcon = { Icon(Icons.Default.Schedule, null) })
                if (vm.recordatorioFecha != null) {
                    Box(Modifier.clip(RoundedCornerShape(8.dp)).background(NaranjaLight).padding(10.dp).fillMaxWidth()) {
                        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
                            Icon(Icons.Default.NotificationsActive, null, tint = NaranjaPrimario, modifier = Modifier.size(16.dp))
                            Text("Te avisaremos el ${sdf.format(Date(vm.recordatorioFecha!!))} a las ${vm.recordatorioHora}",
                                style = MaterialTheme.typography.bodySmall, color = NaranjaPrimario)
                        }
                    }
                }
            }

            Button(onClick = { vm.guardar(context, editId) { onDismiss() } },
                modifier = Modifier.fillMaxWidth().height(52.dp),
                enabled = vm.titulo.isNotBlank() && (!vm.conRecordatorio || vm.recordatorioFecha != null)) {
                Icon(Icons.Default.Save, null); Spacer(Modifier.width(8.dp))
                Text("Guardar nota")
            }
        }
    }

    if (mostrarCalendario) {
        val datePickerState = rememberDatePickerState(initialSelectedDateMillis = vm.recordatorioFecha ?: System.currentTimeMillis())
        DatePickerDialog(
            onDismissRequest = { mostrarCalendario = false },
            confirmButton = {
                TextButton(onClick = { vm.recordatorioFecha = datePickerState.selectedDateMillis; mostrarCalendario = false }) {
                    Text("Aceptar")
                }
            },
            dismissButton = { TextButton(onClick = { mostrarCalendario = false }) { Text("Cancelar") } }
        ) {
            DatePicker(state = datePickerState)
        }
    }
}
