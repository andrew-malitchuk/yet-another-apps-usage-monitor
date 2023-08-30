@file:Suppress("MagicNumber")

package dev.yaaum.ui.theme

import androidx.compose.ui.graphics.Color
import dev.yaaum.ui.theme.common.YaaumColors

//region Light colors
val yaaum_theme_light_primary = Color(0xFFFFFFFF)
val yaaum_theme_light_onPrimary = Color(0x00000000)
val yaaum_theme_light_secondary = Color(0xFFFFFFFF)
val yaaum_theme_light_onSecondary = Color(0x00000000)
val yaaum_theme_light_background = Color(0xFFFFFFFF)
val yaaum_theme_light_onBackground = Color(0x00000000)
val yaaum_theme_light_surface = Color(0xFFFFFFFF)
val yaaum_theme_light_onSurface = Color(0x00000000)
//endregion Light colors

//region Dark colors
val yaaum_theme_dark_primary = Color(0xFFFFFFFF)
val yaaum_theme_dark_onPrimary = Color(0x00000000)
val yaaum_theme_dark_secondary = Color(0xFFFFFFFF)
val yaaum_theme_dark_onSecondary = Color(0x00000000)
val yaaum_theme_dark_background = Color(0xFFFFFFFF)
val yaaum_theme_dark_onBackground = Color(0x00000000)
val yaaum_theme_dark_surface = Color(0xFFFFFFFF)
val yaaum_theme_dark_onSurface = Color(0x00000000)
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
