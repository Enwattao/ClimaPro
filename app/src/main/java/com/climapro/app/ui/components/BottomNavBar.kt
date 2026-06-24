package com.climapro.app.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.climapro.app.ui.navigation.Screen

data class NavItem(val label: String, val icon: androidx.compose.ui.graphics.vector.ImageVector, val route: String, val badge: Int = 0)

@Composable
fun BottomNavBar(navController: NavController, listaEsperaBadge: Int = 0) {
    val items = listOf(
        NavItem("Inicio", Icons.Default.Home, Screen.Home.route),
        NavItem("Calendario", Icons.Default.CalendarMonth, Screen.Calendario.route),
        NavItem("Montajes", Icons.Default.Build, Screen.Montajes.route, listaEsperaBadge),
        NavItem("Mant.", Icons.Default.Settings, Screen.Mantenimientos.route),
        NavItem("Consultas", Icons.Default.BarChart, Screen.Consultas.route),
        NavItem("Ajustes", Icons.Default.Tune, Screen.Ajustes.route),
    )
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    NavigationBar(containerColor = MaterialTheme.colorScheme.surface, tonalElevation = 0.dp) {
        items.forEach { item ->
            NavigationBarItem(
                selected = currentRoute == item.route,
                onClick = {
                    if (currentRoute != item.route) {
                        navController.navigate(item.route) {
                            popUpTo(Screen.Home.route) { saveState = true }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                },
                icon = {
                    if (item.badge > 0) {
                        BadgedBox(badge = { Badge { Text("${item.badge}") } }) {
                            Icon(item.icon, contentDescription = item.label)
                        }
                    } else {
                        Icon(item.icon, contentDescription = item.label)
                    }
                },
                label = { Text(item.label, style = MaterialTheme.typography.labelSmall) },
                colors = NavigationBarItemDefaults.colors(
                    selectedIconColor = MaterialTheme.colorScheme.primary,
                    selectedTextColor = MaterialTheme.colorScheme.primary,
                    indicatorColor = MaterialTheme.colorScheme.primaryContainer,
                    unselectedIconColor = MaterialTheme.colorScheme.onSurfaceVariant,
                    unselectedTextColor = MaterialTheme.colorScheme.onSurfaceVariant,
                )
            )
        }
    }
}

private val Int.dp get() = androidx.compose.ui.unit.Dp(this.toFloat())
