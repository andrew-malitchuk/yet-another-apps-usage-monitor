package dev.yaaum.presentation.core.ui.composable.button.circle.base

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonAnimation
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonColors
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonSizes
import dev.yaaum.presentation.core.ui.composable.button.base.utils.stateButton

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

@Preview(name = "Enabled", group = "Button", showBackground = true)
@Composable
fun Preview_YaaumCircleButton_Enabled() {
    var showIcon by remember { mutableStateOf(true) }
    Box(modifier = Modifier.padding(24.dp)) {
        YaaumCircleButton(
            onClick = { showIcon = !showIcon },
            icon = Icons.Default.Home,
        )
    }
}

@Preview(name = "Disabled", group = "Button", showBackground = true)
@Composable
fun Preview_YaaumCircleButton_Disabled() {
    var showIcon by remember { mutableStateOf(true) }
    Box(modifier = Modifier.padding(24.dp)) {
        YaaumCircleButton(
            onClick = { showIcon = !showIcon },
            icon = Icons.Default.Home,
            enabled = false,
        )
    }
}
