package com.climapro.app.ui.screens.montajes

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.climapro.app.data.db.entity.Montaje
import com.climapro.app.ui.theme.*
import com.climapro.app.util.*
import java.util.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AsignarCitaSheet(
    montaje: Montaje,
    onDismiss: () -> Unit,
    onConfirm: (fecha: Long, hora: String, horasEstimadas: Float) -> Unit
) {
    val cal = remember { Calendar.getInstance().apply { add(Calendar.DAY_OF_MONTH, 1) } }
    var selectedYear by remember { mutableIntStateOf(cal.get(Calendar.YEAR)) }
    var selectedMonth by remember { mutableIntStateOf(cal.get(Calendar.MONTH)) }
    var selectedDay by remember { mutableIntStateOf(cal.get(Calendar.DAY_OF_MONTH)) }
    var hora by remember { mutableStateOf("09:00") }
    var horasEst by remember { mutableFloatStateOf(montaje.horasEstimadas.takeIf { it > 0 } ?: 3f) }
    var nota by remember { mutableStateOf("") }

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    ModalBottomSheet(onDismissRequest = onDismiss, sheetState = sheetState, containerColor = MaterialTheme.colorScheme.surface) {
        Column {
            // Cliente strip
            Row(
                Modifier.fillMaxWidth().background(MaterialTheme.colorScheme.surfaceVariant)
                    .padding(horizontal = 18.dp, vertical = 12.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Box(Modifier.size(36.dp).clip(CircleShape).background(AzulLight), contentAlignment = Alignment.Center) {
                    Text(iniciales(montaje.nombreCliente), style = MaterialTheme.typography.labelMedium, color = AzulPrimario)
                }
                Column(Modifier.weight(1f)) {
                    Text(montaje.nombreCliente, style = MaterialTheme.typography.labelLarge)
                    Text(montaje.marcaMaquina + " " + montaje.tipoMaquina.label() + " · " + montaje.direccion.take(28),
                        style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 1)
                }
                Box(Modifier.clip(RoundedCornerShape(8.dp)).background(NaranjaLight).padding(horizontal = 8.dp, vertical = 3.dp)) {
                    Text("En espera", style = MaterialTheme.typography.labelSmall, color = NaranjaPrimario)
                }
            }

            Column(Modifier.padding(18.dp), verticalArrangement = Arrangement.spacedBy(16.dp)) {
                // Mini calendario
                Text("Selecciona el día", style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.onSurfaceVariant)
                MiniCalendar(
                    year = selectedYear, month = selectedMonth, selectedDay = selectedDay,
                    onPrev = {
                        val c = Calendar.getInstance().apply { set(selectedYear, selectedMonth, 1); add(Calendar.MONTH, -1) }
                        selectedYear = c.get(Calendar.YEAR); selectedMonth = c.get(Calendar.MONTH)
                    },
                    onNext = {
                        val c = Calendar.getInstance().apply { set(selectedYear, selectedMonth, 1); add(Calendar.MONTH, 1) }
                        selectedYear = c.get(Calendar.YEAR); selectedMonth = c.get(Calendar.MONTH)
                    },
                    onDaySelect = { selectedDay = it }
                )

                // Hora y duración
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    OutlinedTextField(
                        value = hora, onValueChange = { hora = it },
                        label = { Text("Hora inicio") },
                        leadingIcon = { Icon(Icons.Default.AccessTime, null) },
                        modifier = Modifier.weight(1f), singleLine = true
                    )
                    OutlinedTextField(
                        value = "${horasEst.toInt()} h", onValueChange = {},
                        label = { Text("Duración") },
                        readOnly = true,
                        modifier = Modifier.weight(1f), singleLine = true,
                        colors = OutlinedTextFieldDefaults.colors(focusedBorderColor = AzulPrimario,
                            focusedTextColor = AzulPrimario, unfocusedTextColor = AzulPrimario)
                    )
                }

                // Chips de duración rápida
                Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                    listOf(1f, 2f, 3f, 4f, 6f, 8f).forEach { h ->
                        FilterChip(
                            selected = horasEst == h,
                            onClick = { horasEst = h },
                            label = { Text(if (h == 8f) "Todo el día" else "${h.toInt()}h") }
                        )
                    }
                }

                // Nota opcional
                OutlinedTextField(
                    value = nota, onValueChange = { nota = it },
                    label = { Text("Nota para este día (opcional)") },
                    leadingIcon = { Icon(Icons.Default.Notes, null) },
                    modifier = Modifier.fillMaxWidth(), maxLines = 2
                )

                // Botones
                Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                    OutlinedButton(onClick = onDismiss, modifier = Modifier.weight(1f)) {
                        Text("Cancelar")
                    }
                    val fechaSeleccionada = Calendar.getInstance().apply {
                        set(selectedYear, selectedMonth, selectedDay, 0, 0, 0)
                        set(Calendar.MILLISECOND, 0)
                    }.timeInMillis
                    val mesLabel = SimpleDateFormat("dd MMM", Locale("es")).format(Date(fechaSeleccionada))
                    Button(
                        onClick = { onConfirm(fechaSeleccionada, hora, horasEst) },
                        modifier = Modifier.weight(2f),
                        colors = ButtonDefaults.buttonColors(containerColor = AzulPrimario)
                    ) {
                        Icon(Icons.Default.CalendarMonth, null, modifier = Modifier.size(16.dp))
                        Spacer(Modifier.width(4.dp))
                        Text("Confirmar · $mesLabel")
                    }
                }
                Spacer(Modifier.height(8.dp))
            }
        }
    }
}

