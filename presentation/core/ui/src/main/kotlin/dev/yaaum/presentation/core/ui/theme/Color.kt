@file:Suppress("MagicNumber")

package dev.yaaum.presentation.core.ui.theme

import androidx.compose.ui.graphics.Color
import dev.yaaum.presentation.core.ui.theme.common.YaaumColors

//region Light colors
val yaaum_theme_light_primary = Color(0xFF01BAEF)
val yaaum_theme_light_onPrimary = Color(0xFFFBFBFF)

val yaaum_theme_light_secondary = Color(0xFFFF8C82)
val yaaum_theme_light_onSecondary = Color(0xFF1C1C1C)

val yaaum_theme_light_background = Color(0xFFFBFBFF)
val yaaum_theme_light_onBackground = Color(0xFF1C1C1C)

val yaaum_theme_light_surface = Color(0xFFEBEBEB)
val yaaum_theme_light_onSurface = Color(0xFF1C1C1C)
//endregion Light colors

//region Dark colors
val yaaum_theme_dark_primary = Color(0xFF01BAEF)
val yaaum_theme_dark_onPrimary = Color(0xFFFBFBFF)

val yaaum_theme_dark_secondary = Color(0xFFFF8C82)
val yaaum_theme_dark_onSecondary = Color(0xFF1C1C1C)

val yaaum_theme_dark_background = Color(0xFF1C1C1C)
val yaaum_theme_dark_onBackground = Color(0xFFFBFBFF)

val yaaum_theme_dark_surface = Color(0xFF8B9DA6)
val yaaum_theme_dark_onSurface = Color(0xFF1C1C1C)
//endregion Dark colors

val baseLightColorPalette = YaaumColors(
    primary = yaaum_theme_light_primary,
    onPrimary = yaaum_theme_light_onPrimary,
    secondary = yaaum_theme_light_secondary,
    onSecondary = yaaum_theme_light_onSecondary,
    background = yaaum_theme_light_background,
    onBackground = yaaum_theme_light_onBackground,
    surface = yaaum_theme_light_surface,
    onSurface = yaaum_theme_light_onSurface,
)

val baseDarkColorPalette = YaaumColors(
    primary = yaaum_theme_dark_primary,
    onPrimary = yaaum_theme_dark_onPrimary,
    secondary = yaaum_theme_dark_secondary,
    onSecondary = yaaum_theme_dark_onSecondary,
    background = yaaum_theme_dark_background,
    onBackground = yaaum_theme_dark_onBackground,
    surface = yaaum_theme_dark_surface,
    onSurface = yaaum_theme_dark_onSurface,
)
