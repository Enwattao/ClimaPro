package com.climapro.app.ui.screens.ajustes

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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.climapro.app.data.preferences.AppPreferences
import com.climapro.app.ui.components.BottomNavBar
import com.climapro.app.ui.theme.AzulPrimario
import com.climapro.app.util.UpdateChecker
import com.climapro.app.util.UpdateInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AjustesViewModel @Inject constructor(
    private val prefs: AppPreferences,
    private val updateChecker: UpdateChecker
) : ViewModel() {
    val empresaNombre = prefs.empresaNombre.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "")
    val empresaTelefono = prefs.empresaTelefono.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "")
    val empresaDireccion = prefs.empresaDireccion.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), "")
    val notif24h = prefs.notif24h.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), true)
    val notif1h = prefs.notif1h.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), true)
    val notifDia = prefs.notifDia.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), true)
    val notifCobros = prefs.notifCobros.stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), true)

    var updateInfo by mutableStateOf<UpdateInfo?>(null)
    var checkingUpdate by mutableStateOf(false)

    fun save(nombre: String, tel: String, dir: String) = viewModelScope.launch {
        prefs.setEmpresaNombre(nombre); prefs.setEmpresaTelefono(tel); prefs.setEmpresaDireccion(dir)
    }
    fun setNotif24h(v: Boolean) = viewModelScope.launch { prefs.setNotif24h(v) }
    fun setNotif1h(v: Boolean) = viewModelScope.launch { prefs.setNotif1h(v) }
    fun setNotifDia(v: Boolean) = viewModelScope.launch { prefs.setNotifDia(v) }
    fun setNotifCobros(v: Boolean) = viewModelScope.launch { prefs.setNotifCobros(v) }

    fun checkUpdate() = viewModelScope.launch {
        checkingUpdate = true
        updateInfo = updateChecker.check()
        checkingUpdate = false
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AjustesScreen(navController: NavController, vm: AjustesViewModel = hiltViewModel()) {
    val empresaNombre by vm.empresaNombre.collectAsState()
    val empresaTelefono by vm.empresaTelefono.collectAsState()
    val empresaDireccion by vm.empresaDireccion.collectAsState()
    val notif24h by vm.notif24h.collectAsState()
    val notif1h by vm.notif1h.collectAsState()
    val notifDia by vm.notifDia.collectAsState()
    val notifCobros by vm.notifCobros.collectAsState()

    var editNombre by remember(empresaNombre) { mutableStateOf(empresaNombre) }
    var editTel by remember(empresaTelefono) { mutableStateOf(empresaTelefono) }
    var editDir by remember(empresaDireccion) { mutableStateOf(empresaDireccion) }

    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Ajustes") },
                navigationIcon = { IconButton(onClick = { navController.popBackStack() }) { Icon(Icons.Default.ArrowBack, null) } },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = MaterialTheme.colorScheme.surface))
        },
        bottomBar = { BottomNavBar(navController) },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        Column(Modifier.fillMaxSize().padding(padding).verticalScroll(rememberScrollState()).padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {

            SettingsSection("Datos de la empresa", Icons.Default.Business) {
                OutlinedTextField(value = editNombre, onValueChange = { editNombre = it }, label = { Text("Nombre empresa") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = editTel, onValueChange = { editTel = it }, label = { Text("Teléfono") }, modifier = Modifier.fillMaxWidth())
                OutlinedTextField(value = editDir, onValueChange = { editDir = it }, label = { Text("Dirección") }, modifier = Modifier.fillMaxWidth())
                Button(onClick = { vm.save(editNombre, editTel, editDir) }, modifier = Modifier.fillMaxWidth()) { Text("Guardar datos empresa") }
            }

            SettingsSection("Notificaciones", Icons.Default.Notifications) {
                SwitchRow("24 horas antes", notif24h) { vm.setNotif24h(it) }
                SwitchRow("1 hora antes", notif1h) { vm.setNotif1h(it) }
                SwitchRow("El día del trabajo", notifDia) { vm.setNotifDia(it) }
                SwitchRow("Cobros pendientes", notifCobros) { vm.setNotifCobros(it) }
            }

            SettingsSection("Copia de seguridad", Icons.Default.Backup) {
                SettingsButton(Icons.Default.Upload, "Exportar base de datos") { }
                SettingsButton(Icons.Default.Download, "Importar base de datos") { }
                SettingsButton(Icons.Default.SaveAlt, "Copia de seguridad completa") { }
                SettingsButton(Icons.Default.Restore, "Restaurar copia") { }
            }

            SettingsSection("Actualización", Icons.Default.SystemUpdate) {
                if (vm.updateInfo != null) {
                    val info = vm.updateInfo!!
                    Card(colors = CardDefaults.cardColors(containerColor = if (info.hayActualizacion) MaterialTheme.colorScheme.primaryContainer else MaterialTheme.colorScheme.surfaceVariant)) {
                        Column(Modifier.padding(12.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
                            Text(if (info.hayActualizacion) "Nueva versión: ${info.version}" else "App actualizada", style = MaterialTheme.typography.labelLarge)
                            if (info.hayActualizacion) {
                                Text(info.changelog, style = MaterialTheme.typography.bodySmall)
                                Button(onClick = {}, modifier = Modifier.fillMaxWidth()) { Text("Descargar e instalar") }
                            }
                        }
                    }
                }
                SettingsButton(Icons.Default.Refresh, if (vm.checkingUpdate) "Comprobando..." else "Comprobar actualizaciones") {
                    if (!vm.checkingUpdate) vm.checkUpdate()
                }
            }

            Text("ClimaPro v1.0.0", style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant, modifier = Modifier.align(Alignment.CenterHorizontally))
        }
    }
}

@Composable
private fun SettingsSection(title: String, icon: ImageVector, content: @Composable ColumnScope.() -> Unit) {
    Card(shape = RoundedCornerShape(16.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(0.dp)) {
        Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(10.dp)) {
            Row(horizontalArrangement = Arrangement.spacedBy(8.dp), verticalAlignment = Alignment.CenterVertically) {
                Icon(icon, null, tint = AzulPrimario, modifier = Modifier.size(16.dp))
                Text(title, style = MaterialTheme.typography.labelLarge, color = AzulPrimario)
            }
            content()
        }
    }
}

@Composable
private fun SwitchRow(label: String, checked: Boolean, onToggle: (Boolean) -> Unit) {
    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
        Text(label, style = MaterialTheme.typography.bodyMedium)
        Switch(checked = checked, onCheckedChange = onToggle)
    }
}

@Composable
private fun SettingsButton(icon: ImageVector, label: String, onClick: () -> Unit) {
    OutlinedButton(onClick = onClick, modifier = Modifier.fillMaxWidth()) {
        Icon(icon, null, modifier = Modifier.size(16.dp))
        Spacer(Modifier.width(8.dp))
        Text(label)
    }
}
