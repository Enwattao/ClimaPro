package com.climapro.app.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.climapro.app.ui.screens.ajustes.AjustesScreen
import com.climapro.app.ui.screens.averias.AveriasScreen
import com.climapro.app.ui.screens.calendario.CalendarioScreen
import com.climapro.app.ui.screens.gastos.GastosScreen
import com.climapro.app.ui.screens.notas.NotasScreen
import com.climapro.app.ui.screens.home.HomeScreen
import com.climapro.app.ui.screens.mantenimientos.*
import com.climapro.app.ui.screens.montajes.*

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Calendario : Screen("calendario")
    object Montajes : Screen("montajes")
    object MontajeDetalle : Screen("montaje/{id}") {
        fun create(id: Long) = "montaje/$id"
    }
    object MontajeForm : Screen("montaje_form?id={id}") {
        fun create(id: Long? = null) = if (id != null) "montaje_form?id=$id" else "montaje_form?id=-1"
    }
    object Mantenimientos : Screen("mantenimientos")
    object MantenimientoDetalle : Screen("mantenimiento/{id}") {
        fun create(id: Long) = "mantenimiento/$id"
    }
    object MantenimientoForm : Screen("mantenimiento_form?id={id}") {
        fun create(id: Long? = null) = if (id != null) "mantenimiento_form?id=$id" else "mantenimiento_form?id=-1"
    }
    object Averias : Screen("averias")
    object Gastos : Screen("gastos")
    object Notas : Screen("notas")
    object Ajustes : Screen("ajustes")
}

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(navController = navController, startDestination = Screen.Home.route) {
        composable(Screen.Home.route) { HomeScreen(navController) }
        composable(Screen.Calendario.route) { CalendarioScreen(navController) }
        composable(Screen.Montajes.route) { MontajesScreen(navController) }
        composable(
            route = Screen.MontajeDetalle.route,
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) { MontajeDetalleScreen(navController, it.arguments?.getLong("id") ?: 0) }
        composable(
            route = Screen.MontajeForm.route,
            arguments = listOf(navArgument("id") { type = NavType.LongType; defaultValue = -1L })
        ) { MontajeFormScreen(navController, it.arguments?.getLong("id")?.takeIf { v -> v != -1L }) }
        composable(Screen.Mantenimientos.route) { MantenimientosScreen(navController) }
        composable(
            route = Screen.MantenimientoDetalle.route,
            arguments = listOf(navArgument("id") { type = NavType.LongType })
        ) { MantenimientoDetalleScreen(navController, it.arguments?.getLong("id") ?: 0) }
        composable(
            route = Screen.MantenimientoForm.route,
            arguments = listOf(navArgument("id") { type = NavType.LongType; defaultValue = -1L })
        ) { MantenimientoFormScreen(navController, it.arguments?.getLong("id")?.takeIf { v -> v != -1L }) }
        composable(Screen.Averias.route) { AveriasScreen(navController) }
        composable(Screen.Gastos.route) { GastosScreen(navController) }
        composable(Screen.Notas.route) { NotasScreen(navController) }
        composable(Screen.Ajustes.route) { AjustesScreen(navController) }
    }
}
