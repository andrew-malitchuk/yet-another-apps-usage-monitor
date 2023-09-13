package dev.yaaum.presentation.core.ui.theme.common

import androidx.compose.ui.graphics.Color

/**
 * Container for theme color.
 */
data class YaaumColors(
    /**
     * "Accent" or brand color
     */
    val primary: Color,
    /**
     * Typography places on `primary`
     */
    val onPrimary: Color,
    /**
     * Used to accent select parts of your UI.
     */
    val secondary: Color,
    /**
     * Typography places on `secondary`
     */
    val onSecondary: Color,
    /**
     * Background color
     */
    val background: Color,
    /**
     * Typography places on `background`
     */
    val onBackground: Color,
    /**
     * Containers placed on `background`
     */
    val surface: Color,
    /**
     * Typography places on `surface`
     */
    val onSurface: Color,
)
