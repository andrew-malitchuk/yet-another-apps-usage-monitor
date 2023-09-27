package dev.yaaum.presentation.core.ui.composable.button.circle

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
import dev.yaaum.presentation.core.ui.composable.button.circle.base.YaaumCircleButton
import dev.yaaum.presentation.core.ui.composable.button.circle.base.YaaumCircleButtonDefaults
import dev.yaaum.presentation.core.ui.theme.YaaumTheme

/**
 * Project-level implementation for circle button
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
fun YaaumDefaultCircleButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    enabled: Boolean = true,
    colors: YaaumButtonColors = YaaumCircleButtonDefaults.colors,
    sizes: YaaumButtonSizes = YaaumCircleButtonDefaults.sizes,
    animation: YaaumButtonAnimation = YaaumCircleButtonDefaults.animation,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    YaaumCircleButton(
        onClick,
        modifier,
        icon,
        enabled,
        colors,
        sizes,
        animation,
        interactionSource,
    )
}

@Preview(showBackground = true)
@Composable
fun Preview_YaaumCircleButtonDefaults_Dark() {
    YaaumTheme(useDarkTheme = true) {
        YaaumDefaultCircleButton(
            onClick = { },
            icon = Icons.Default.Home,
        )
    }
}

@Preview(showBackground = true)
@Composable
fun Preview_YaaumCircleButtonDefaults_Light() {
    YaaumTheme(useDarkTheme = false) {
        YaaumDefaultCircleButton(
            onClick = { },
            icon = Icons.Default.Home,
        )
    }
}
