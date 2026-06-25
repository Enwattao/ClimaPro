package com.climapro.app.ui.screens.home

import androidx.compose.animation.core.*
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.climapro.app.data.db.entity.Averia
import com.climapro.app.data.db.entity.Montaje
import com.climapro.app.ui.components.BottomNavBar
import com.climapro.app.ui.navigation.Screen
import com.climapro.app.ui.theme.*
import com.climapro.app.util.toEuros
import com.climapro.app.util.toFechaCorta
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun HomeScreen(navController: NavController, vm: HomeViewModel = hiltViewModel()) {
    val state by vm.state.collectAsState()
    val sdf = SimpleDateFormat("EEEE, dd 'de' MMMM", Locale("es"))
    val fechaHoy = sdf.format(Date()).replaceFirstChar { it.uppercase() }

    Scaffold(
        bottomBar = { BottomNavBar(navController, state.listaEsperaBadge, state.averiasActivasBadge) },
        containerColor = MaterialTheme.colorScheme.background
    ) { padding ->
        LazyColumn(modifier = Modifier.fillMaxSize().padding(padding)) {
            item {
                Box(Modifier.fillMaxWidth().background(AzulOscuro).padding(horizontal = 20.dp, vertical = 24.dp)) {
                    Column {
                        Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically) {
                            Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                                Box(Modifier.size(36.dp).clip(RoundedCornerShape(10.dp)).background(Color.White.copy(alpha = 0.12f)), contentAlignment = Alignment.Center) {
                                    Icon(Icons.Default.AcUnit, null, tint = Color(0xFF8FA8FF), modifier = Modifier.size(20.dp))
                                }
                                Column {
                                    Text("ClimaPro", style = MaterialTheme.typography.titleMedium, color = Color.White)
                                    Text("Gestión profesional", style = MaterialTheme.typography.labelSmall, color = Color.White.copy(.5f))
                                }
                            }
                            Row {
                                // Campanita animada de avisos
                                val hayAvisos = state.avisosCount > 0
                                val infiniteTransition = rememberInfiniteTransition(label = "bell")
                                val angle by infiniteTransition.animateFloat(
                                    initialValue = if (hayAvisos) -18f else 0f,
                                    targetValue = if (hayAvisos) 18f else 0f,
                                    animationSpec = infiniteRepeatable(
                                        animation = tween(350, easing = LinearEasing),
                                        repeatMode = RepeatMode.Reverse
                                    ),
                                    label = "bellAngle"
                                )
                                BadgedBox(
                                    badge = {
                                        if (hayAvisos) Badge(containerColor = NaranjaPrimario) {
                                            Text("${state.avisosCount}", color = Color.White, style = MaterialTheme.typography.labelSmall)
                                        }
                                    },
                                    modifier = Modifier.padding(4.dp)
                                ) {
                                    IconButton(onClick = { navController.navigate(Screen.Avisos.route) }) {
                                        Icon(
                                            Icons.Default.Notifications, null,
                                            tint = Color.White.copy(.9f),
                                            modifier = Modifier.graphicsLayer { rotationZ = if (hayAvisos) angle else 0f }
                                        )
                                    }
                                }
                                IconButton(onClick = { navController.navigate(Screen.Ajustes.route) }) {
                                    Icon(Icons.Default.Settings, null, tint = Color.White.copy(.7f))
                                }
                            }
                        }
                        Spacer(Modifier.height(16.dp))
                        Text("Buenos días", style = MaterialTheme.typography.bodySmall, color = Color.White.copy(.6f))
                        Text(fechaHoy, style = MaterialTheme.typography.titleLarge, color = Color.White)
                        Spacer(Modifier.height(12.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            StatPill(AzulPrimario, "${state.montajesMes} montajes")
                            StatPill(Color(0xFFFF6B6B), "${state.averiasActivas} averías activas")
                        }
                    }
                }
            }

            item {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
                    // KPIs
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        KpiCard(Modifier.weight(1f), Icons.Default.Build, AzulLight, AzulPrimario,
                            "${state.montajesMes}", "Montajes mes", AzulPrimario)
                        KpiCard(Modifier.weight(1f), Icons.Default.Warning, Color(0xFFFFEEEE), Color(0xFFFF6B6B),
                            "${state.averiasActivas}", "Averías activas", Color(0xFFFF6B6B))
                    }
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        KpiCard(Modifier.weight(1f), Icons.Default.EuroSymbol, VerdeLight, VerdePrimario,
                            state.totalCobradoMes.toEuros(), "Ingresos mes", VerdePrimario)
                        KpiCard(Modifier.weight(1f), Icons.Default.TrendingDown, Color(0xFFFFEEEE), RojoPrimario,
                            state.gastosMes.toEuros(), "Gastos mes", RojoPrimario)
                    }

                    // Próximos montajes
                    if (state.proximosMontajes.isNotEmpty()) {
                        SectionHeader("Próximos montajes", Icons.Default.Build, AzulPrimario)
                        state.proximosMontajes.forEach { m ->
                            ProximoMontajeCard(m) { navController.navigate(Screen.MontajeDetalle.create(m.id)) }
                        }
                    }

                    // Próximas averías
                    if (state.proximasAverias.isNotEmpty()) {
                        SectionHeader("Averías pendientes", Icons.Default.Warning, Color(0xFFFF6B6B))
                        state.proximasAverias.forEach { a ->
                            ProximaAveriaCard(a) { navController.navigate(Screen.Averias.route) }
                        }
                    }

                    // Acciones rápidas
                    SectionHeader("Acciones rápidas", Icons.Default.FlashOn, AzulPrimario)
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        QuickActionCard(Modifier.weight(1f), Icons.Default.Add, AzulLight, AzulPrimario,
                            "Nuevo Montaje") { navController.navigate(Screen.MontajeForm.create()) }
                        QuickActionCard(Modifier.weight(1f), Icons.Default.Warning, Color(0xFFFFEEEE), Color(0xFFFF6B6B),
                            "Nueva Avería") { navController.navigate(Screen.Averias.route) }
                    }
                    Row(Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(10.dp)) {
                        QuickActionCard(Modifier.weight(1f), Icons.Default.Build, VerdeLight, VerdePrimario,
                            "Mantenimiento") { navController.navigate(Screen.Mantenimientos.route) }
                        QuickActionCard(Modifier.weight(1f), Icons.Default.Receipt, NaranjaLight, NaranjaPrimario,
                            "Nuevo Gasto") { navController.navigate(Screen.Gastos.route) }
                    }
                }
            }
        }
    }
}

