package dev.yaaum.presentation.core.ui.theme.ext

import dev.yaaum.presentation.core.ui.theme.common.YaaumColors

/**
 * Convert Material U Dynamic color scheme to [YaaumColors]
 */
fun androidx.compose.material3.ColorScheme.toYaaumColors(): YaaumColors {
    return YaaumColors(
        primary = this.primary,
        onPrimary = this.onPrimary,
        secondary = this.secondary,
        onSecondary = this.onSecondary,
        background = this.background,
        onBackground = this.onBackground,
        surface = this.secondaryContainer,
        onSurface = this.onSecondaryContainer,
    )
}
