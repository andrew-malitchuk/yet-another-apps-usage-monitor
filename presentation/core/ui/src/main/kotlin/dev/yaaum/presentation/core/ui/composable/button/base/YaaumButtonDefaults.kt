package dev.yaaum.presentation.core.ui.composable.button.base

import androidx.compose.animation.core.EaseInCirc
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp
import dev.yaaum.common.core.ext.has
import dev.yaaum.presentation.core.ui.R
import dev.yaaum.presentation.core.ui.theme.common.YaaumTheme

/**
 * Default style for button
 */
@Suppress("MagicNumber")
object YaaumButtonDefaults {
    val colors = object : YaaumButtonColors {
        @Composable
        override fun borderColor(interactionState: Int, enabled: Boolean): State<Color> {
            return rememberUpdatedState(
                when {
                    !enabled -> YaaumButtonForegroundDisabled
                    interactionState has YaaumButtonState.FOCUSED -> YaaumButtonBorderFocused
                    interactionState has YaaumButtonState.HOVER -> YaaumButtonForegroundHovered
                    else -> YaaumYaaumYaaumButtonForegroundNormal
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
                return YaaumTheme.spacing.default
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

    val animation = object : YaaumButtonAnimation {
        override val duration = 250
        override val easing = EaseInCirc
    }

    val shape = RoundedCornerShape(50)

    val textStyle = TextStyle(
        fontFamily = FontFamily(
            Font(
                R.font.ubuntu_bold,
                weight = FontWeight.Black,
                style = FontStyle.Normal,
            ),
        ),
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp,
    )

    val YaaumButtonBorderFocused = Color(0xFF00FFFF)
    val YaaumYaaumYaaumButtonForegroundNormal = Color(0xFF1C4587)
    val YaaumButtonForegroundNormal = Color.White
    val YaaumButtonForegroundHovered = Color(0xFF1C4587)
    val YaaumButtonForegroundDisabled = Color(0xFF666666)
    val YaaumButtonBackgroundNormal = Color(0XFF3C78D8)
    val YaaumButtonBackgroundHovered = Color(0xFFC9DAF8)
    val YaaumButtonBackgroundPressed = Color(0xFF1C4587)
    val YaaumButtonBackgroundDisabled = Color(0xFFEFEFEF)
}
