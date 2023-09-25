@file:Suppress("MagicNumber")

package dev.yaaum.presentation.core.ui.composable.button.base

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
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import androidx.compose.ui.unit.dp
import dev.yaaum.presentation.core.ui.composable.button.base.utils.stateButton

/**
 * https://proandroiddev.com/compose-a-compose-button-by-composing-composable-functions-9f275772bd23
 */
@Composable
fun YaaumButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    icon: ImageVector? = null,
    enabled: Boolean = true,
    colors: YaaumButtonColors = YaaumButtonDefaults.colors,
    sizes: YaaumButtonSizes = YaaumButtonDefaults.sizes,
    shape: Shape = YaaumButtonDefaults.shape,
    textStyle: TextStyle = YaaumButtonDefaults.textStyle,
    animation: YaaumButtonAnimation = YaaumButtonDefaults.animation,
    interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
) {
    stateButton(
        text,
        onClick,
        icon,
        colors,
        sizes,
        shape,
        textStyle,
        animation,
        modifier,
        enabled,
        interactionSource,
    )
}

@Preview(name = "Enabled", group = "Button", showBackground = true)
@Composable
fun ButtonPreview() {
    var showIcon by remember { mutableStateOf(true) }
    Box(modifier = Modifier.padding(24.dp)) {
        YaaumButton(
            text = LoremIpsum(1).values.first(),
            onClick = { showIcon = !showIcon },
            icon = if (showIcon) Icons.Default.Home else null,
        )
    }
}

@Preview(name = "Disabled", group = "Button", showBackground = true)
@Composable
fun ButtonDisabledPreview() {
    var showIcon by remember { mutableStateOf(true) }
    Box(modifier = Modifier.padding(24.dp)) {
        YaaumButton(
            text = LoremIpsum(1).values.first(),
            onClick = { showIcon = !showIcon },
            icon = if (showIcon) Icons.Default.Home else null,
            enabled = false,
        )
    }
}