@Composable
private fun MiniCalendar(
    year: Int, month: Int, selectedDay: Int,
    onPrev: () -> Unit, onNext: () -> Unit, onDaySelect: (Int) -> Unit
) {
    val monthNames = listOf("Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto","Septiembre","Octubre","Noviembre","Diciembre")
    val cal = Calendar.getInstance().apply { set(year, month, 1) }
    val firstDow = (cal.get(Calendar.DAY_OF_WEEK) - 2).let { if (it < 0) 6 else it }
    val daysInMonth = cal.getActualMaximum(Calendar.DAY_OF_MONTH)
    val today = Calendar.getInstance()

    Column {
        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
            IconButton(onClick = onPrev, modifier = Modifier.size(32.dp)) {
                Icon(Icons.Default.ChevronLeft, null, tint = MaterialTheme.colorScheme.onSurfaceVariant)
            }
            Text("${monthNames[month]} $year", style = MaterialTheme.typography.labelLarge)
            IconButton(onClick = onNext, modifier = Modifier.size(32.dp)) {
                Icon(Icons.Default.ChevronRight, null, tint = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
        Spacer(Modifier.height(4.dp))
        val dayNames = listOf("L","M","X","J","V","S","D")
        Row(Modifier.fillMaxWidth()) {
            dayNames.forEach { d ->
                Text(d, Modifier.weight(1f), textAlign = TextAlign.Center,
                    style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
            }
        }
        Spacer(Modifier.height(4.dp))
        val cells = firstDow + daysInMonth
        val rows = (cells + 6) / 7
        var day = 1
        repeat(rows) {
            Row(Modifier.fillMaxWidth()) {
                repeat(7) { col ->
                    val cellIndex = it * 7 + col
                    val isValid = cellIndex >= firstDow && day <= daysInMonth
                    val d = if (isValid) day++ else 0
                    val isSelected = isValid && d == selectedDay && (year != today.get(Calendar.YEAR) || month != today.get(Calendar.MONTH) || d != today.get(Calendar.DAY_OF_MONTH))
                    val isToday = isValid && d == today.get(Calendar.DAY_OF_MONTH) && month == today.get(Calendar.MONTH) && year == today.get(Calendar.YEAR)
                    Box(
                        Modifier.weight(1f).aspectRatio(1f)
                            .padding(2.dp)
                            .clip(RoundedCornerShape(8.dp))
                            .background(when { isSelected -> AzulPrimario; isToday -> AzulLight; else -> Color.Transparent })
                            .clickable(enabled = isValid) { if (isValid) onDaySelect(d) },
                        contentAlignment = Alignment.Center
                    ) {
                        if (isValid) {
                            Text("$d", style = MaterialTheme.typography.labelMedium,
                                color = when { isSelected -> Color.White; isToday -> AzulPrimario; else -> MaterialTheme.colorScheme.onSurface })
                        }
                    }
                }
            }
        }
    }
}

private fun SimpleDateFormat(pattern: String, locale: Locale) = java.text.SimpleDateFormat(pattern, locale)
