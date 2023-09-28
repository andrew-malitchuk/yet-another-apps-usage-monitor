package dev.yaaum.presentation.core.ui.composable.button.circle.base

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonAnimation
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonColors
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonSizes
import dev.yaaum.presentation.core.ui.composable.button.base.utils.stateButton
import dev.yaaum.presentation.core.ui.theme.YaaumTheme

/**
 * Top of circle-type button hierarchy
 *
 * Does not contain text - only icon
 *
 * Always circle.
 *
 * @param onClick
 * @param modifier
 * @param icon
 * @param enabled
 * @param colors
 * @param sizes
 * @param animation
 * @param interactionSource
 */
@Composable
fun YaaumCircleButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    enabled: Boolean = true,
    colors: YaaumButtonColors = YaaumCircleButtonDefaults.colors,
    sizes: YaaumButtonSizes = YaaumCircleButtonDefaults.sizes,
    animation: YaaumButtonAnimation = YaaumCircleButtonDefaults.animation,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    stateButton(
        null,
        onClick,
        icon,
        colors,
        sizes,
        YaaumCircleButtonDefaults.shape,
        null,
        animation,
        modifier,
        enabled,
        interactionSource,
    )
}

@Preview(showBackground = true)
@Composable
fun Preview_YaaumCircleButton_Dark() {
    YaaumTheme(useDarkTheme = true) {
        YaaumCircleButton(
            onClick = { },
            icon = Icons.Default.Home,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_YaaumCircleButton_Light() {
    YaaumTheme(useDarkTheme = false) {
        YaaumCircleButton(
            onClick = { },
            icon = Icons.Default.Home,
        )
    }
}
