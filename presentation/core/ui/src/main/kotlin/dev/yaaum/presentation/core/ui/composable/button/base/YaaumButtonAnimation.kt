package dev.yaaum.presentation.core.ui.composable.button.base

import androidx.compose.animation.core.Easing
import androidx.compose.runtime.Immutable

/**
 * Specify click animation
 */
@Immutable
interface YaaumButtonAnimation {
    val duration: Int
    val easing: Easing
}
