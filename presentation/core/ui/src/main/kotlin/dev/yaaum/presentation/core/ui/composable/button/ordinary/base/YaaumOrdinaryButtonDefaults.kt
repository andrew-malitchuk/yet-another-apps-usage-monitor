package dev.yaaum.presentation.core.ui.composable.button.ordinary.base

import androidx.compose.animation.core.EaseInCirc
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import dev.yaaum.common.core.ext.has
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonAnimation
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonColors
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonSizes
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonState
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme
import java.time.format.TextStyle

/**
 * Default style for ordinary button
 */
object YaaumOrdinaryButtonDefaults {

    val colors = object : YaaumButtonColors {
        @Composable
        override fun borderColor(interactionState: Int, enabled: Boolean): State<Color> {
            return rememberUpdatedState(
                when {
                    !enabled -> YaaumButtonForegroundDisabled
                    interactionState has YaaumButtonState.FOCUSED -> YaaumButtonBorderFocused
                    interactionState has YaaumButtonState.HOVER -> YaaumButtonForegroundHovered
                    else -> YaaumButtonForegroundNormal
                },
            )
        }

        @Composable
        override fun foregroundColor(interactionState: Int, enabled: Boolean): State<Color> {
            return rememberUpdatedState(
                when {
                    !enabled -> YaaumButtonForegroundDisabled
                    interactionState has YaaumButtonState.HOVER -> YaaumButtonForegroundHovered
                    else -> YaaumButtonForegroundNormal
                },
            )
        }

        @Composable
        override fun backgroundColor(interactionState: Int, enabled: Boolean): State<Color> {
            return rememberUpdatedState(
                when {
                    !enabled -> YaaumButtonBackgroundDisabled
                    interactionState has YaaumButtonState.PRESSED -> YaaumButtonBackgroundPressed
                    interactionState has YaaumButtonState.HOVER -> YaaumButtonBackgroundHovered
                    else -> YaaumButtonBackgroundNormal
                },
            )
        }
    }

    val sizes = object : YaaumButtonSizes {
        override val iconSize: Dp
            @Composable
            get() {
                return YaaumTheme.spacing.extraMedium
            }

        override val borderSize: Dp
            @Composable
            get() {
                return 0.dp
            }
        override val contentPadding: PaddingValues
            @Composable
            get() {
                return PaddingValues(
                    all = YaaumTheme.spacing.small,
                )
            }
        override val spacing: Dp
            @Composable
            get() {
                return YaaumTheme.spacing.extraSmall
            }
        override val minWidth: Dp
            @Composable
            get() {
                return YaaumTheme.spacing.large
            }
        override val minHeight: Dp
            @Composable
            get() {
                return YaaumTheme.spacing.large
            }
    }

    const val ANIMATION_DURATION = 125

    val animation = object : YaaumButtonAnimation {
        override val duration = ANIMATION_DURATION
        override val easing = EaseInCirc
    }

    @Suppress("MagicNumber")
    val shape = RoundedCornerShape(50)

    val textStyle: androidx.compose.ui.text.TextStyle
        @Composable
        get() {
            return YaaumTheme.typography.button
        }

    val YaaumButtonBorderFocused: Color
        @Composable
        get() {
            return YaaumTheme.colors.onPrimary
        }
    val YaaumButtonForegroundNormal: Color
        @Composable
        get() {
            return YaaumTheme.colors.onPrimary
        }

    val YaaumButtonForegroundHovered: Color
        @Composable
        get() {
            return YaaumTheme.colors.onPrimary
        }

    val YaaumButtonForegroundDisabled: Color
        @Composable
        get() {
            return YaaumTheme.colors.onSecondary
        }

    val YaaumButtonBackgroundNormal: Color
        @Composable
        get() {
            return YaaumTheme.colors.primary
        }

    val YaaumButtonBackgroundHovered: Color
        @Composable
        get() {
            return YaaumTheme.colors.primary
        }

    val YaaumButtonBackgroundPressed: Color
        @Composable
        get() {
            return YaaumTheme.colors.surface
        }

    val YaaumButtonBackgroundDisabled: Color
        @Composable
        get() {
            return YaaumTheme.colors.onPrimary
        }
}
