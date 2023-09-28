package dev.yaaum.presentation.core.ui.composable.button.base

import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.runtime.State
import androidx.compose.ui.graphics.Color

/**
 * Default colors for button.
 *
 * Contains colors:
 * - border;
 * - foreground;
 * - background.
 */
interface YaaumButtonColors {
    @Stable
    @Composable
    fun borderColor(interactionState: Int, enabled: Boolean): State<Color>

    @Stable
    @Composable
    fun foregroundColor(interactionState: Int, enabled: Boolean): State<Color>

    @Stable
    @Composable
    fun backgroundColor(interactionState: Int, enabled: Boolean): State<Color>
}
