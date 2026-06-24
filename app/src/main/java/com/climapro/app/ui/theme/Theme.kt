package com.climapro.app.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val LightColors = lightColorScheme(
    primary = AzulPrimario,
    onPrimary = Superficie,
    primaryContainer = AzulLight,
    onPrimaryContainer = AzulOscuro,
    secondary = VerdePrimario,
    secondaryContainer = VerdeLight,
    tertiary = NaranjaPrimario,
    tertiaryContainer = NaranjaLight,
    background = Fondo,
    surface = Superficie,
    surfaceVariant = GrisClaro,
    onBackground = AzulOscuro,
    onSurface = AzulOscuro,
    onSurfaceVariant = GrisTexto,
    error = RojoPrimario,
    errorContainer = RojoLight,
    outline = GrisBorde,
)

private val DarkColors = darkColorScheme(
    primary = AzulPrimario,
    onPrimary = Superficie,
    primaryContainer = AzulMedio,
    onPrimaryContainer = AzulLight,
    secondary = VerdePrimario,
    secondaryContainer = Color(0xFF1A3D2B),
    tertiary = NaranjaPrimario,
    tertiaryContainer = Color(0xFF3D2200),
    background = FondoDark,
    surface = SuperficieDark,
    surfaceVariant = SuperficieVariantDark,
    onBackground = Color(0xFFE8EAF0),
    onSurface = Color(0xFFE8EAF0),
    onSurfaceVariant = Color(0xFF9BA4B5),
    error = RojoPrimario,
    errorContainer = Color(0xFF4D1515),
    outline = Color(0xFF3A3F55),
)

@Composable
fun ClimaProTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) DarkColors else LightColors
    MaterialTheme(colorScheme = colors, typography = Typography, content = content)
}
