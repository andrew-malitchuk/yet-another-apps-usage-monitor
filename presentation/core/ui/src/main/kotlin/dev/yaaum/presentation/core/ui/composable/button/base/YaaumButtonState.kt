package dev.yaaum.presentation.core.ui.composable.button.base

/**
 * Button states:
 * - hover;
 * - pressed;
 * - focused?.
 */
object YaaumButtonState {
    @JvmStatic
    val HOVER = 1.shl(0)

    @JvmStatic
    val PRESSED = 1.shl(1)

    @JvmStatic
    val FOCUSED = 1.shl(2)
}