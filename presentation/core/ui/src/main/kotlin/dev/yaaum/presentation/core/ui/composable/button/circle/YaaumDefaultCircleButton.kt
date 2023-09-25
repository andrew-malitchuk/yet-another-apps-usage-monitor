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

@Preview(name = "Enabled", group = "Button", showBackground = true)
@Composable
fun Preview_YaaumCircleButtonDefaults_Enabled() {
    YaaumDefaultCircleButton(
        onClick = { },
        icon = Icons.Default.Home,
    )
}

@Preview(name = "Disabled", group = "Button", showBackground = true)
@Composable
fun Preview_YaaumCircleButtonDefaults_Disabled() {
    YaaumDefaultCircleButton(
        onClick = { },
        icon = Icons.Default.Home,
        enabled = false,
    )
}