@Composable
private fun SectionHeader(title: String, icon: ImageVector, color: Color) {
    Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(6.dp)) {
        Icon(icon, null, tint = color, modifier = Modifier.size(16.dp))
        Text(title, style = MaterialTheme.typography.titleMedium, color = MaterialTheme.colorScheme.onBackground)
    }
}

@Composable
private fun StatPill(color: Color, text: String) {
    Box(Modifier.clip(RoundedCornerShape(20.dp)).background(Color.White.copy(.1f)).padding(horizontal = 10.dp, vertical = 4.dp)) {
        Row(verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.spacedBy(5.dp)) {
            Box(Modifier.size(6.dp).clip(CircleShape).background(color))
            Text(text, style = MaterialTheme.typography.labelSmall, color = Color.White)
        }
    }
}

@Composable
private fun KpiCard(modifier: Modifier, icon: ImageVector, bgIcon: Color, iconColor: Color,
                    value: String, label: String, valueColor: Color = MaterialTheme.colorScheme.onSurface) {
    Card(modifier, shape = RoundedCornerShape(14.dp), colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(0.dp)) {
        Column(Modifier.padding(14.dp)) {
            Box(Modifier.size(30.dp).clip(RoundedCornerShape(8.dp)).background(bgIcon), contentAlignment = Alignment.Center) {
                Icon(icon, null, tint = iconColor, modifier = Modifier.size(16.dp))
            }
            Spacer(Modifier.height(6.dp))
            Text(value, style = MaterialTheme.typography.headlineSmall.copy(fontSize = androidx.compose.ui.unit.TextUnit(18f, androidx.compose.ui.unit.TextUnitType.Sp)), color = valueColor)
            Text(label, style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant)
        }
    }
}

@Composable
private fun ProximoMontajeCard(montaje: Montaje, onClick: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().clickable(onClick = onClick), shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(0.dp)) {
        Row(Modifier.fillMaxWidth().padding(12.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Box(Modifier.width(4.dp).height(48.dp).clip(RoundedCornerShape(4.dp)).background(AzulPrimario))
            Column(Modifier.weight(1f)) {
                Text(montaje.nombreCliente, style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.onSurface)
                Text(montaje.marcaMaquina.ifEmpty { montaje.tipoMaquina.name } + " · " + montaje.direccion,
                    style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 1)
            }
            Column(horizontalAlignment = Alignment.End) {
                Text(montaje.hora, style = MaterialTheme.typography.labelLarge, color = AzulPrimario)
                montaje.fecha?.let { Text(it.toFechaCorta(), style = MaterialTheme.typography.labelSmall, color = MaterialTheme.colorScheme.onSurfaceVariant) }
            }
        }
    }
}

@Composable
private fun ProximaAveriaCard(averia: Averia, onClick: () -> Unit) {
    Card(modifier = Modifier.fillMaxWidth().clickable(onClick = onClick), shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(0.dp)) {
        Row(Modifier.fillMaxWidth().padding(12.dp), horizontalArrangement = Arrangement.spacedBy(12.dp)) {
            Box(Modifier.width(4.dp).height(48.dp).clip(RoundedCornerShape(4.dp)).background(Color(0xFFFF6B6B)))
            Column(Modifier.weight(1f)) {
                Text(averia.nombreCliente, style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.onSurface)
                Text(averia.descripcion.ifEmpty { averia.marcaMaquina }.take(40), style = MaterialTheme.typography.bodySmall, color = MaterialTheme.colorScheme.onSurfaceVariant, maxLines = 1)
            }
            if (averia.urgente) {
                Box(Modifier.clip(RoundedCornerShape(6.dp)).background(Color(0xFFFFEEEE)).padding(horizontal = 6.dp, vertical = 2.dp)) {
                    Text("Urgente", style = MaterialTheme.typography.labelSmall, color = Color(0xFFFF6B6B))
                }
            }
        }
    }
}

@Composable
private fun QuickActionCard(modifier: Modifier, icon: ImageVector, bgIcon: Color, iconColor: Color,
                             label: String, onClick: () -> Unit) {
    Card(modifier = modifier.clickable(onClick = onClick), shape = RoundedCornerShape(14.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface), elevation = CardDefaults.cardElevation(0.dp)) {
        Row(Modifier.padding(14.dp), horizontalArrangement = Arrangement.spacedBy(10.dp), verticalAlignment = Alignment.CenterVertically) {
            Box(Modifier.size(36.dp).clip(RoundedCornerShape(10.dp)).background(bgIcon), contentAlignment = Alignment.Center) {
                Icon(icon, null, tint = iconColor, modifier = Modifier.size(18.dp))
            }
            Text(label, style = MaterialTheme.typography.labelLarge, color = MaterialTheme.colorScheme.onSurface)
        }
    }
}
