package dev.yaaum.presentation.core.ui.composable.button.ordinary.base

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonAnimation
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonColors
import dev.yaaum.presentation.core.ui.composable.button.base.YaaumButtonSizes
import dev.yaaum.presentation.core.ui.composable.button.base.utils.stateButton

@Composable
fun YaaumOrdinaryButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    enabled: Boolean = true,
    colors: YaaumButtonColors = YaaumOrdinaryButtonDefaults.colors,
    sizes: YaaumButtonSizes = YaaumOrdinaryButtonDefaults.sizes,
    textStyle: TextStyle?,
    animation: YaaumButtonAnimation = YaaumOrdinaryButtonDefaults.animation,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    stateButton(
        text,
        onClick,
        icon,
        colors,
        sizes,
        YaaumOrdinaryButtonDefaults.shape,
        textStyle,
        animation,
        modifier,
        enabled,
        interactionSource,
    )
}

@Preview(name = "Enabled", group = "Button", showBackground = true)
@Composable
fun Preview_YaaumOrdinaryButton_Enabled() {
    Box(modifier = Modifier.padding(24.dp)) {
        YaaumOrdinaryButton(
            text = "foobar",
            onClick = { },
            icon = Icons.Default.Home,
            textStyle = null,
        )
    }
}

@Preview(name = "Disabled", group = "Button", showBackground = true)
@Composable
fun Preview_YaaumOrdinaryButton_Disabled() {
    Box(modifier = Modifier.padding(24.dp)) {
        YaaumOrdinaryButton(
            text = "foobar",
            onClick = { },
            icon = Icons.Default.Home,
            enabled = false,
            textStyle = null,
        )
    }
}
