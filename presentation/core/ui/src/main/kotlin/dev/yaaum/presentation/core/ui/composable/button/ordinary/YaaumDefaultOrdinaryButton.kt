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
import java.time.format.TextStyle

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

@Preview(name = "Enabled", group = "Button", showBackground = true)
@Composable
fun Preview_YaaumCircleButtonDefaults_Enabled() {
    YaaumDefaultOrdinaryButton(
        text = "foobar",
        onClick = { },
        icon = Icons.Default.Home,
    )
}

@Preview(name = "Disabled", group = "Button", showBackground = true)
@Composable
fun Preview_YaaumCircleButtonDefaults_Disabled() {
    YaaumDefaultOrdinaryButton(
        text = "foobar",
        onClick = { },
        icon = Icons.Default.Home,
        enabled = false,
    )
}
