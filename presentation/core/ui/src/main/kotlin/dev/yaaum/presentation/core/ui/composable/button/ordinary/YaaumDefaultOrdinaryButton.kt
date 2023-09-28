package dev.yaaum.presentation.core.ui.composable.button.ordinary

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonAnimation
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonColors
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonSizes
import dev.yaaum.presentation.core.ui.composable.button.ordinary.base.YaaumOrdinaryButton
import dev.yaaum.presentation.core.ui.composable.button.ordinary.base.YaaumOrdinaryButtonDefaults
import dev.yaaum.presentation.core.ui.theme.YaaumTheme

/**
 * Top of ordinary button hierarchy
 *
 * @param text
 * @param onClick
 * @param modifier
 * @param icon
 * @param enabled
 * @param colors
 * @param sizes
 * @param textStyle
 * @param animation
 * @param interactionSource
 */
@Composable
fun YaaumDefaultOrdinaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    enabled: Boolean = true,
    colors: YaaumButtonColors = YaaumOrdinaryButtonDefaults.colors,
    sizes: YaaumButtonSizes = YaaumOrdinaryButtonDefaults.sizes,
    textStyle: androidx.compose.ui.text.TextStyle = YaaumOrdinaryButtonDefaults.textStyle,
    animation: YaaumButtonAnimation = YaaumOrdinaryButtonDefaults.animation,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    YaaumOrdinaryButton(
        text,
        onClick,
        modifier,
        icon,
        enabled,
        colors,
        sizes,
        textStyle,
        animation,
        interactionSource,
    )
}

@Preview(showBackground = true)
@Composable
fun Preview_YaaumDefaultOrdinaryButton_Dark() {
    YaaumTheme(useDarkTheme = true) {
        YaaumDefaultOrdinaryButton(
            text = "foobar",
            onClick = { },
            icon = Icons.Default.Home,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_YaaumDefaultOrdinaryButton_Light() {
    YaaumTheme(useDarkTheme = false) {
        YaaumDefaultOrdinaryButton(
            text = "foobar",
            onClick = { },
            icon = Icons.Default.Home,
        )
    }
}
